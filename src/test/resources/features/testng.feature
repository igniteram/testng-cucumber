Feature: To search testng in google
  
@TestngScenario
  Scenario: Testng Google
    Given I am in google page
    When I type "testng"
    Then I click submit button
    Then I clear search textbox
