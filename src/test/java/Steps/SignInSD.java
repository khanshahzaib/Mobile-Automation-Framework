package Steps;

import Base.BaseUtil;
import Pages.SignInPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInSD extends BaseUtil {

    SignInPage signInPage = new SignInPage(appiumDriver);

    @Given("user launch an Application")
    public void userLaunchAnApplication() {
        System.out.println("user launch an Application");

    }
    @When("user is on the Sign In Screen")
    public void userIsOnTheSignInScreen() {
        System.out.println("user is on the Sign In Screen");
//        signInPage.waitForSignInElements();
//        signInPage.loadControlsForSignInElements();
    }

    @Then("user enters Sign In CNIC")
    public void userEntersSignInCNIC() {
        System.out.println("user enters Sign In CNIC");
//        signInPage.enterCNIC();
    }

    @And("user enters Sign In password")
    public void userEntersSignInPassword() {
        System.out.println("user enters Sign In password");
//        signInPage.enterPassword();
    }

    @And("user click on the Submit Button")
    public void userClickOnTheSubmitButton() {
        System.out.println("user click on the Submit Button");
//        signInPage.clickSignIn();
    }
}
