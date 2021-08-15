Feature: Sign In Module
  This Sign In feature deals with the sign in functionality of the application

  @A_SignIn
  Scenario: Verify that the user can sign in through the application
    Given user launch an Application
    When user is on the Sign In Screen
    Then user enters Sign In CNIC
    And user enters Sign In password
    And user click on the Submit Button