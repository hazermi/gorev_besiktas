package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;

import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;

public class RotateArm extends CommandBase {
  private final TalonFX motor;

  public RotateArm(ArmSubsystem armSubsystem) {
    motor = armSubsystem.getMotor();
    addRequirements(armSubsystem);

    TalonFXConfiguration talonConfig = new TalonFXConfiguration();
    talonConfig.slot0.kP = Constants.PID_P;
    talonConfig.slot0.kI = Constants.PID_I;
    talonConfig.slot0.kD = Constants.PID_D;
    talonConfig.slot0.kF = Constants.PID_F;

    motor.configAllSettings(talonConfig);
  }

  @Override
  public void execute() {
    double targetPositionDegrees = Constants.TARGET_POSITION_DEGREES;
    double targetPositionRotations = targetPositionDegrees / 360.0;
    double targetPositionUnits = targetPositionRotations * 2048;

    motor.set(ControlMode.Position, targetPositionUnits);
  }

  @Override
  public boolean isFinished() {
    return Math.abs(motor.getClosedLoopError()) < Constants.POSITION_TOLERANCE;
  }
}
