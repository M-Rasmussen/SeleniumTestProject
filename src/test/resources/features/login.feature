Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I login with username "tomsmith" and password "SuperSecretPassword!"
    Then I should see the secure area

  Scenario: Failed login with invalid credentials
    Given I am on the login page
    When I login with username "wrongUser" and password "wrongPassword"
    Then I should see an invalid username error