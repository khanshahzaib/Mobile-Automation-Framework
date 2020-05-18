package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;

public class BaseUtil {

    public static AppiumDriver appiumDriver;

    protected static WebDriver Web_Driver;

    public static ExtentReports extent;

    static ExtentTest scenarioDef;

    public static ExtentTest features;

    static String reportLocation = "/Reports/Selendroid/Mobile/";

    public static XSSFSheet mSheet;

    public static FileInputStream file;

    public static XSSFWorkbook wb;

    public static WebDriverWait webDriverWait;
}