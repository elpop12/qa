@BDD
Feature: User Login

  @Login @wordpress @userpanel
  Scenario: Login
    Given User starts on main page
    When user logs to the user panel
    Then User can modify user profile
    And user logs out