Feature: To search junit in google


@JunitScenario
  Scenario: Junit Google
    Given I am on "cucumber" search page
    When I type "junit"
    Then I click search button
    Then I clear search textbox