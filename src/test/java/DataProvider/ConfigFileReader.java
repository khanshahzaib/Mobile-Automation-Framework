package DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    //    private final String propertyFilePath= "D:\\GitHub-Clone\\custom_bdd_framework\\src\\test\\java\\Configs\\Configuration.properties";
//    private final String propertyFilePath= "C:\\Users\\SO-LPT-011\\IdeaProjects\\Shahzaib_SourceCode\\custom_bdd_framework\\src\\test\\java\\Configs\\Configuration.properties";

    //region This function is used to read the Key Value Pairs from the Config File
    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src//test//resources//Configuration//Config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }
    //endregion

    public String getDriverName() {
        String driverName = properties.getProperty("driverName");
        if (driverName != null) return driverName;
        else throw new RuntimeException("driverName not specified in the Configuration.properties file.");
    }

    public String getApkName() {
        String apkName = properties.getProperty("apkName");
        if (apkName != null) return apkName;
        else throw new RuntimeException("apkName not specified in the Configuration.properties file.");
    }

    public String getApkPath() {
        String apkPath = properties.getProperty("app");
        if (apkPath != null) return apkPath;
        else throw new RuntimeException("apkPath not specified in the Configuration.properties file.");
    }

    public String getPlatformName() {
        String platformName = properties.getProperty("platformName");
        if (platformName != null) return platformName;
        else throw new RuntimeException("platformName not specified in the Configuration.properties file.");
    }

    public String getDeviceName() {
        String deviceName = properties.getProperty("deviceName");
        if (deviceName != null) return deviceName;
        else throw new RuntimeException("deviceName not specified in the Configuration.properties file.");
    }

    public String getDeviceNameEmulator() {
        String deviceName = properties.getProperty("deviceNameEmulator");
        if (deviceName != null) return deviceName;
        else throw new RuntimeException("deviceName not specified in the Configuration.properties file.");
    }

    public String getPlatformVersion() {
        String platformVersion = properties.getProperty("platformVersion");
        if (platformVersion != null) return platformVersion;
        else throw new RuntimeException("platformVersion not specified in the Configuration.properties file.");
    }

    public String getUnExpectedBehaviour() {
        String unExpectedBehaviour = properties.getProperty("unExpectedBehaviour");
        if (unExpectedBehaviour != null) return unExpectedBehaviour;
        else throw new RuntimeException("unExpectedBehaviour not specified in the Configuration.properties file.");
    }

    public String getUniCodeKeyboard() {
        String uniCodeKeyboard = properties.getProperty("uniCodeKeyboard");
        if (uniCodeKeyboard != null) return uniCodeKeyboard;
        else throw new RuntimeException("uniCodeKeyboard not specified in the Configuration.properties file.");
    }

    public String getResetKeyboard() {
        String resetKeyboard = properties.getProperty("resetKeyboard");
        if (resetKeyboard != null) return resetKeyboard;
        else throw new RuntimeException("resetKeyboard not specified in the Configuration.properties file.");
    }

    public String getNoReset() {
        String noReset = properties.getProperty("noReset");
        if (noReset != null) return noReset;
        else throw new RuntimeException("noReset not specified in the Configuration.properties file.");
    }

    public String getAutomationName1() {
        String automationName = properties.getProperty("automationName1");
        if (automationName != null) return automationName;
        else throw new RuntimeException("automationName not specified in the Configuration.properties file.");
    }

    public String getAutomationName2() {
        String automationName = properties.getProperty("automationName2");
        if (automationName != null) return automationName;
        else throw new RuntimeException("automationName not specified in the Configuration.properties file.");
    }

    public String getAppiumServerEndpoint() {
        String appiumServerEndpoint = properties.getProperty("appiumServerEndpoint");
        if (appiumServerEndpoint != null) return appiumServerEndpoint;
        else throw new RuntimeException("appiumServerEndpoint not specified in the Configuration.properties file.");
    }

    public Integer getImplicitWaitTime() {
        Integer implicitWaitTime = Integer.parseInt(properties.getProperty("implicitWaitTime"));
        if (implicitWaitTime != null) return implicitWaitTime;
        else throw new RuntimeException("implicitWaitTime not specified in the Configuration.properties file.");
    }

    public String getImplicitWaitTimeUnit() {
        String implicitWaitTimeUnit = properties.getProperty("implicitWaitTimeUnit");
        if (implicitWaitTimeUnit != null) return implicitWaitTimeUnit;
        else throw new RuntimeException("implicitWaitTimeUnit not specified in the Configuration.properties file.");
    }

    //region This Function is used to get key value of a Selendroid App Keywords File Path
    public String getSelendroidAppKeywords() {
        String excelPath = properties.getProperty("selendroidKeywords");
        if (excelPath != null) return excelPath;
        else throw new RuntimeException("SelendroidAppKeywords not specified in the Configuration.properties file.");
    }
    //endregion
}
