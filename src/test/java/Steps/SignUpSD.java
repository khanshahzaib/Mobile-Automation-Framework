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
        SignUpPage = new SignUpPage(appiumDriver);
        SignUpPage.waitForAppLaunch();
        SignUpPage.loadControlsForAppLaunch();
    }

    @When("user can click on the Registration Link")
    public void userCanClickOnTheRegistrationLink() {
        System.out.println("user can click on the Registration Link");
        SignUpPage.regLink();
    }

    @And("user see the Registration Screen")
    public void userSeeTheRegistrationScreen() {
        System.out.println("user see the Registration Screen");
        SignUpPage.waitForSignUpDOMElements();
        SignUpPage.loadControlsForSignUpDOMElements();
    }

    @And("user enters the username")
    public void userEntersTheUsername() {
        System.out.println("user enters the username");
        SignUpPage.enterUsername();
    }

    @And("user enters Email Address")
    public void userEntersEmailAddress() {
        System.out.println("user enters Email Address");
        SignUpPage.enterEmailAddress();
    }

    @And("user enters password")
    public void userEntersPassword() {
        System.out.println("user enters password");
        SignUpPage.enterPassword();
    }

    @And("user enters name")
    public void userEntersName() {
        System.out.println("user enters name");
        SignUpPage.enterName();
    }

    @And("user selects programming language")
    public void userSelectsProgrammingLanguage() {
        System.out.println("user selects programming language");
        SignUpPage.waitForLanguageOption();
        SignUpPage.loadControlsForLanguageOption();
        SignUpPage.selectLanguage();
    }

    @And("user checks on the TandC checkbox")
    public void userChecksOnTheTandCCheckbox() {
        System.out.println("user checks on the TandC checkbox");
        SignUpPage.checkTandC();
    }

    @Then("user clicks on the Register Button")
    public void userClicksOnTheRegisterButton() {
        System.out.println("user clicks on the Register Button");
        SignUpPage.registerButton();
    }

    @And("user verifies as a Register User")
    public void userVerifiesAsARegisterUser() {
        System.out.println("user verifies as a Register User");
        SignUpPage.waitForVerifiesUser();
        SignUpPage.loadControlsForVerifiesUser();
        SignUpPage.verifiesUser();
    }
}
