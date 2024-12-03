Feature: BrowserStack Demo

  Scenario: BStack Sample Test 2 - Search BrowserStack
    Given I am on homepage
    When I click on Search Wikipedia
    Then I search with keyword BrowserStack
    Then the search results should be listed
    Then the test should fail