package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants.PneumaticConstants;

public class PneumaticsIOReal implements PneumaticsIO{
    PneumaticHub pneumaticHub = new PneumaticHub(PneumaticConstants.MODULE_NUMBER);  

    
    
    public final Solenoid SolenoidList[] = {
        new Solenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.T_SHIRT_SOLENOID_1_CHANNEL),
        new Solenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.T_SHIRT_SOLENOID_2_CHANNEL),
        new Solenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.T_SHIRT_SOLENOID_3_CHANNEL),
        new Solenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.T_SHIRT_SOLENOID_4_CHANNEL),
        new Solenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.T_SHIRT_SOLENOID_5_CHANNEL),
        new Solenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.T_SHIRT_SOLENOID_6_CHANNEL),
        new Solenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.T_SHIRT_SOLENOID_7_CHANNEL),
        new Solenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.T_SHIRT_SOLENOID_8_CHANNEL),
      };

@Override
public void set(int index, boolean state) {
    SolenoidList[(int)index].set(state);

}

@Override
public void updateInputs(PneumaticsIOInputs inputs) {
inputs.solenoidStates = new boolean[] {
    SolenoidList[0].get(),
    SolenoidList[1].get(),
    SolenoidList[2].get(),
    SolenoidList[3].get(),
    SolenoidList[4].get(),
    SolenoidList[5].get(),
    SolenoidList[6].get(),
    SolenoidList[7].get() 
};
    
}
    

    
}
