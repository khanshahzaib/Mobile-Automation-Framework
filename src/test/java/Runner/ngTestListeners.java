package Runner;

import Base.BaseUtil;
import Base.ExtentReportUtil;
import com.aventstack.extentreports.gherkin.model.Feature;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static Base.BaseUtil.features;

public class ngTestListeners implements ITestListener {

    private ExtentReportUtil extentReportUtil = new ExtentReportUtil();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test Start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("On test Success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test Failure");

        try{
            extentReportUtil.ExtentReportScreenshots();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On test Percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On Start");

        extentReportUtil.ExtentReport();
        //ToDo: Feature - Hard coding the feature name
        features = BaseUtil.extent.createTest(Feature.class, "Regression Suite on Toll Pays");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On Finished");

        extentReportUtil.FlushReport();
    }
}
