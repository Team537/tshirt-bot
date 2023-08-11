package frc.robot.subsystems.pneumatics;

import java.lang.Cloneable;
import java.lang.Override;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public class PneumaticsIOInputsAutoLogged extends PneumaticsIO.PneumaticsIOInputs implements LoggableInputs, Cloneable {
  @Override
  public void toLog(LogTable table) {
    table.put("SolenoidStates", solenoidStates);
  }

  @Override
  public void fromLog(LogTable table) {
    solenoidStates = table.getBooleanArray("SolenoidStates", solenoidStates);
  }

  public PneumaticsIOInputsAutoLogged clone() {
    PneumaticsIOInputsAutoLogged copy = new PneumaticsIOInputsAutoLogged();
    copy.solenoidStates = this.solenoidStates.clone();
    return copy;
  }
}
