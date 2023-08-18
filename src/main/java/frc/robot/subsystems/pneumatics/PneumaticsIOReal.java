package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

import frc.robot.config.YAMLDataHolder;
import frc.robot.subsystems.pneumatics.PneumaticsIO;

public class PneumaticsIOReal implements PneumaticsIO {

    private YAMLDataHolder m_constants = new YAMLDataHolder();
    PneumaticHub pneumaticHub = new PneumaticHub((int) m_constants.getProperty("MODULE_NUMBER")); 


    
    
    public final Solenoid SolenoidList[] = {
        new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_1_CHANNEL")),
        new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_2_CHANNEL")),
        new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_3_CHANNEL")),
        new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_4_CHANNEL")),
        new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_5_CHANNEL")),
        new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_6_CHANNEL")),
        new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_7_CHANNEL")),
        new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_8_CHANNEL")),
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
