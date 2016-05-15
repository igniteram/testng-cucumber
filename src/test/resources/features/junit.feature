Feature: To search junit in google


@JunitScenario
  Scenario: Junit Google
    Given I am in google page
    When I type "junit"
    Then I click submit button
    Then I clear search textbox