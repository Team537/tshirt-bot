package frc.robot.subsystems.actuator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ActuatorIOReal implements ActuatorIO {
    private WPI_TalonSRX actuator = new WPI_TalonSRX(0);

    @Override
    public void updateInputs(ActuatorIOInputs inputs) {
       inputs.setPower = actuator.getBusVoltage();
        
    }

    @Override
    public void setPower(double power) {
        actuator.set(power);
    }
    
}
