#Author: your.email@your.domain.com
@greenkart
Feature: Greenkart - Search Product

@searchProduct
  Scenario: Performing search operation
    Given user is on home page
    When enters product name into searchbox
    Then verifies the searched product