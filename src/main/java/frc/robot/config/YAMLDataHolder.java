package frc.robot.config;

import org.littletonrobotics.junction.networktables.LoggedDashboardNumber;
import org.yaml.snakeyaml.Yaml;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class YAMLDataHolder {
   
    private Map<String, Object> properties  = loadPropertiesFromFile();


  

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    public void saveData() {
        savePropertiesToFile();
        
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> loadPropertiesFromFile() {
        try {
            Yaml yaml = new Yaml();
            FileReader reader = new FileReader(Filesystem.getDeployDirectory() + "/resources/Constants.yaml");
            return yaml.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>(); // Return an empty map if loading fails
    }

    private void savePropertiesToFile() {
        try {
            Yaml yaml = new Yaml();
            FileWriter writer = new FileWriter(Filesystem.getDeployDirectory() + "/resources/Constants.yaml");
            yaml.dump(properties, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void init() {
    //  LoggedDashboardNumber kFrontLeft = new LoggedDashboardNumber("kFrontLeft",(Integer) getProperty("kFrontLeft"));
    //  LoggedDashboardNumber kFrontRight  = new LoggedDashboardNumber("kFrontRight",(Integer) getProperty("kFrontRight"));
    //  LoggedDashboardNumber kRearLeft  = new LoggedDashboardNumber("kRearLeft",(Integer) getProperty("kRearLeft"));
    //  LoggedDashboardNumber  kRearRight  = new LoggedDashboardNumber("kRearRight",(Integer) getProperty("kRearRight"));
    //  LoggedDashboardNumber kTrackWidthMeters = new LoggedDashboardNumber("kTrackWidthMeters",(Double) getProperty("kTrackwidthMeters"));
    //  LoggedDashboardNumber wheelRadius = new LoggedDashboardNumber("wheelRadius",(Double) getProperty("wheelRadius"));
    //  LoggedDashboardNumber kEncoderCPR = new LoggedDashboardNumber("kEncoderCPR",(Integer) getProperty("kEncoderCPR"));
    //  LoggedDashboardNumber kWheelDiameterMeters = new LoggedDashboardNumber("kWheelDiameterMeters",(Double) getProperty("kWheelDiameterMeters"));
    //  LoggedDashboardNumber MODULE_NUMBER  = new LoggedDashboardNumber("MODULE_NUMBER",(Integer) getProperty("MODULE_NUMBER"));
    //  LoggedDashboardNumber T_SHIRT_SOLENOID_1_CHANNEL = new LoggedDashboardNumber("T_SHIRT_SOLENOID_1_CHANNEL",(Integer) getProperty("T_SHIRT_SOLENOID_1_CHANNEL"));
    //  LoggedDashboardNumber T_SHIRT_SOLENOID_2_CHANNEL  = new LoggedDashboardNumber("T_SHIRT_SOLENOID_2_CHANNEL",(Integer) getProperty("T_SHIRT_SOLENOID_2_CHANNEL"));
    //  LoggedDashboardNumber T_SHIRT_SOLENOID_3_CHANNEL  = new LoggedDashboardNumber("T_SHIRT_SOLENOID_3_CHANNEL",(Integer) getProperty("T_SHIRT_SOLENOID_3_CHANNEL"));
    //  LoggedDashboardNumber T_SHIRT_SOLENOID_4_CHANNEL  = new LoggedDashboardNumber("T_SHIRT_SOLENOID_4_CHANNEL",(Integer) getProperty("T_SHIRT_SOLENOID_4_CHANNEL"));
    //  LoggedDashboardNumber T_SHIRT_SOLENOID_5_CHANNEL  = new LoggedDashboardNumber("T_SHIRT_SOLENOID_5_CHANNEL",(Integer) getProperty("T_SHIRT_SOLENOID_5_CHANNEL"));
    //  LoggedDashboardNumber  T_SHIRT_SOLENOID_6_CHANNEL = new LoggedDashboardNumber("T_SHIRT_SOLENOID_6_CHANNEL",(Integer) getProperty("T_SHIRT_SOLENOID_6_CHANNEL"));
    //  LoggedDashboardNumber T_SHIRT_SOLENOID_7_CHANNEL  = new LoggedDashboardNumber("T_SHIRT_SOLENOID_7_CHANNEL",(Integer) getProperty("T_SHIRT_SOLENOID_7_CHANNEL"));
    //  LoggedDashboardNumber  T_SHIRT_SOLENOID_8_CHANNEL  = new LoggedDashboardNumber("T_SHIRT_SOLENOID_8_CHANNEL",(Integer) getProperty("T_SHIRT_SOLENOID_8_CHANNEL"));
    //  LoggedDashboardNumber  SAFETY_DELAY  = new LoggedDashboardNumber("SAFETY_DELAY",(Integer) getProperty("SAFETY_DELAY"));
    // //  LoggedDashboardNumber kDriverControllerPort  = new LoggedDashboardNumber("kDriverControllerPort",(Integer) getProperty("kDriverControllerPort"));
    //  LoggedDashboardNumber SECONDS = new LoggedDashboardNumber("SECONDS",(Integer) getProperty("SECONDS"));

    }

    public void periodic() {

        int frontLeft = (int)SmartDashboard.getNumber("TunableNumbers/kFrontLeft", (Integer) getProperty("kFrontLeft"));
        int frontRight = (int)SmartDashboard.getNumber("TunableNumbers/kFrontRight", (Integer) getProperty("kFrontRight"));
        int rearLeft = (int)SmartDashboard.getNumber("TunableNumbers/kRearLeft", (Integer) getProperty("kRearLeft"));
        int rearRight = (int)SmartDashboard.getNumber("TunableNumbers/kRearRight", (Integer) getProperty("kRearRight"));
        double kTrackWidthMeters = (double)SmartDashboard.getNumber("kTrackWidthMeters", (Double) getProperty("kTrackwidthMeters"));
        double wheelRadius = (double)SmartDashboard.getNumber("TunableNumbers/wheelRadius", (Double) getProperty("wheelRadius"));
        int kEncoderCPR = (int)SmartDashboard.getNumber("kEncoderCPR", (Integer) getProperty("kEncoderCPR"));
        double kWheelDiameterMeters = (double)SmartDashboard.getNumber("kWheelDiameterMeters", (Double) getProperty("kWheelDiameterMeters"));
        int MODULE_NUMBER = (int)SmartDashboard.getNumber("TunableNumbers/MODULE_NUMBER", (Integer) getProperty("MODULE_NUMBER"));
        int T_SHIRT_SOLENOID_1_CHANNEL = (int)SmartDashboard.getNumber("TunableNumbers/T_SHIRT_SOLENOID_1_CHANNEL", (Integer) getProperty("T_SHIRT_SOLENOID_1_CHANNEL"));
        int T_SHIRT_SOLENOID_2_CHANNEL = (int)SmartDashboard.getNumber("TunableNumbers/T_SHIRT_SOLENOID_2_CHANNEL", (Integer) getProperty("T_SHIRT_SOLENOID_2_CHANNEL"));
        int T_SHIRT_SOLENOID_3_CHANNEL = (int)SmartDashboard.getNumber("TunableNumbers/T_SHIRT_SOLENOID_3_CHANNEL", (Integer) getProperty("T_SHIRT_SOLENOID_3_CHANNEL"));
        int T_SHIRT_SOLENOID_4_CHANNEL = (int)SmartDashboard.getNumber("TunableNumbers/T_SHIRT_SOLENOID_4_CHANNEL", (Integer) getProperty("T_SHIRT_SOLENOID_4_CHANNEL"));
        int T_SHIRT_SOLENOID_5_CHANNEL = (int)SmartDashboard.getNumber("TunableNumbers/T_SHIRT_SOLENOID_5_CHANNEL", (Integer) getProperty("T_SHIRT_SOLENOID_5_CHANNEL"));
        int T_SHIRT_SOLENOID_6_CHANNEL = (int)SmartDashboard.getNumber("TunableNumbers/T_SHIRT_SOLENOID_6_CHANNEL", (Integer) getProperty("T_SHIRT_SOLENOID_6_CHANNEL"));
        int T_SHIRT_SOLENOID_7_CHANNEL = (int)SmartDashboard.getNumber("TunableNumbers/T_SHIRT_SOLENOID_7_CHANNEL", (Integer) getProperty("T_SHIRT_SOLENOID_7_CHANNEL"));
        int T_SHIRT_SOLENOID_8_CHANNEL = (int)SmartDashboard.getNumber("TunableNumbers/T_SHIRT_SOLENOID_8_CHANNEL", (Integer) getProperty("T_SHIRT_SOLENOID_8_CHANNEL"));
        int SAFETY_DELAY = (int)SmartDashboard.getNumber("TunableNumbers/SAFETY_DELAY", (Integer) getProperty("SAFETY_DELAY"));
        int driverControllerPort = (int)SmartDashboard.getNumber("TunableNumbers/kDriverControllerPort", (Integer) getProperty("kDriverControllerPort"));
        int SECONDS = (int)SmartDashboard.getNumber("TunableNumbers/SECONDS", (Integer) getProperty("SECONDS"));
    
        
        
        setProperty("kFrontLeft", frontLeft);
        setProperty("kFrontRight", frontRight);
        setProperty("kRearLeft", rearLeft);
        setProperty("kRearRight", rearRight);
        setProperty("kTrackwidthMeters", kTrackWidthMeters);
        setProperty("wheelRadius", wheelRadius);
        setProperty("kEncoderCPR", kEncoderCPR);
        setProperty("kWheelDiameterMeters", kWheelDiameterMeters);
        setProperty("MODULE_NUMBER", MODULE_NUMBER);
        setProperty("T_SHIRT_SOLENOID_1_CHANNEL", T_SHIRT_SOLENOID_1_CHANNEL);
        setProperty("T_SHIRT_SOLENOID_2_CHANNEL", T_SHIRT_SOLENOID_2_CHANNEL);
        setProperty("T_SHIRT_SOLENOID_3_CHANNEL", T_SHIRT_SOLENOID_3_CHANNEL);
        setProperty("T_SHIRT_SOLENOID_4_CHANNEL", T_SHIRT_SOLENOID_4_CHANNEL);
        setProperty("T_SHIRT_SOLENOID_5_CHANNEL", T_SHIRT_SOLENOID_5_CHANNEL);
        setProperty("T_SHIRT_SOLENOID_6_CHANNEL", T_SHIRT_SOLENOID_6_CHANNEL);
        setProperty("T_SHIRT_SOLENOID_7_CHANNEL", T_SHIRT_SOLENOID_7_CHANNEL);
        setProperty("T_SHIRT_SOLENOID_8_CHANNEL", T_SHIRT_SOLENOID_8_CHANNEL);
        setProperty("SAFETY_DELAY", SAFETY_DELAY);
        setProperty("kDriverControllerPort", driverControllerPort);
        setProperty("SECONDS", SECONDS);
    
        saveData();


    }
}
