Feature: Login functionality

  Scenario: Valid user logs in successfully
    Given User is on the login page
    When User enters valid username and password
    And User clicks on the login button
    Then User should be redirected to the products page

  Scenario: Invalid user logs in unsuccessfully
    Given User is on the login page
    When User enters invalid username and password
    And User clicks on the login button
    Then User should see an error message
