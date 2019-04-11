/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.subsystems.Drivetrain;

public class MoveForward extends Command {
 
  private  double distance;
  private final double FEET_TO_TICKS = 4.738089561462402;

  public MoveForward(double feet) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    distance = feet * FEET_TO_TICKS;
    distance -= ((FEET_TO_TICKS / 12) * 4);

    start();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    Drivetrain.getInstance().zero();
    Drivetrain.getInstance().setSpeed(.3, 0);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    double offset = 0;
    if(Drivetrain.getInstance().getRightPosition() > Drivetrain.getInstance().getLeftPosition()){
      offset = -.1;
    }else if(Drivetrain.getInstance().getLeftPosition() > Drivetrain.getInstance().getRightPosition()){
      offset = .1;
    }

    Drivetrain.getInstance().setSpeed(-.3, offset);



  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Drivetrain.getInstance().getPos() >= distance;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Drivetrain.getInstance().setSpeed(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
