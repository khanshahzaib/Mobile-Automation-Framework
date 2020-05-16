Feature: Sign In Module
  This sign in feature deals with the sign in functionality of the application

  @A_LoginUrl
  Scenario: Verify that the user can enter Valid Credentials
    Given user can see the launch of the Application
    When user enters correct Email Address
    And user enters correct password
    Then user proceeds to the CheckIn Screen


