package Pages;

import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BaseUtil {

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        mSheet = wb.getSheetAt(0);
    }

    //Variable's declaration

    //region

    WebElement btnSignIn;

    WebElement txtEmail;

    WebElement txtPassword;

    WebElement btnSubmitSignIn;

    //endregion

    //Wait For DOM Elements



    //Load DOM Elements



    //Methods Declaration





}
