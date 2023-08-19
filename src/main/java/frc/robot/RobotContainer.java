// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;




import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.drive.DifferentialDriveSubsystem;
import frc.robot.subsystems.drive.DriveIO;
import frc.robot.subsystems.drive.DriveIOCim;
import frc.robot.subsystems.drive.DriveIOSim;
import frc.robot.subsystems.pneumatics.Pneumatics;
import frc.robot.subsystems.pneumatics.PneumaticsIO;
import frc.robot.subsystems.pneumatics.PneumaticsIOReal;
import frc.robot.subsystems.pneumatics.PneumaticsIOSim;
import frc.robot.subsystems.simulation.FieldSim;
import utils.ExtendedXboxController;
import utils.LoggedTunableNumber;
import frc.robot.commands.ShootCommand;

import frc.robot.config.YAMLDataHolder;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
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
  // private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  
  private final DifferentialDriveSubsystem m_robotDrive;
  private final FieldSim m_fieldSim;
  private final Pneumatics m_Pneumatics;
  private YAMLDataHolder m_constants = new YAMLDataHolder();
 

  Command shootshirt;
  
  // The driver's controller
 

  LoggedTunableNumber kDriverControllerPort = new LoggedTunableNumber("kDriverControllerPort", (int)m_constants.getProperty("kDriverControllerPort"));
 
 ExtendedXboxController m_driverController = new ExtendedXboxController((int)kDriverControllerPort.get());
  

  JoystickButton rightBumper = new JoystickButton(m_driverController, Button.kRightBumper.value);
  JoystickButton leftBumper = new JoystickButton(m_driverController, Button.kLeftBumper.value);

  int rightTriggerState = 0; // 0 is off, 1 is on press, 2 is being held.  
  int leftTriggerState = 0; // 0 is off, 1 is on press, 2 is being held.  
  

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    
   

   
    
     m_constants.init();

      

     
      
    switch ((String)m_constants.getProperty("currentMode")) {

      
      // Real robot, instantiate hardware IO implementations
      case "REAL":
        m_robotDrive = new DifferentialDriveSubsystem(new DriveIOCim());
        m_fieldSim = new FieldSim(m_robotDrive);
        m_Pneumatics = new Pneumatics(new PneumaticsIOReal(),m_driverController);
        shootshirt = new ShootCommand(m_Pneumatics);
       
       
        // drive = new Drive(new DriveIOFalcon500());
        // flywheel = new Flywheel(new FlywheelIOFalcon500());
        break;

      // Sim robot, instantiate physics sim IO implementations
      case "SIM":
      m_robotDrive  = new DifferentialDriveSubsystem(new DriveIOSim());
      m_fieldSim = new FieldSim(m_robotDrive);
      m_Pneumatics = new Pneumatics(new PneumaticsIOSim(),m_driverController);
      shootshirt = new ShootCommand(m_Pneumatics);
      
        
        break;

      // Replayed robot, disable IO implementations
      default:
      m_robotDrive  =  new DifferentialDriveSubsystem(new DriveIO() {
        });
        m_Pneumatics = new Pneumatics(new PneumaticsIO(){},m_driverController);
        m_fieldSim = new FieldSim(m_robotDrive);
        shootshirt = new ShootCommand(m_Pneumatics);
       
        break;

         
    }
 

    SmartDashboard.putData("Shooter/Reset Solenoid Array",new InstantCommand(m_Pneumatics::ResetShootArray, m_Pneumatics));
    
     
      
   
      
   
      
    
  
   
        m_robotDrive.setDefaultCommand(
      
             new RunCommand(() -> m_robotDrive.driveArcade(-m_driverController.getLeftY(), -m_driverController.getLeftX()), m_robotDrive));
        
             

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
  
  

  
  public void onDisable(){


    m_constants.saveData();
  }

  public void periodic(){

    m_constants.periodic();
    
    if(kDriverControllerPort.hasChanged(hashCode())) {
      m_driverController = new ExtendedXboxController((int)kDriverControllerPort.get());

      m_Pneumatics.setXboxController(m_driverController);
    }


    //Updates the trigger values
    m_driverController.periodic();
    // Checks if it can shoot
    if (m_Pneumatics.canShoot()){
      shootshirt.schedule();
    }

    m_fieldSim.periodic();

    
    
    

    
    
  }
}