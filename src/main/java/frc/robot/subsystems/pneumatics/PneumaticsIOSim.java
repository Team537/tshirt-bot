package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

import edu.wpi.first.wpilibj.simulation.SolenoidSim;

import frc.robot.config.YAMLDataHolder;
import utils.LoggedTunableNumber;

public class PneumaticsIOSim implements PneumaticsIO {
    private YAMLDataHolder m_constants = new YAMLDataHolder();
    
    
    private LoggedTunableNumber m_tShirtSolenoid1Channel1 = new LoggedTunableNumber("T_SHIRT_SOLENOID_1_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_1_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid2Channel2 = new LoggedTunableNumber("T_SHIRT_SOLENOID_2_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_2_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid3Channel3 = new LoggedTunableNumber("T_SHIRT_SOLENOID_3_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_3_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid4Channel4 = new LoggedTunableNumber("T_SHIRT_SOLENOID_4_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_4_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid5Channel5 = new LoggedTunableNumber("T_SHIRT_SOLENOID_5_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_5_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid6Channel6 = new LoggedTunableNumber("T_SHIRT_SOLENOID_6_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_6_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid7Channel7 = new LoggedTunableNumber("T_SHIRT_SOLENOID_7_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_7_CHANNEL"));
    private LoggedTunableNumber m_tShirtSolenoid8Channel8 = new LoggedTunableNumber("T_SHIRT_SOLENOID_8_CHANNEL", (int) m_constants.getProperty("T_SHIRT_SOLENOID_8_CHANNEL"));

    public final SolenoidSim SolenoidList[] = {
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid1Channel1.get()),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid2Channel2.get()),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid3Channel3.get()),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid4Channel4.get()),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid5Channel5.get()),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid6Channel6.get()),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid7Channel7.get()),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid8Channel8.get()),
      };
      
      @Override
      public void set(int index, boolean state) {
          SolenoidList[(int)index].setOutput(state);
      
      }

      @Override
public void updateInputs(PneumaticsIOInputs inputs) {
    
inputs.solenoidStates = new boolean[] {
    SolenoidList[0].getOutput(),
    SolenoidList[1].getOutput(),
    SolenoidList[2].getOutput(),
    SolenoidList[3].getOutput(),
    SolenoidList[4].getOutput(),
    SolenoidList[5].getOutput(),
    SolenoidList[6].getOutput(),
    SolenoidList[7].getOutput() 
};
if(m_tShirtSolenoid1Channel1.hasChanged(hashCode()) || 
m_tShirtSolenoid2Channel2.hasChanged(hashCode()) || 
m_tShirtSolenoid3Channel3.hasChanged(hashCode()) || 
m_tShirtSolenoid4Channel4.hasChanged(hashCode()) || 
m_tShirtSolenoid5Channel5.hasChanged(hashCode()) || 
m_tShirtSolenoid6Channel6.hasChanged(hashCode()) || 
m_tShirtSolenoid7Channel7.hasChanged(hashCode()) || 
m_tShirtSolenoid8Channel8.hasChanged(hashCode()) 
) {


 SolenoidList[0] = new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid1Channel1.get());
 SolenoidList[1] = new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid2Channel2.get());
 SolenoidList[2] = new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid3Channel3.get());
 SolenoidList[3] = new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid4Channel4.get());
 SolenoidList[4] = new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid5Channel5.get());
 SolenoidList[5] = new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid6Channel6.get());
 SolenoidList[6] = new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid7Channel7.get());
 SolenoidList[7] = new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_tShirtSolenoid8Channel8.get());
}
}
}
