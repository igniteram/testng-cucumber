Feature: To search junit in google


@JunitScenario
  Scenario: Junit Google
    Given I am on google page
    When I type "junit"
    Then I click search button
    Then I clear search textbox