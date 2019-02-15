# TestPixy2USBCameraServer
TestPixy2USBCameraServer uses the Pixy2 USB libraries compiled specifically for the roboRIO.

This code is still an active work-in-progress and as such still has some glitchiness when it comes to deploying the code for the first time.

## Getting started

This code seems to be mostly working, but it might have some bugs. I once had to delete the file /usr/local/frc/third-party/lib/libusb-1.0.so
after a fresh restart, but I'm not sure if that was just a remnant of my having tested this library before.

Don't forget that the robot must be enabled in order to Send any commands like the ToggleLampCommand.
