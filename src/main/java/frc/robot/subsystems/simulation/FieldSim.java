// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.simulation;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import frc.robot.subsystems.drive.DifferentialDriveSubsystem;

/**
 * 
 * Simulates Field in Simulations
 */

public class FieldSim {
  private final DifferentialDriveSubsystem m_drive;

  private final Field2d m_field2d = new Field2d();

  

  public FieldSim(DifferentialDriveSubsystem m_drive) {
    this.m_drive = m_drive;
  }

  public void initSim() {
  }

  public Field2d getField2d() {
    return m_field2d;
  }

  public void setTrajectory(Trajectory trajectory) {
    m_field2d.getObject("trajectory").setTrajectory(trajectory);
  }

  public void resetRobotPose(Pose2d pose) {
    m_field2d.setRobotPose(pose);
  }

  private void updateRobotPoses() {
    m_field2d.setRobotPose(m_drive.getPose());

    // for (ModulePosition i : ModulePosition.values()) {
    // Translation2d updatedPositions = SwerveConstants.kModuleTranslations
    // .get(i)
    // .rotateBy(m_drive.getPose().getRotation())
    // .plus(m_drive.getPose().getTranslation());

    // }

   
  }

  public void periodic() {
    updateRobotPoses();

    if (RobotBase.isSimulation())
      simulationPeriodic();

    SmartDashboard.putData("Drive/Field2d", m_field2d);
  }

  public void simulationPeriodic() {
  }
}
