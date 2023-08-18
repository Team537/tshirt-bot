package frc.robot.subsystems.drive;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import frc.robot.Constants.DriveConstants;

public class DriveIOSim implements DriveIO {
  private DifferentialDrivetrainSim sim = DifferentialDrivetrainSim.createKitbotSim(KitbotMotor.kDualCIMPerSide,
      KitbotGearing.k10p71, KitbotWheelSize.kSixInch, null);

  @Override
  public void updateInputs(DriveIOInputs inputs) {
    sim.update(0.02);
    inputs.leftPositionRad = sim.getLeftPositionMeters() / DriveConstants.wheelRadius;
    inputs.leftVelocityRadPerSec = sim.getLeftVelocityMetersPerSecond() /  DriveConstants.wheelRadius;
    inputs.rightPositionRad = sim.getRightPositionMeters() /  DriveConstants.wheelRadius;
    inputs.rightVelocityRadPerSec = sim.getRightVelocityMetersPerSecond() /  DriveConstants.wheelRadius;
    inputs.gyroYawRad = sim.getHeading().getRadians() * -1;
  }

  @Override
  public void setVoltage(double leftVolts, double rightVolts) {
    sim.setInputs(MathUtil.clamp(leftVolts, -12.0, 12.0), MathUtil.clamp(rightVolts, -12.0, 12.0));
  }
}