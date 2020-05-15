package Steps;

import Base.BaseUtil;
import DataProvider.FileReaderManager;
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

    @Before("@A_LoginUrl")
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
                URL url = new URL("http://192.168.1.102:4723/wd/hub");
                appiumDriver = new AppiumDriver(url, capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                break;
            }
            case "Android": {
                capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "com.nbo.mobs");
                capabilities.setCapability(MobileCapabilityType.APP, "C:\\cc\\MyApp.apk");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0"); //Tablet
//            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "52008136c013b493"); //Tablet
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0"); //Qurat
//            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HGH7N17915008245"); //Qurat
                // capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0"); //Lenovo
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //Lenovo
                capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                capabilities.setCapability("unicodeKeyboard", true);
                capabilities.setCapability("resetKeyboard", false);
                capabilities.setCapability("noReset", true);
                URL url = new URL("http://0.0.0.0:4723/wd/hub");
                appiumDriver = new AppiumDriver(url, capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                break;
            }
            case "Emulator": {
                System.out.println("## Config file works ##");
//                capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "com.nbo.mobs");

                try {
//                    number = Integer.parseInt(input);
//                    capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME,"nbo.com.mobs");
                    capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME,FileReaderManager.getInstance().getConfigReader().getApkName());
                } catch (NumberFormatException nfe) {
                    System.out.println("## catch exception ##");
                    nfe.printStackTrace();
                }

//                without config file
//                capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\IBS\\Downloads\\MyApp.apk"); //Server Emulator
//                capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\IBS\\Downloads\\MyApp.apk"); //Server Emulator
//                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
////                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1"); //Emulator
//                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,FileReaderManager.getInstance().getConfigReader().getPlatformVersion()); //Emulator
//                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, FileReaderManager.getInstance().getConfigReader().getDeviceName()); //Emulator
////                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //Emulator
//                capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//                capabilities.setCapability("unicodeKeyboard", true);
//                capabilities.setCapability("resetKeyboard", false);
//                capabilities.setCapability("noReset", true);
//                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

//                with config file
                capabilities.setCapability(MobileCapabilityType.APP, FileReaderManager.getInstance().getConfigReader().getApkPath());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, FileReaderManager.getInstance().getConfigReader().getPlatformName());
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,FileReaderManager.getInstance().getConfigReader().getPlatformVersion());
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, FileReaderManager.getInstance().getConfigReader().getDeviceName());
                capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
                capabilities.setCapability("unicodeKeyboard", FileReaderManager.getInstance().getConfigReader().getUniCodeKeyboard());
                capabilities.setCapability("resetKeyboard", FileReaderManager.getInstance().getConfigReader().getResetKeyboard());
                capabilities.setCapability("noReset", FileReaderManager.getInstance().getConfigReader().getNoReset());
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, FileReaderManager.getInstance().getConfigReader().getAutomationName());
                URL url = new URL(FileReaderManager.getInstance().getConfigReader().getAppiumServerEndpoint());

                appiumDriver = new AndroidDriver(url,capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(
                        FileReaderManager.getInstance().getConfigReader().getImplicitWaitTime(),
                        TimeUnit.SECONDS);
                break;
            }
            default:
                System.out.println("This is a Web Page");
                System.out.println(FileReaderManager.getInstance().getConfigReader().getDriverName());
                break;
        }
    }

    @After("@A_LoginUrl")
    public void TearDownTest(Scenario scenario) {

        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
            appiumDriver.quit();
            return;
        }

        System.out.println("Closing the Driver : Appium Driver");
    }
}