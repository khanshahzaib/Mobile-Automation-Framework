Feature: Sign Up Module
  This sign up feature deals with the sign up functionality of the application

  @A_Register
  Scenario: Verify that the user can register through the application
    Given user can see the launch of the Application
    When user can click on the Registration Link
    And user see the Registration Screen
    And user enters the username
    And user enters Email Address
    And user enters password
    And user enters name
    And user selects programming language
    And user checks on the TandC checkbox
    Then user clicks on the Register Button
    And user verifies as a Register User


