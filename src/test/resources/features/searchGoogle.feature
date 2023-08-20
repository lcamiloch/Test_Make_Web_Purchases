
Feature: search in google

  @google
  Scenario: search element in google successful
    Given The customer wants to find an element in google
    When He search the element QA
    And He chose second element
    Then He should see the title of the page