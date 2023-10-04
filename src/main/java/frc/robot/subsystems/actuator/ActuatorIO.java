package frc.robot.subsystems.actuator;

import org.littletonrobotics.junction.AutoLog;

public interface ActuatorIO {

    @AutoLog
    public static class ActuatorIOInputs{
        public double setPower;
    }
    
    public default void updateInputs(ActuatorIOInputs inputs) {
    }

    public default void setPower(double power) {
    }
}
