Feature: Sign Up As New User

  Scenario: Successful Sign Up
    Given I am on Home page
    When I click Sign Up button
    And I fill registration fields
    Then Tap on Sign Up button
    #Then I close Getting Started modal window
    Then I am on Dashboard Page