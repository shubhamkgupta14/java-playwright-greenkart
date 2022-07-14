#Author: your.email@your.domain.com
@greenkart
Feature: Greenkart - Place multiple product into cart

@placeMultipleOrder
  Scenario: Performing place products into cart
    Given user is on home page
    When select multiple product and add to cart
    Then go to cart window
    And verify multiple cart product detail
    And click on checkout button
    And verify the multiple product details on checkout page
    And click on place order button
    And select a country
    And accept the terms and conditions
    And click on proceed button
    And verify the success message