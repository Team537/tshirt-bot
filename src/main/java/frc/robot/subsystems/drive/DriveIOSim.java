package frc.robot.subsystems.drive;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;

import frc.robot.config.YAMLDataHolder;
import utils.LoggedTunableNumber;

public class DriveIOSim implements DriveIO {
  private DifferentialDrivetrainSim sim = DifferentialDrivetrainSim.createKitbotSim(KitbotMotor.kDualCIMPerSide,
      KitbotGearing.k10p71, KitbotWheelSize.kSixInch, null);

  private YAMLDataHolder m_constants = new YAMLDataHolder();
  private LoggedTunableNumber wheelRadius = new LoggedTunableNumber("wheelRadius", (double) m_constants.getProperty("wheelRadius"));
  @Override
  public void updateInputs(DriveIOInputs inputs) {
    sim.update(0.02);
    inputs.leftPositionRad = sim.getLeftPositionMeters() /(double) wheelRadius.get();
    inputs.leftVelocityRadPerSec = sim.getLeftVelocityMetersPerSecond() /  (double)  wheelRadius.get();
    inputs.rightPositionRad = sim.getRightPositionMeters() /(double)  wheelRadius.get();
    inputs.rightVelocityRadPerSec = sim.getRightVelocityMetersPerSecond() / (double)  wheelRadius.get();
    inputs.gyroYawRad = sim.getHeading().getRadians() * -1;
  }

  @Override
  public void setVoltage(double leftVolts, double rightVolts) {
    sim.setInputs(MathUtil.clamp(leftVolts, -12.0, 12.0), MathUtil.clamp(rightVolts, -12.0, 12.0));
  }
}