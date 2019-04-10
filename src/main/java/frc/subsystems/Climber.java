/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  
  private static Climber instance;
  private TalonSRX lift;
  private TalonSRX leftDrive;
  private TalonSRX rightDrive;

  private Climber(){

    // lift = new TalonSRX(RobotMap.lift);
    // leftDrive = new TalonSRX(RobotMap.leftLiftDrive);
    // rightDrive = new TalonSRX(RobotMap.rightLiftDrive);

    lift.setNeutralMode(NeutralMode.Brake);

  }

  public static Climber getInstance() {

    if (instance == null) {

      return instance = new Climber();

    } else {

      return instance;

    }
  
  }

  public void setLift(double setPoint) {

    lift.set(ControlMode.PercentOutput, setPoint);

  }
  
  public double getLiftPosition() {

    return lift.getSelectedSensorPosition();

  }

  public void setLiftLocomotion(double setPoint) {

    rightDrive.set(ControlMode.PercentOutput, setPoint);
    leftDrive.set(ControlMode.PercentOutput, setPoint);

  }

  @Override
  protected void initDefaultCommand() {

  }

}
