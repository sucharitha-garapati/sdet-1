@activity2_5
Feature: Data driven test with Example

Scenario Outline: Testing with Data from Scenario
    Given User in Login page
    When User enter "<Usernames>" and "<Passwords>"
    Then Read page title and confirmation message
    And Close act Browser
    
Examples:
    | Usernames | Passwords |
    | admin     | password  |
    | adminUser | Password  |