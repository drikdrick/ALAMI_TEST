Feature: Register New User
  Scenario: Register New User
    Given I launch chrome broswer
    When I open Cermati registration page
    And I fill in "email" with "random"
    And I fill in "mobilePhone" with "random"
    And I fill in "password" with "random"
    And I fill in "passwordConfirmation" with "random"
    And I fill in "firstName" with "random"
    And I fill in "lastName" with "random"
    And I fill in "cityAndProvince" with "random"
    And I press register button
    And   I close the browser