Feature: To search cucumber in google

    @Regression
    Scenario: Cucumber Google
      Given I am in google page
      When I type "cucumber"
      Then I click submit button
      Then I clear search textbox
