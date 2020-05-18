package Pages;

import Base.BaseUtil;
import Utilities.ReadExcel;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BaseUtil {

    public SignUpPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        mSheet = wb.getSheetAt(0);
    }

    //Variable's declaration

    //region

    WebElement clickRegLink;

    WebElement txtUsername;

    WebElement txtEmail;

    WebElement txtPassword;

    WebElement txtName;

    WebElement optLanguage;

    WebElement selectOption;

    WebElement clickTandC;

    WebElement btnRegister;

    WebElement clickVerifiesUser;

    //endregion

    //Wait For Sign In DOM Elements

    //region

    public void waitForAppLaunch(){

        WebDriverWait waitRegistration = new WebDriverWait(appiumDriver, 20);
        waitRegistration.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(1, 2))));
    }

    public void waitForSignUpDOMElements(){

        WebDriverWait waitUsername = new WebDriverWait(appiumDriver, 20);
        waitUsername.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(2,2))));

        WebDriverWait waitEmail = new WebDriverWait(appiumDriver, 20);
        waitEmail.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(3,2))));

        WebDriverWait waitPassword = new WebDriverWait(appiumDriver, 20);
        waitPassword.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(4,2))));

        WebDriverWait waitName = new WebDriverWait(appiumDriver, 20);
        waitName.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(5,2))));

        WebDriverWait waitLanguage = new WebDriverWait(appiumDriver, 20);
        waitLanguage.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(6,2))));

        WebDriverWait waitCheckbox = new WebDriverWait(appiumDriver, 20);
        waitCheckbox.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(8,2))));

        WebDriverWait waitRegister = new WebDriverWait(appiumDriver, 20);
        waitRegister.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(9,2))));

        System.out.println("DOM Elements Found");
    }

    public void waitForLanguageOption(){
        WebDriverWait waitOption = new WebDriverWait(appiumDriver, 20);
        waitOption.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                xpath(ReadExcel.GetCellValue(7,3))));
    }

    public void waitForVerifiesUser(){

        WebDriverWait waitUser = new WebDriverWait(appiumDriver, 20);
        waitUser.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                id(ReadExcel.GetCellValue(10,2))));
    }

    //endregion

    //Load Sign In DOM Elements

    //region

    public void loadControlsForAppLaunch(){

        clickRegLink = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(1,2)));
    }

    public void loadControlsForSignUpDOMElements(){

        txtUsername = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(2,2)));

        txtEmail = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(3,2)));

        txtPassword = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(4,2)));

        txtName = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(5,2)));

        optLanguage = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(6,2)));

        clickTandC = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(8,2)));

        btnRegister = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(9,2)));

        System.out.println("Controls Loaded");
    }

    public void loadControlsForLanguageOption(){
        selectOption = appiumDriver.findElement(MobileBy.
                xpath(ReadExcel.GetCellValue(7,3)));
    }

    public void loadControlsForVerifiesUser(){
        clickVerifiesUser = appiumDriver.findElement(MobileBy.
                id(ReadExcel.GetCellValue(10,2)));
    }

    //endregion

    //Methods Declaration

    //region

    public void regLink() {
        clickRegLink.click();
    }

    public void enterUsername() {
        txtUsername.sendKeys(ReadExcel.GetCellValue(1,6));
    }

    public void enterEmailAddress() {
        txtEmail.sendKeys(ReadExcel.GetCellValue(2,6));
    }

    public void enterPassword() {
        txtPassword.sendKeys(ReadExcel.GetCellValue(3,6));
    }

    public void enterName() {
        txtName.clear();
        txtName.sendKeys(ReadExcel.GetCellValue(4,6));
        optLanguage.click();
    }

    public void selectLanguage() {
        selectOption.click();
    }

    public void checkTandC() {
        clickTandC.click();
    }

    public void registerButton() {
        btnRegister.click();
    }

    public void verifiesUser() {
        clickVerifiesUser.click();
    }


    //endregion

}
