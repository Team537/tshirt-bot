package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

import frc.robot.config.YAMLDataHolder;
import frc.robot.subsystems.pneumatics.PneumaticsIO;
import utils.LoggedTunableNumber;

public class PneumaticsIOReal implements PneumaticsIO {

    private YAMLDataHolder m_constants = new YAMLDataHolder();
    

    private LoggedTunableNumber MODULE_NUMBER = new LoggedTunableNumber("MODULE_NUMBER", (int) m_constants.getProperty("MODULE_NUMBER"));
    private LoggedTunableNumber m_tShirtSolenoid1Channel1 = new LoggedTunableNumber("T_SHIRT_SOLENOID_1_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_1_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid2Channel2 = new LoggedTunableNumber("T_SHIRT_SOLENOID_2_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_2_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid3Channel3 = new LoggedTunableNumber("T_SHIRT_SOLENOID_3_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_3_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid4Channel4 = new LoggedTunableNumber("T_SHIRT_SOLENOID_4_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_4_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid5Channel5 = new LoggedTunableNumber("T_SHIRT_SOLENOID_5_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_5_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid6Channel6 = new LoggedTunableNumber("T_SHIRT_SOLENOID_6_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_6_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid7Channel7 = new LoggedTunableNumber("T_SHIRT_SOLENOID_7_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_7_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid8Channel8 = new LoggedTunableNumber("T_SHIRT_SOLENOID_8_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_8_CHANNEL"));

    PneumaticHub pneumaticHub = new PneumaticHub((int) MODULE_NUMBER.get()); 

    
    
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
    

if(m_tShirtSolenoid1Channel1.hasChanged(hashCode()) || 
   m_tShirtSolenoid2Channel2.hasChanged(hashCode()) || 
   m_tShirtSolenoid3Channel3.hasChanged(hashCode()) || 
   m_tShirtSolenoid4Channel4.hasChanged(hashCode()) || 
   m_tShirtSolenoid5Channel5.hasChanged(hashCode()) || 
   m_tShirtSolenoid6Channel6.hasChanged(hashCode()) || 
   m_tShirtSolenoid7Channel7.hasChanged(hashCode()) || 
   m_tShirtSolenoid8Channel8.hasChanged(hashCode()) || 
   MODULE_NUMBER.hasChanged(hashCode())) {

    pneumaticHub = new PneumaticHub((int) MODULE_NUMBER.get()); 

    // SolenoidList[0] = new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid1Channel1.get());
    // SolenoidList[1] = new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid2Channel2.get());
    // SolenoidList[2] = new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid3Channel3.get());
    // SolenoidList[3] = new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid4Channel4.get());
    // SolenoidList[4] = new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid5Channel5.get());
    // SolenoidList[5] = new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid6Channel6.get());
    // SolenoidList[6] = new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid7Channel7.get());
    // SolenoidList[7] = new Solenoid(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid8Channel8.get());
}


}
    

    
}
