package Pages;

import Base.BaseUtil;
import Utilities.ReadExcel;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.How.XPATH;


public class SignInPage extends BaseUtil {

    private AppiumDriver driver;

    public SignInPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        mSheet = wb.getSheetAt(1);
        this.driver = driver;
    }

    //Variable's declaration

    //region

    @FindBy(how = XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText")
    WebElement enterCNIC;

    @FindBy(how = XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
    WebElement enterPassword;

    @FindBy(how = XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[7]/android.view.View/android.view.View/android.widget.Button")
    WebElement clickSignIn;

    //endregion

    //Wait For DOM Elements

    public void waitForSignInElements() {

        WebDriverWait cnic = new WebDriverWait(driver, 10);
        cnic.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText")));

        WebDriverWait password = new WebDriverWait(driver, 10);
        password.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")));

        WebDriverWait signIn = new WebDriverWait(driver, 10);
        signIn.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
                xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[7]/android.view.View/android.view.View/android.widget.Button")));

//        for (int i = 1; i <= 3; i++) {
//            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.
//                    xpath(ReadExcel.GetCellValue(i, 2))));
//        }
    }

    //Load DOM Elements

    public void loadControlsForSignInElements() {

        enterCNIC = Web_Driver.findElement(MobileBy
                .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.EditText"));

        enterPassword = Web_Driver.findElement(MobileBy
                .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText"));

        clickSignIn = Web_Driver.findElement(MobileBy
                .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[7]/android.view.View/android.view.View/android.widget.Button"));


        //        for (int i = 1; i <= 3; i++) {
//            switch (i) {
//                case 1:
//                    enterCNIC = Web_Driver.findElement(MobileBy
//                            .xpath(ReadExcel.GetCellValue(i, 2)));
//                    break;
//                case 2:
//                    enterPassword = Web_Driver.findElement(MobileBy
//                            .xpath(ReadExcel.GetCellValue(i, 2)));
//                    break;
//
//                case 3:
//                    clickSignIn = Web_Driver.findElement(MobileBy
//                            .xpath(ReadExcel.GetCellValue(i, 2)));
//                    break;
//            }
//        }
    }

    //Method's Declaration

    public void enterCNIC() {
        enterCNIC.clear();
        enterCNIC.sendKeys(ReadExcel.GetCellValue(1, 6));
    }

    public void enterPassword() {
        enterPassword.clear();
        enterCNIC.sendKeys(ReadExcel.GetCellValue(2, 6));
    }

    public void clickSignIn() {
        clickSignIn.click();
    }


}
