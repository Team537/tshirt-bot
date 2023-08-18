package utils;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ExtendedXboxController extends XboxController {

    int leftTriggerState = 0, rightTriggerState = 0;

    
    public ExtendedXboxController(int port) {
        super(port);
        //TODO Auto-generated constructor stub
    }

    public int[] update_trigger_values(){
        int currentRightTriggerState = rightTriggerState;
        int currentLeftTriggerState = leftTriggerState;
        // Right Trigger
        if (currentRightTriggerState == 0 && super.getRightTriggerAxis() > 0.5){ // checks for press down past halfway
          currentRightTriggerState = 1; 
        }
        else if(currentRightTriggerState == 1  && super.getRightTriggerAxis() > 0.5 ){
            currentRightTriggerState = 2;
        }
        else if (super.getRightTriggerAxis() < 0.5){
          currentRightTriggerState = 0;
        }
    
        // Left Trigger
        if (currentLeftTriggerState == 0 && super.getLeftTriggerAxis() > 0.5){ // checks for press down past halfway
            currentLeftTriggerState = 1; 
          }
          else if(currentLeftTriggerState == 1  && super.getLeftTriggerAxis() > 0.5 ){
              currentLeftTriggerState = 2;
          }
          else if (super.getLeftTriggerAxis() < 0.5){
            currentLeftTriggerState = 0;
          }
        return new int[] {currentLeftTriggerState, currentRightTriggerState};
    }
    

    public void periodic(){
       
        //Updates the trigger values
        int[] updatedTriggerValues = update_trigger_values();
        leftTriggerState = updatedTriggerValues[0];
        rightTriggerState = updatedTriggerValues[1];
        SmartDashboard.putNumber("Left Trigger", leftTriggerState);
        SmartDashboard.putNumber("Right Trigger", rightTriggerState);
        
    }

    public boolean getRightTriggerPressed(){
        
        return rightTriggerState == 1;
        
    }

    public boolean getRightTriggerHeld(){
        
        return rightTriggerState >= 1;
    }

    public boolean getLeftTriggerPressed(){
        return leftTriggerState == 1;
    }

    public boolean getLeftTriggerHeld(){
        return leftTriggerState >= 1;
    }
}
