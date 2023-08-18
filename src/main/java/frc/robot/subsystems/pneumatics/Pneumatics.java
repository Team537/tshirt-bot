// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.pneumatics;

import frc.robot.config.YAMLDataHolder;
import utils.ExtendedXboxController;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  
  private PneumaticsIO pneumaticsIO;
  private PneumaticsIOInputsAutoLogged pneumaticsIOInputsAutoLogged = new PneumaticsIOInputsAutoLogged();
  private final Timer sincePressedTimer = new Timer();
  public boolean safety = false;
  public boolean cooldownReady = true;
  private ExtendedXboxController m_driverController;
  private YAMLDataHolder m_constants = new YAMLDataHolder();

  public Pneumatics(PneumaticsIO pneumaticsIO, ExtendedXboxController m_driverController) {
    this.pneumaticsIO = pneumaticsIO;
    this.m_driverController = m_driverController;
    
  }

  
  // private static int RforwardChannel =0;
  // private static int RreverseChannel =1;
  /** Creates a new Pneumatics. */
  


  
  public boolean canShoot(){ // int leftTriggerState, int rightTriggerState
     
    // System.out.println(m_driverController.getLeftTriggerAxis() + " " + m_driverController.getRightTriggerAxis());
    if (m_driverController.getLeftTriggerHeld()){ //If left trigger is being pressed
     
      // Restarts/starts time when the left trigger pressed down
      if(m_driverController.getLeftTriggerPressed()){
        sincePressedTimer.reset();
        sincePressedTimer.start();
      }

     

      // Checks if the right trigger just got pressed
    
        if (sincePressedTimer.hasElapsed((int) m_constants.getProperty("SAFETY_DELAY")) ){
          safety = true;
          if(m_driverController.getRightTriggerPressed()){
            System.out.println("FIRE THE MAIN CANNONS");
            sincePressedTimer.reset();
            safety = false;
          
            return true;
        
          } // Checks if the <SAFTEY_DELAY> has passed
           // Resets the timer if you shoot, so you have to wait again before firing
           
        }
        
        
        // Resets the timer if you press the right trigger
        // So you have to wait again before firing (Requiries a reset timer before the return true to work properly)
         
      
    } else {

      safety = false;

    }
    
    return false;
  }

  //non constant variables
  public int iSolenoid = 0;
  
  public boolean reset = false;
  public boolean arrayDone = false;

  public Pneumatics() {
    

  }

  public void Neutral() {
    // Neutralized valve # iSolenoid
    pneumaticsIO.set(iSolenoid, false);
    System.out.println("Barrel Neutral: " + iSolenoid);
  }

  public void OpenValve() {
    if (arrayDone == false) {

       
      // Opens valve # iSolenoid
      pneumaticsIO.set(iSolenoid, true);
      System.out.println("Barrel Opened: " + iSolenoid);
    }
  }

  public void CloseValve () {
    if (arrayDone == false) {
      
      // Closes valve # iSolenoid
      pneumaticsIO.set(iSolenoid, false);
      System.out.println("Barrel Closed: " + iSolenoid);

      // Iterates through the soliniods in Solenoid List
      iSolenoid += 1;
      System.out.println("Solendoid incremented to :" + iSolenoid);

      // Upon hitting the end of the list, set the iterator back to 0

      //autoloop removed
      if (iSolenoid >= pneumaticsIOInputsAutoLogged.solenoidStates.length) {
        arrayDone = true;
        // System.out.println("Solenoid List Reset");
      }
    }
  }

  public void ResetShootArray() {
    
   
      iSolenoid = 0;
      System.out.println("Solenoid iterator set to 0");
      
      arrayDone = false;
      //resets the bool so you dont accidently reset array again
      reset = false;
      
    

  }

  public void cooldownReady() {
   cooldownReady = true;
  }

  public void resetCooldownReady() {
    cooldownReady = false;
   }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber(" Active Solenoid Cycle Num", iSolenoid);
    SmartDashboard.putBoolean("Cooldown Ready", cooldownReady);
    SmartDashboard.putBoolean("Safety Ready", safety);
    SmartDashboard.putBoolean("Solenoid Array Done", arrayDone);
    

    pneumaticsIO.updateInputs(pneumaticsIOInputsAutoLogged);
    Logger.getInstance().processInputs("Solenoid States", pneumaticsIOInputsAutoLogged);
    Logger.getInstance().recordOutput(" Active Solenoid Cycle Num", iSolenoid);
    Logger.getInstance().recordOutput("Cooldown Ready", cooldownReady);
    Logger.getInstance().recordOutput("Safety Ready", safety);
    Logger.getInstance().recordOutput("Solenoid Array Done", arrayDone);
   
    

    

  }


  
}
