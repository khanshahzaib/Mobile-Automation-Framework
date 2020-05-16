package Steps;

import Base.BaseUtil;
import Pages.SignInPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInSD extends BaseUtil {

    SignInPage signInPage;

    @Given("user can see the launch of the Application")
    public void userCanSeeTheLaunchOfTheApplication() {
        System.out.println("user can see the launch of the Application");
        signInPage = new SignInPage(appiumDriver);
        signInPage.waitForSignInDOMElements();
        signInPage.loadControlsForSignInDOMElements();
    }

    @When("user enters correct Email Address")
    public void userEntersCorrectEmailAddress() {
        System.out.println("user enters correct Email Address");
        signInPage.loginEmailAddress();
    }

    @And("user enters correct password")
    public void userEntersCorrectPassword() {
        System.out.println("user enters correct password");
        signInPage.loginPassword();
    }

    @Then("user proceeds to the CheckIn Screen")
    public void userProceedsToTheCheckInScreen() {
        System.out.println("user proceeds to the CheckIn Screen");
        signInPage.loginSignInButton();
    }
}
