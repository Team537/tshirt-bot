// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import org.littletonrobotics.junction.LogFileUtil;
import org.littletonrobotics.junction.LoggedRobot;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.networktables.NT4Publisher;
import org.littletonrobotics.junction.wpilog.WPILOGReader;
import org.littletonrobotics.junction.wpilog.WPILOGWriter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants.DriveConstants;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends LoggedRobot {
  
 

     
  private RobotContainer m_robotContainer;
  //private Intake m_intake = new Intake();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    Logger.getInstance().recordMetadata("ProjectName", BuildConstants.MAVEN_NAME); // Set a metadata value
    SmartDashboard.putString("ProjectName", BuildConstants.MAVEN_NAME); // Set a metadata value
    Logger.getInstance().recordMetadata("BuildDate", BuildConstants.BUILD_DATE);
    SmartDashboard.putString("BuildDate", BuildConstants.BUILD_DATE);
    Logger.getInstance().recordMetadata("GitSHA", BuildConstants.GIT_SHA);
    SmartDashboard.putString("GitSHA", BuildConstants.GIT_SHA);
    Logger.getInstance().recordMetadata("GitDate", BuildConstants.GIT_DATE);
    SmartDashboard.putString("GitDate", BuildConstants.GIT_DATE);
    Logger.getInstance().recordMetadata("GitBranch", BuildConstants.GIT_BRANCH);
    SmartDashboard.putString("GitBranch", BuildConstants.GIT_BRANCH);
    switch (BuildConstants.DIRTY) {
      case 0:
        Logger.getInstance().recordMetadata("GitDirty", "All changes committed");
        SmartDashboard.putString("GitDirty", "All changes committed");
        break;
      case 1:
        Logger.getInstance().recordMetadata("GitDirty", "Uncomitted changes");
        SmartDashboard.putString("GitDirty", "Uncomitted changes");
        break;
      default:
        Logger.getInstance().recordMetadata("GitDirty", "Unknown");
        SmartDashboard.putString("GitDirty", "Unknown");
        break;
    }

    switch (DriveConstants.currentMode) {
      // Running on a real robot, log to a USB stick
      case REAL:
      Logger.getInstance().addDataReceiver(new WPILOGWriter("/home/lvuser"));
      Logger.getInstance().addDataReceiver(new NT4Publisher());
        break;

      // Running a physics simulator, log to local folder
      case SIM:
      Logger.getInstance().addDataReceiver(new WPILOGWriter(""));
      Logger.getInstance().addDataReceiver(new NT4Publisher());
        break;

      // Replaying a log, set up replay source
      case REPLAY:
        setUseTiming(false); // Run as fast as possible
        String logPath = LogFileUtil.findReplayLog();
        Logger.getInstance().setReplaySource(new WPILOGReader(logPath));
        Logger.getInstance().addDataReceiver(new WPILOGWriter(LogFileUtil.addPathSuffix(logPath, "_sim")));
        break;
    }


       Logger.getInstance().start(); // Start logging! No more data receivers, replay sources, or metadata values may be added.


    
    
  
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
   
    CommandScheduler.getInstance().run();
    SmartDashboard.putData(CommandScheduler.getInstance()); 
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {

   
  }

  @Override
  public void disabledPeriodic() {

  
  }

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {

   
  }
  

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    
  }

  @Override
  public void teleopInit() {

    // M_arm.ArmDown();
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
   
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    m_robotContainer.periodic();
  
    
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {
    m_robotContainer.periodic();
  }
}
