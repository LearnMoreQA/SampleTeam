Feature: Validate Login Functionality

  @loginValid @login
  Scenario: To Validate valid credentials
    Given User Navigates to Required Url
    When User Enters valid Username and Password
    And User Clicks the Login Button
    Then Validate System navigates to Home Page

  @loginInvalid @login
  Scenario: To Validate valid credentials
    Given User Navigates to Required Url
    When User Enters Invalid Username and Password
    And User Clicks the Login Button
    Then Validate the "Invalid credentials" Error Message