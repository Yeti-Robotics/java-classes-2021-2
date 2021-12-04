// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  VictorSPX intakeVictor;
  DoubleSolenoid intakePiston;

  public IntakeSubsystem() {
    intakeVictor = new VictorSPX(8);
    intakePiston = new DoubleSolenoid(0, 7);
  }
  public void intakeIn() {
    intakeVictor.set(ControlMode.PercentOutput, 1);
  }
  public void intakeOut() {
    intakeVictor.set(ControlMode.PercentOutput, -1);
  }
  public void extend() {
    intakePiston.set(Value.kForward);
  }
  public void retract() {
    intakePiston.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
