package frc.robot.subsystems.pneumatics;

import org.littletonrobotics.junction.AutoLog;

public interface PneumaticsIO {
    @AutoLog
  public static class PneumaticsIOInputs {
    public boolean[] solenoidStates = new boolean[] { false, false, false, false, false, false, false, false };
    
  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(PneumaticsIOInputs inputs) {
  }

  public default void set(int index,boolean state) {

  }

  



  
}
