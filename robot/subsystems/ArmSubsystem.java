package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class ArmSubsystem extends SubsystemBase {
  private TalonFX motor;

  public ArmSubsystem() {
    motor = new TalonFX(Constants.ARM_MOTOR_PORT);
  }

  public TalonFX getMotor() {
    return motor;
  }
}
