Feature: Sign Up Module
  This sign up feature deals with the sign up functionality of the application

  @A_Register
  Scenario: Verify that the user can enter Valid Credentials
    Given user can see the launch of the Application
    When user enters correct Email Address
    And user enters correct password
    Then user proceeds to the CheckIn Screen


