package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ExtentReportUtil extends BaseUtil {

    private String fileName = reportLocation + "Extent Report.html";

    public void ExtentReport() {
        //First is to create Extent Reports
        extent = new ExtentReports();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Test Report For Selenium with Cucumber");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Toll Pays Test Report");

        extent.attachReporter(htmlReporter);
    }

    public void ExtentReportScreenshots() throws IOException {
        var scr = ((TakesScreenshot) Web_Driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scr.toPath(), new File(reportLocation + "screenshot.png").toPath());
        scenarioDef.fail("details").addScreenCaptureFromPath(reportLocation + "screenshot.png");
    }

    public void FlushReport() {
        extent.flush();
    }
}
