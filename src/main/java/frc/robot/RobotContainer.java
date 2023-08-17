// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;






import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.XboxController.Button;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants.OIConstants;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Pneumatics;

import frc.robot.commands.ArcadeDriveCommand;

import frc.robot.commands.ShootCommand;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;






/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  
  private final Pneumatics m_Pneumatics = new Pneumatics();
 

  
  Command shootshirt = new ShootCommand(m_Pneumatics);
  // The driver's controller
  XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);
  XboxController m_driverController2 = new XboxController(OIConstants.kDriverControllerPort);

  

  JoystickButton rightBumper = new JoystickButton(m_driverController, Button.kRightBumper.value);
  JoystickButton leftBumper = new JoystickButton(m_driverController, Button.kLeftBumper.value);

  int rightTriggerState = 0; // 0 is off, 1 is on press, 2 is being held.  
  int leftTriggerState = 0; // 0 is off, 1 is on press, 2 is being held.  
  

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    
    
 

    SmartDashboard.putData("Reset Solenoid Array",new InstantCommand(m_Pneumatics::ResetShootArray, m_Pneumatics));
    
     
      
   
      
   
      
    
  
   
        m_robotDrive.setDefaultCommand(
      
          new ArcadeDriveCommand(
                          m_robotDrive,
                          () -> -m_driverController.getLeftY(),
                          () -> -m_driverController.getLeftX())
          );
  }


  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
   * passing it to a
   * {@link JoystickButton}.
   */
  
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
 

  public int[] update_trigger_values(){
    int currentRightTriggerState = rightTriggerState;
    int currentLeftTriggerState = leftTriggerState;
    // Right Trigger
    if (m_driverController.getRightTriggerAxis() > 0.5){ // checks for press down past halfway
      // On press, it'll go to state one.
      // On hold, it'll go to state two, cause it'll be one when the loop checks again.
      if(currentRightTriggerState < 2){
        currentRightTriggerState += 1;
      }
    }
    else{
      currentRightTriggerState = 0;
    }

    // Left Trigger
    if (m_driverController.getLeftTriggerAxis() > 0.5){ // checks for press down past halfway
      // On press, it'll go to state one.
      // On hold, it'll go to state two, cause it'll be one when the loop checks again.
      if(currentLeftTriggerState < 2){
        currentLeftTriggerState += 1;
      }
    }
    else{
      currentLeftTriggerState = 0;
    }
    return new int[] {currentLeftTriggerState, currentRightTriggerState};
  }

  public void periodic(){
    //Updates the trigger values
    int[] updatedTriggerValues = update_trigger_values();
    leftTriggerState = updatedTriggerValues[0];
    rightTriggerState = updatedTriggerValues[1];
    // Checks if it can shoot
    if (m_Pneumatics.canShoot(leftTriggerState, rightTriggerState)){
      shootshirt.schedule();
    }
  }
}