package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RotateArm;
import frc.robot.subsystems.ArmSubsystem;

public class RobotContainer {
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  private final RotateArm rotateArmCommand = new RotateArm(armSubsystem);

  private final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
  private final JoystickButton rotateButton = new JoystickButton(joystick, Constants.ROTATE_BUTTON_ID);

  public RobotContainer() {
    rotateButton.whenPressed(rotateArmCommand);
  }

  public Command getAutonomousCommand() {
    return rotateArmCommand;
  }
}
