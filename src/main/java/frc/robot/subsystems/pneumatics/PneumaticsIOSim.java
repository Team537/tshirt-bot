package frc.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

import edu.wpi.first.wpilibj.simulation.SolenoidSim;

import frc.robot.config.YAMLDataHolder;

public class PneumaticsIOSim implements PneumaticsIO {
    private YAMLDataHolder m_constants = new YAMLDataHolder();
    

    public final SolenoidSim SolenoidList[] = {
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_1_CHANNEL")),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_2_CHANNEL")),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_3_CHANNEL")),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_4_CHANNEL")),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_5_CHANNEL")),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_6_CHANNEL")),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_7_CHANNEL")),
        new SolenoidSim(PneumaticsModuleType.CTREPCM, (int) m_constants.getProperty("T_SHIRT_SOLENOID_8_CHANNEL")),
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
    
}
}
