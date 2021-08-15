package Utilities;

import Base.BaseUtil;
import DataProvider.FileReaderManager;
import Utilities.ReadExcel;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {

    private BaseUtil base;
    public String myDriver = FileReaderManager.getInstance().getConfigReader().getDriverName();

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
                    capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME,FileReaderManager.getInstance().getConfigReader().getApkName());
                } catch (NumberFormatException nfe) {
                    System.out.println("## catch exception ##");
                    nfe.printStackTrace();
                }
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, FileReaderManager.getInstance().getConfigReader().getPlatformName());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,FileReaderManager.getInstance().getConfigReader().getPlatformVersion());
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, FileReaderManager.getInstance().getConfigReader().getDeviceName());
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, FileReaderManager.getInstance().getConfigReader().getAutomationName1());
                capabilities.setCapability(MobileCapabilityType.APP, FileReaderManager.getInstance().getConfigReader().getApkPath());
                capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                capabilities.setCapability("unicodeKeyboard", true);
                capabilities.setCapability("resetKeyboard", false);
                capabilities.setCapability("noReset", true);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new AppiumDriver(url, capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(
                        FileReaderManager.getInstance().getConfigReader().getImplicitWaitTime(),
                        TimeUnit.SECONDS);
                ReadExcel.readExcelFile();
                break;
            }
            case "Emulator": {
                System.out.println("## Config file works ##");

                try {
                    capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME,FileReaderManager.getInstance().getConfigReader().getApkName());
                } catch (NumberFormatException nfe) {
                    System.out.println("## catch exception ##");
                    nfe.printStackTrace();
                }
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, FileReaderManager.getInstance().getConfigReader().getPlatformName());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,FileReaderManager.getInstance().getConfigReader().getPlatformVersion());
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, FileReaderManager.getInstance().getConfigReader().getDeviceNameEmulator());
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, FileReaderManager.getInstance().getConfigReader().getAutomationName1());
                capabilities.setCapability(MobileCapabilityType.APP, FileReaderManager.getInstance().getConfigReader().getApkPath());
                capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                capabilities.setCapability("unicodeKeyboard", true);
                capabilities.setCapability("resetKeyboard", false);
                capabilities.setCapability("noReset", true);
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                appiumDriver = new AppiumDriver(url, capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(
                        FileReaderManager.getInstance().getConfigReader().getImplicitWaitTime(),
                        TimeUnit.SECONDS);
                ReadExcel.readExcelFile();
                break;
            }
            default:
                System.out.println("This is a Web Page");
                System.out.println(FileReaderManager.getInstance().getConfigReader().getDriverName());
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