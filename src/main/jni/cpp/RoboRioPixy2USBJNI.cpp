//
// begin license header
//
// This file is part of Pixy CMUcam5 or "Pixy" for short
//
// All Pixy source code is provided under the terms of the
// GNU General Public License v2 (http://www.gnu.org/licenses/gpl-2.0.html).
// Those wishing to use Pixy source code, software and/or
// technologies under different licensing terms should contact us at
// cmucam@cs.cmu.edu. Such licensing terms are available for
// all portions of the Pixy codebase presented here.
//
// end license header
//
#include <jni.h>
#include <iostream>
#include <sstream>
#include <thread>
#include <chrono>

#include "RoboRioPixy2USBJNI.h"
#include "libpixyusb2.h"

#include <cameraserver/CameraServer.h>
#include <opencv2/core/core.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <opencv2/highgui/highgui.hpp>

Pixy2 pixy;
cs::UsbCamera camera;
cs::UsbCamera camera1;
uint8_t *bayerFrame;
cs::CvSource outputStreamStd;
cv::Mat bayerMat(PIXY2_RAW_FRAME_HEIGHT, PIXY2_RAW_FRAME_WIDTH, CV_8U);
cv::Mat output(PIXY2_RAW_FRAME_HEIGHT, PIXY2_RAW_FRAME_WIDTH, CV_8UC3);

JNIEXPORT jint JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBInit(JNIEnv *env, jobject thisObj) {
   std::cout << "pixy2 usb init" << std::endl;
   return pixy.init();
}

JNIEXPORT void JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBGetVersion(JNIEnv *env, jobject thisObj) {
   std::cout << "pixy2 usb get version" << std::endl;
   pixy.version->print();
   return;
}

JNIEXPORT void JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBLampOn(JNIEnv *env, jobject thisObj) {
   std::cout << "pixy2 usb Lamp On" << std::endl;
   pixy.setLamp(0x01, 0x00);
   return;
}

JNIEXPORT void JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBLampOff(JNIEnv *env, jobject thisObj) {
   std::cout << "pixy2 usb Lamp Off" << std::endl;
   pixy.setLamp(0x00, 0x00);
   return;
}

JNIEXPORT void JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBStartCameraServer(JNIEnv *env, jobject thisObj)
{
   std::cout << "Starting CameraServer..." << std::endl;
   // Uncomment these to get more regular USB cameras
  camera = frc::CameraServer::GetInstance()->StartAutomaticCapture(0);
  camera.SetResolution(320, 240);
//   camera1 = frc::CameraServer::GetInstance()->StartAutomaticCapture(1);
//   camera1.SetResolution(640, 480);
   
   // need to call stop() before calling getRawFrame().
   // Note, you can call getRawFrame multiple times after calling stop().
   // That is, you don't need to call stop() each time.
   pixy.m_link.stop();
   outputStreamStd = frc::CameraServer::GetInstance()->PutVideo("Pixy 2 Camera", PIXY2_RAW_FRAME_WIDTH, PIXY2_RAW_FRAME_HEIGHT);
}

JNIEXPORT void JNICALL Java_frc_robot_vision_Pixy2USBJNI_pixy2USBLoopCameraServer(JNIEnv *env, jobject thisObj)
{
   // grab raw frame, BGGR Bayer format, 1 byte per pixel
   pixy.m_link.getRawFrame(&bayerFrame);
   // convert Bayer frame to RGB frame
   bayerMat.data = bayerFrame;

   // Reticle overlay example using OpenCV
   cv::cvtColor(bayerMat, output, cv::COLOR_BayerBG2RGB);
   cv::circle(output, cv::Point(158, 104), 50, cv::Scalar(255, 0, 0, 0.4), 2);
   cv::line(output, cv::Point(108, 104), cv::Point(208, 104), cv::Scalar(255, 0, 0, 0.4), 2);
   cv::line(output, cv::Point(158, 54), cv::Point(158, 154), cv::Scalar(255, 0, 0, 0.4), 2);

   // Rectangle examples
   // cv::rectangle(output, cv::Point(79, 52), cv::Point(237, 156), cv::Scalar(255, 0, 0), 2);
   // cv::rectangle(output, cv::Point(79, 52), cv::Point(237, 156), cv::Scalar(255, 0, 0), 2);
   
   outputStreamStd.PutFrame(output);
   // Call resume() to resume the current program, otherwise Pixy will be left in "paused" state.
   pixy.m_link.resume();
   pixy.m_link.stop();
}
