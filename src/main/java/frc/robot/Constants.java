// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveConstants {

    /*public static final int kFrontLeft = 9;
    public static final int kRearLeft = 3;
    public static final int kFrontRight = 5;
    public static final int kRearRight = 7;*/

    //For Bolt Testing 
    
     public static final int kFrontLeft = 11;
     public static final int kRearLeft = 13;
     public static final int kFrontRight = 1;
     public static final int kRearRight = 3;
    

    public static final double kTrackwidthMeters = 0.8509;
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
        kTrackwidthMeters);

    public static final int kEncoderCPR = 2048;
    public static final double kWheelDiameterMeters = 0.1524;
    public static final double kEncoderDistancePerPulse =
        // Assumes the encoders are directly mounted on the wheel shafts
        (kWheelDiameterMeters * Math.PI) / (double) kEncoderCPR;

    // These are example values only - DO NOT USE THESE FOR YOUR OWN ROBOT!
    // These characterization values MUST be determined either experimentally or
    // theoretically
    // for *your* robot's drive.
    // The Robot Characterization Toolsuite provides a convenient tool for obtaining
    // these
    // values for your robot.
    public static final double ksVolts = 0.305;
    public static final double kvVoltSecondsPerMeter = 2.29;
    public static final double kaVoltSecondsSquaredPerMeter = 0.0131;

    // Example value only - as above, this must be tuned for your drive!
    public static final double kPDriveVel = 8.5;


    //Gyro Command Constants
    public static final double kTurnP = 8.5;
    public static final double kTurnI = 0;
    public static final double kTurnD = 0;
    public static final double kTurnToleranceDeg = 4;
    public static final double kTurnRateToleranceDegPerS = 1;




  }

  public static final class PneumaticConstants {

    public static final int MODULE_NUMBER = 1;
    public static final int T_SHIRT_SOLENOID_1_CHANNEL = 0;
    public static final int T_SHIRT_SOLENOID_2_CHANNEL = 1;
    public static final int T_SHIRT_SOLENOID_3_CHANNEL = 2;
    public static final int T_SHIRT_SOLENOID_4_CHANNEL = 3;
    public static final int T_SHIRT_SOLENOID_5_CHANNEL = 4;
    public static final int T_SHIRT_SOLENOID_6_CHANNEL = 5;
    public static final int T_SHIRT_SOLENOID_7_CHANNEL = 6;
    public static final int T_SHIRT_SOLENOID_8_CHANNEL = 7;

    public static final float SAFTEY_DELAY = 1;
  }


  


  

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
  }

  public final static class Conversions {

    public static double metersToFeet(double meters) {
      return meters * 3.28084;
    }

    public static double feetToMeters(double feet) {
      return feet * 0.3048;
    }

    public static double ticksToFeet(double ticks) {
      return (ticks / 4096) * (1 / 7.3529411) * 2 * Math.PI * (3 / 12);
    }

    public static double ticksToFeetPerSecond(double ticksPer100ms) {
      return (ticksPer100ms / 4096) * (1 / 7.3529411) * 2 * Math.PI * (3 / 12) * 10;
    }

    public static double ticksToMetersWheel(double ticks) {
      return (ticks / 4096.00) * (1.00 / 7.3529411) * 2 * Math.PI * (0.0762);
    }

    public static double ticksToMetersPerSecondWheel(double ticksPer100ms) {
      return (ticksPer100ms / 4096.00) * (1.00 / 7.3529411) * 2 * Math.PI * (0.0762) * 10;
    }

    public static double degreesToTicks(double angle) {
      return 4096.00 * (angle / 360.00);
    }

  }

  

  public static class kGains {

    public static final double kP = 0.000102;
    public static final double kI = 0.0;
    public static final double kD = 0.000438;
    public static final double kF = 0.0;
  }

  public static class GyroPID {
    public static final double kP = 0.0;
    public static final double kI = 0.0;
    public static final double kD = 0.0;
  }

  public static final int kTimeoutMs = 10;
  public static final int kPIDLoopIdx = 0;
  public static final int kSlotIdx = 0;
  public static final double targetMeters = 2 * (6 * 2048 * 0.4787787204060999);
  //gear ratio is 6:1 
  public static final int smoothing = 4;
  //Smoothing is from 0 to 8


  
  public static class ShootCommandConsants {
    public static final double SECONDS = 1;
  }
}
