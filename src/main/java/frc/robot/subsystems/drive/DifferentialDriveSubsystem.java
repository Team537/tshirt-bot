package frc.robot.subsystems.drive;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DifferentialDriveSubsystem extends SubsystemBase {
  

  private final DriveIO io;
  private final DriveIOInputsAutoLogged inputs = new DriveIOInputsAutoLogged();
  private final DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(new Rotation2d(), 0.0, 0.0);

  /** Creates a new Drive. */
  public DifferentialDriveSubsystem(DriveIO io) {
    this.io = io;
  }

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.getInstance().processInputs("Drive", inputs);

    // Update odometry and log the new pose
    odometry.update(new Rotation2d(-inputs.gyroYawRad), getLeftPositionMeters(), getRightPositionMeters());
    Logger.getInstance().recordOutput("Odometry", getPose());
  }

  /** Run open loop at the specified percentage. */
  public void drivePercent(double leftPercent, double rightPercent) {
    io.setVoltage(leftPercent * 12.0, rightPercent * 12.0);
  }

  /** Run open loop based on stick positions. */
  public void driveArcade(double xSpeed, double zRotation) {
    var speeds = DifferentialDrive.arcadeDriveIK(xSpeed, zRotation*0.5, true);
    io.setVoltage(speeds.left * 12.0, speeds.right * 12.0);
  }

  /** Stops the drive. */
  public void stop() {
    io.setVoltage(0.0, 0.0);
  }

  /** Returns the current odometry pose in meters. */
  public Pose2d getPose() {
    return odometry.getPoseMeters();
  }

  /** Returns the position of the left wheels in meters. */
  public double getLeftPositionMeters() {
    return inputs.leftPositionRad * DriveConstants.wheelRadius;
  }

  /** Returns the position of the right wheels in meters. */
  public double getRightPositionMeters() {
    return inputs.rightPositionRad * DriveConstants.wheelRadius;
  }

  /** Returns the velocity of the left wheels in meters/second. */
  public double getLeftVelocityMeters() {
    return inputs.leftVelocityRadPerSec * DriveConstants.wheelRadius;
  }

  /** Returns the velocity of the right wheels in meters/second. */
  public double getRightVelocityMeters() {
    return inputs.rightVelocityRadPerSec * DriveConstants.wheelRadius;
  }
}