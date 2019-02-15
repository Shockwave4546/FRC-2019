/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team4546.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4546.robot.Robot;
import frc.team4546.robot.vision.Block;

public class FollowBall extends Command {
    public FollowBall() {

    }
  
    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }
  
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
     
    }
  
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      return false;
    }
  
    // Called once after isFinished returns true
    @Override
    protected void end() {
    }
  
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
  
    public double getClosestBallPos(){
      int closestPos = 99999;
      Block[] blocks = Robot.pixy2USBJNI.blocksBuffer.poll();
      if((blocks!= null) && blocks.length > 0){
        for(Block b: blocks){
          if(b.sig ==1 && (b.x - 300) < closestPos){
            closestPos = b.x - 300/2;
            System.out.println(closestPos);
          }
        }
      }
  
      return closestPos;
    }
  }