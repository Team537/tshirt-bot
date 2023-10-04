package frc.robot.subsystems.actuator;

import java.lang.Cloneable;
import java.lang.Override;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public class ActuatorIOInputsAutoLogged extends ActuatorIO.ActuatorIOInputs implements LoggableInputs, Cloneable {
  @Override
  public void toLog(LogTable table) {
    table.put("SetPower", setPower);
  }

  @Override
  public void fromLog(LogTable table) {
    setPower = table.getDouble("SetPower", setPower);
  }

  public ActuatorIOInputsAutoLogged clone() {
    ActuatorIOInputsAutoLogged copy = new ActuatorIOInputsAutoLogged();
    copy.setPower = this.setPower;
    return copy;
  }
}
