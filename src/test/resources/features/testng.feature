Feature: To search testng in google
  
@TestngScenario
  Scenario: Testng Google
    Given I am on google page
    When I type "testng"
    Then I click search button
    Then I clear search textbox
