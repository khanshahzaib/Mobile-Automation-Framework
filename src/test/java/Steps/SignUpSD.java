package Steps;

import Base.BaseUtil;
import Pages.SignUpPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpSD extends BaseUtil {

    SignUpPage SignUpPage;

    @Given("user can see the launch of the Application")
    public void userCanSeeTheLaunchOfTheApplication() {
        System.out.println("user can see the launch of the Application");
//        SignUpPage = new SignUpPage(appiumDriver);
//        SignUpPage.waitForSignUpDOMElements();
//        SignUpPage.loadControlsForSignUpDOMElements();
    }

    @When("user enters correct Email Address")
    public void userEntersCorrectEmailAddress() {
        System.out.println("user enters correct Email Address");
        SignUpPage.loginEmailAddress();
    }

    @And("user enters correct password")
    public void userEntersCorrectPassword() {
        System.out.println("user enters correct password");
        SignUpPage.loginPassword();
    }

    @Then("user proceeds to the CheckIn Screen")
    public void userProceedsToTheCheckInScreen() {
        System.out.println("user proceeds to the CheckIn Screen");
        SignUpPage.loginSignUpButton();
    }
}
