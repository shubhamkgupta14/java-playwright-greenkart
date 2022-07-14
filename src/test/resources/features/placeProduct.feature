#Author: your.email@your.domain.com
@greenkart
Feature: Greenkart - Place an Order

@placeOrder
  Scenario: Performing place order operation
    Given user is on home page
    When enters product name into searchbox
    Then verifies the searched product
    And set the quantity of product
    And click on Add to cart button
    And go to cart window
    And verify cart product detail
    And click on checkout button
    And verify the product details on checkout page
    And click on place order button
    And select a country
    And accept the terms and conditions
    And click on proceed button
    And verify the success message