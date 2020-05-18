package Steps;

import Base.BaseUtil;
import Pages.SignUpPage;
import com.aventstack.extentreports.GherkinKeyword;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpSD extends BaseUtil {

    SignUpPage SignUpPage;

    @Given("user can see the launch of the Application")
    public void userCanSeeTheLaunchOfTheApplication() throws ClassNotFoundException {
        System.out.println("user can see the launch of the Application");
        SignUpPage = new SignUpPage(appiumDriver);
        scenarioDef.createNode(new GherkinKeyword("Given"), "user can see the launch of the Application");
        SignUpPage.waitForAppLaunch();
        SignUpPage.loadControlsForAppLaunch();
    }

    @When("user can click on the Registration Link")
    public void userCanClickOnTheRegistrationLink() throws ClassNotFoundException {
        System.out.println("user can click on the Registration Link");
        scenarioDef.createNode(new GherkinKeyword("When"), "user can click on the Registration Link");
        SignUpPage.regLink();
    }

    @And("user see the Registration Screen")
    public void userSeeTheRegistrationScreen() throws ClassNotFoundException {
        System.out.println("user see the Registration Screen");
        scenarioDef.createNode(new GherkinKeyword("And"), "user see the Registration Screen");
        SignUpPage.waitForSignUpDOMElements();
        SignUpPage.loadControlsForSignUpDOMElements();
    }

    @And("user enters the username")
    public void userEntersTheUsername() throws ClassNotFoundException {
        System.out.println("user enters the username");
        scenarioDef.createNode(new GherkinKeyword("And"), "user enters the username");
        SignUpPage.enterUsername();
    }

    @And("user enters Email Address")
    public void userEntersEmailAddress() throws ClassNotFoundException {
        System.out.println("user enters Email Address");
        scenarioDef.createNode(new GherkinKeyword("And"), "user enters Email Address");
        SignUpPage.enterEmailAddress();
    }

    @And("user enters password")
    public void userEntersPassword() throws ClassNotFoundException {
        System.out.println("user enters password");
        scenarioDef.createNode(new GherkinKeyword("And"), "user enters password");
        SignUpPage.enterPassword();
    }

    @And("user enters name")
    public void userEntersName() throws ClassNotFoundException {
        System.out.println("user enters name");
        scenarioDef.createNode(new GherkinKeyword("And"), "user enters name");
        SignUpPage.enterName();
    }

    @And("user selects programming language")
    public void userSelectsProgrammingLanguage() throws ClassNotFoundException {
        System.out.println("user selects programming language");
        scenarioDef.createNode(new GherkinKeyword("And"), "user selects programming language");
        SignUpPage.waitForLanguageOption();
        SignUpPage.loadControlsForLanguageOption();
        SignUpPage.selectLanguage();
    }

    @And("user checks on the TandC checkbox")
    public void userChecksOnTheTandCCheckbox() throws ClassNotFoundException {
        System.out.println("user checks on the TandC checkbox");
        scenarioDef.createNode(new GherkinKeyword("And"), "user checks on the TandC checkbox");
        SignUpPage.checkTandC();
    }

    @Then("user clicks on the Register Button")
    public void userClicksOnTheRegisterButton() throws ClassNotFoundException {
        System.out.println("user clicks on the Register Button");
        scenarioDef.createNode(new GherkinKeyword("Then"), "user clicks on the Register Button");
        SignUpPage.registerButton();
    }

    @And("user verifies as a Register User")
    public void userVerifiesAsARegisterUser() throws ClassNotFoundException {
        System.out.println("user verifies as a Register User");
        scenarioDef.createNode(new GherkinKeyword("And"), "user verifies as a Register User");
        SignUpPage.waitForVerifiesUser();
        SignUpPage.loadControlsForVerifiesUser();
        SignUpPage.verifiesUser();
    }
}
