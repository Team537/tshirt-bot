package frc.robot.subsystems.actuator;

import com.ctre.phoenix.motorcontrol.TalonSRXSimCollection;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ActuatorIOSim implements ActuatorIO {
    private WPI_TalonSRX actuator = new WPI_TalonSRX(0);
    private TalonSRXSimCollection sim = actuator.getSimCollection();

    @Override
    public void updateInputs(ActuatorIOInputs inputs) {
       inputs.setPower = sim.getMotorOutputLeadVoltage();
        
    }

    @Override
    public void setPower(double power) {
        actuator.set(power);
        sim.setBusVoltage(actuator.getBusVoltage());
    }
    
}
