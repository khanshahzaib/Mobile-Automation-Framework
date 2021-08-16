package Utilities;

import Base.BaseUtil;
import DataProvider.ConfigFileReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {

    ConfigFileReader configFileReader = new ConfigFileReader();

    private BaseUtil base;
    public String myDriver = configFileReader.getDriverName();

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before("@A_Register")
    public void setUpAppium() throws MalformedURLException {
        System.out.println("### BEFORE HOOK Triggered");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (myDriver) {
            case "iOS": {
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
                capabilities.setCapability(MobileCapabilityType.APP, "Users/cc/Downloads/MyApp.app");
                capabilities.setCapability("noReset", true);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new AppiumDriver(url, capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                break;
            }
            case "Android": {
                try {
                    capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME,configFileReader.getApkName());
                } catch (NumberFormatException nfe) {
                    System.out.println("## catch exception ##");
                    nfe.printStackTrace();
                }
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, configFileReader.getPlatformName());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,configFileReader.getPlatformVersion());
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, configFileReader.getDeviceName());
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, configFileReader.getAutomationName1());
                capabilities.setCapability(MobileCapabilityType.APP, configFileReader.getApkPath());
                capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                capabilities.setCapability("unicodeKeyboard", true);
                capabilities.setCapability("resetKeyboard", false);
                capabilities.setCapability("noReset", true);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new AppiumDriver(url, capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(
                        configFileReader.getImplicitWaitTime(),
                        TimeUnit.SECONDS);
                ReadExcel.readExcelFile();
                break;
            }
            case "Emulator": {
                System.out.println("## Config file works ##");

                try {
                    capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME,configFileReader.getApkName());
                } catch (NumberFormatException nfe) {
                    System.out.println("## catch exception ##");
                    nfe.printStackTrace();
                }
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, configFileReader.getPlatformName());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,configFileReader.getPlatformVersion());
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, configFileReader.getDeviceNameEmulator());
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, configFileReader.getAutomationName1());
                capabilities.setCapability(MobileCapabilityType.APP, configFileReader.getApkPath());
                capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                capabilities.setCapability("unicodeKeyboard", true);
                capabilities.setCapability("resetKeyboard", false);
                capabilities.setCapability("noReset", true);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new AppiumDriver(url, capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(
                        configFileReader.getImplicitWaitTime(),
                        TimeUnit.SECONDS);
                ReadExcel.readExcelFile();
                break;
            }
            default:
                System.out.println("This is a Web Page");
                System.out.println(configFileReader.getDriverName());
                break;
        }
    }

    @After("@A_Register")
    public void TearDownTest(Scenario scenario) {

        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
            appiumDriver.quit();
            return;
        }

        appiumDriver.quit();

        System.out.println("Closing the Driver : Appium Driver");
    }
}