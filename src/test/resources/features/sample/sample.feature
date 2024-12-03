Feature: BrowserStack Demo

  @SampleTest @TestTag2
  Scenario: BStack Sample Test - Search BrowserStack
    Given I am on homepage
    When I click on Search Wikipedia
    Then I search with keyword BrowserStack
    Then the search results should be listed