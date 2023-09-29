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
import utils.LoggedTunableNumber;

public class DriveIOCim implements DriveIO {
  private static final double GEAR_RATIO = 6.0;
  private static final double TICKS_PER_REV = 2048;

  private  TalonSRX leftLeader;
  private  TalonSRX rightLeader;
  private  TalonSRX leftFollower;
  private  TalonSRX rightFollower;

  private YAMLDataHolder m_constants = new YAMLDataHolder();

  private final Pigeon2 gyro;

  private LoggedTunableNumber kFrontLeft = new LoggedTunableNumber("kFrontLeft", (int)m_constants.getProperty("kFrontLeft"));
  private LoggedTunableNumber kFrontRight = new LoggedTunableNumber("kFrontRight", (int)m_constants.getProperty("kFrontRight"));
  private LoggedTunableNumber kRearLeft = new LoggedTunableNumber("kRearLeft", (int)m_constants.getProperty("kRearLeft"));
  private LoggedTunableNumber kRearRight = new LoggedTunableNumber("kRearRight", (int)m_constants.getProperty("kRearRight"));

  public DriveIOCim() {
    leftLeader = new TalonSRX((int) kFrontLeft.get());
    rightLeader = new TalonSRX((int) kFrontRight.get());
    leftFollower = new TalonSRX((int) kRearLeft.get());
    rightFollower = new TalonSRX((int) kRearRight.get());

    TalonSRXConfiguration config = new TalonSRXConfiguration();
    config.voltageCompSaturation = 12.0;
    leftLeader.configAllSettings(config);
    rightLeader.configAllSettings(config);

    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);
    leftLeader.setInverted(false);
    rightLeader.setInverted(false);
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

    if(kFrontLeft.hasChanged(hashCode()) || kFrontRight.hasChanged(hashCode()) || kRearLeft.hasChanged(hashCode()) || kRearRight.hasChanged(hashCode()))
    leftLeader = new TalonSRX((int) kFrontLeft.get());
    rightLeader = new TalonSRX((int) kFrontRight.get());
    leftFollower = new TalonSRX((int) kRearLeft.get());
    rightFollower = new TalonSRX((int) kRearRight.get());
  }

  @Override
  public void setVoltage(double leftVolts, double rightVolts) {
    // 9/28/2023 deadband added
    leftVolts /= 12.0;
    rightVolts /= 12.0;
    if (-0.01 < rightVolts && rightVolts < 0.01) {
      rightVolts = 0;
    }
    if (-0.01 < leftVolts && leftVolts < 0.01) {
      leftVolts = 0;
    }
    leftLeader.set(ControlMode.PercentOutput, leftVolts);
    rightLeader.set(ControlMode.PercentOutput, rightVolts);
  }
}