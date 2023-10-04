// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase {
  /** Creates a new LED. */
  private static Spark m_blinkin = new Spark(0);
  
  public LED() {}

  public void FancyRainbow() {
    m_blinkin.set(-0.97);
  }
  public void FancyConfetti() {
    m_blinkin.set(-0.87);
  }
  

  
}
