package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.math.util.Units;


import frc.robot.config.YAMLDataHolder;

public class DriveIOCim implements DriveIO {
  private static final double GEAR_RATIO = 6.0;
  private static final double TICKS_PER_REV = 2048;

  private final TalonSRX leftLeader;
  private final TalonSRX rightLeader;
  private final TalonSRX leftFollower;
  private final TalonSRX rightFollower;

  private YAMLDataHolder m_constants = new YAMLDataHolder();

  private final Pigeon2 gyro;

  public DriveIOCim() {
    leftLeader = new TalonSRX((int)m_constants.getProperty("kFrontLeft"));
    rightLeader = new TalonSRX((int)m_constants.getProperty("kFrontRight"));
    leftFollower = new TalonSRX((int)m_constants.getProperty("kRearLeft"));
    rightFollower = new TalonSRX((int)m_constants.getProperty("kRearRight"));

    TalonSRXConfiguration config = new TalonSRXConfiguration();
    config.voltageCompSaturation = 12.0;
    leftLeader.configAllSettings(config);
    rightLeader.configAllSettings(config);

    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);
    leftLeader.setInverted(false);
    rightLeader.setInverted(true);
    leftFollower.setInverted(InvertType.FollowMaster);
    rightFollower.setInverted(InvertType.FollowMaster);

    gyro = new Pigeon2(0);
  }

  @Override
  public void updateInputs(DriveIOInputs inputs) {
    inputs.leftPositionRad = Units.rotationsToRadians(
        leftLeader.getSelectedSensorPosition() / TICKS_PER_REV / GEAR_RATIO);
    inputs.rightPositionRad = Units.rotationsToRadians(
        rightLeader.getSelectedSensorPosition() / TICKS_PER_REV / GEAR_RATIO);
    inputs.leftVelocityRadPerSec = Units.rotationsPerMinuteToRadiansPerSecond(
        leftLeader.getSelectedSensorVelocity() * 10 / TICKS_PER_REV / GEAR_RATIO);
    inputs.rightVelocityRadPerSec = Units.rotationsPerMinuteToRadiansPerSecond(
        rightLeader.getSelectedSensorVelocity() * 10 / TICKS_PER_REV / GEAR_RATIO);
    inputs.gyroYawRad = gyro.getYaw();
  }

  @Override
  public void setVoltage(double leftVolts, double rightVolts) {
    leftLeader.set(ControlMode.PercentOutput, leftVolts / 12.0);
    rightLeader.set(ControlMode.PercentOutput, rightVolts / 12.0);
  }
}