package frc.robot.subsystems.actuator;


import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Actuator extends SubsystemBase {
    private ActuatorIO io;
    private ActuatorIOInputsAutoLogged inputs = new ActuatorIOInputsAutoLogged();
    private double upPower = 0.5;
    private double downPower = -0.5;

    public Actuator(ActuatorIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
       io.updateInputs(inputs);
       Logger.getInstance().processInputs("Actuator", inputs);


    }

    public void actuateUp() {
        io.setPower(upPower);
        System.out.println("Actuator is going up");
    }

    public void actuateDown() {
        io.setPower(downPower);
        System.out.println("Actuator is going down");
    }

    public void stop() {
        io.setPower(0.0);
        System.out.println("Actuator is stopped");
    }
    
}
