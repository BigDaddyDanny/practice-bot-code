/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.subsystems.Arm.ArmState;

public class Auto extends CommandGroup {
  
  public Auto() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.

    addSequential(new MoveForward(3));
    addSequential(new WaitCommand(1));
    addSequential(new MoveArm(ArmState.CARGO_HIGH, true));
    addSequential(new WaitCommand(2));
    addSequential(new MoveForward(500));
    addSequential(new PlaceBall());
    addSequential(new MoveBack(2));
    addSequential(new MoveArm(ArmState.DOWN, true));
    addSequential(new Turn(-90));
    

  }
}
