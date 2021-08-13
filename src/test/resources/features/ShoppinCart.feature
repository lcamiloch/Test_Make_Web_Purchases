@shoppingCartOperation
Feature: shopping cart operation

  @addAndRemoveItems
  Scenario: add and remove items
    Given The customer wants to test the functionality of the shopping cart
    When He adds 10 products to the shopping cart
    And He then deletes them
    Then He should see the shopping cart empty