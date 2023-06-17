package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.RotateArm;
import frc.robot.subsystems.ArmSubsystem;

public class Robot extends TimedRobot {
  private ArmSubsystem armSubsystem;
  private RotateArm rotateArmCommand;

  @Override
  public void robotInit() {
    armSubsystem = new ArmSubsystem();
    rotateArmCommand = new RotateArm(armSubsystem);
  }

  @Override
  public void autonomousInit() {
    rotateArmCommand.schedule();
  }

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }
}
