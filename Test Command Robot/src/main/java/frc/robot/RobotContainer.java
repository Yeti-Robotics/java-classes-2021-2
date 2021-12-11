// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.IntakeCommandGroup;
import frc.robot.commands.IntakeStopCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  Joystick driverstation;
  DrivetrainSubsystem drivetrainSubsystem;
  IntakeSubsystem intakeSubsystem;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driverstation = new Joystick(0);
    drivetrainSubsystem = new DrivetrainSubsystem();
    intakeSubsystem = new IntakeSubsystem();
    // Configure the button bindings
    configureButtonBindings();
    drivetrainSubsystem.setDefaultCommand(
        new RunCommand(() -> drivetrainSubsystem.drive(-driverstation.getRawAxis(0), -driverstation.getRawAxis(2)),
            drivetrainSubsystem));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton button1 = new JoystickButton(driverstation, 1);
    button1.whenPressed(new IntakeCommand(intakeSubsystem));
    JoystickButton button2 = new JoystickButton(driverstation, 2);
    button2.whenPressed(new IntakeStopCommand(intakeSubsystem));
    JoystickButton button3 = new JoystickButton(driverstation, 3);
    button3.whenPressed(new IntakeCommandGroup(intakeSubsystem, drivetrainSubsystem));
    JoystickButton autoButton = new JoystickButton(driverstation, 6);
    autoButton.whenPressed(new SequentialCommandGroup(
        new RunCommand(() -> drivetrainSubsystem.drive(.4, .4), drivetrainSubsystem).withTimeout(2),
        new RunCommand(() -> drivetrainSubsystem.drive(.2, -.2), drivetrainSubsystem).withTimeout(2),
        new RunCommand(() -> drivetrainSubsystem.drive(.4, .4), drivetrainSubsystem).withTimeout(2),
        new RunCommand(() -> drivetrainSubsystem.drive(-.2, .2), drivetrainSubsystem).withTimeout(2),
        new RunCommand(() -> drivetrainSubsystem.drive(.4, .4), drivetrainSubsystem).withTimeout(2),
        new RunCommand(() -> drivetrainSubsystem.drive(.2, -.2), drivetrainSubsystem).withTimeout(2),
        new RunCommand(() -> drivetrainSubsystem.drive(.4, .4), drivetrainSubsystem).withTimeout(2)));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
