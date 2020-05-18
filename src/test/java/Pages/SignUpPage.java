package Pages;

import Base.BaseUtil;
import Utilities.ReadExcel;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BaseUtil {

    public SignUpPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        mSheet = wb.getSheetAt(0);
    }

    //Variable's declaration

    //region

    WebElement btnSignUp;

    WebElement txtEmail;

    WebElement txtPassword;

    //endregion

    //Wait For Sign In DOM Elements

    //region

    public void waitForSignUpDOMElements(){
        WebDriverWait waitSignUp = new WebDriverWait(appiumDriver, 20);
        waitSignUp.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(4,2))));

        WebDriverWait waitEmail = new WebDriverWait(appiumDriver, 20);
        waitEmail.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(1, 2))));

        WebDriverWait waitPassword = new WebDriverWait(appiumDriver, 20);
        waitPassword.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(2,2))));

        System.out.println("DOM Elements Found");
    }

    //endregion

    //Load Sign In DOM Elements

    //region

    public void loadControlsForSignUpDOMElements(){
        btnSignUp = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(4,2)));

        txtEmail = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(1,2)));

        txtPassword = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(2,2)));

        System.out.println("Controls Loaded");
    }

    //endregion

    //Methods Declaration

    //region

    public void loginSignUpButton(){
        btnSignUp.click();
    }

    public void loginEmailAddress() {
        txtEmail.sendKeys(ReadExcel.GetCellValue(1,6));
    }

    public void loginPassword() {
        txtPassword.sendKeys(ReadExcel.GetCellValue(2,6));
    }

    //endregion

}
