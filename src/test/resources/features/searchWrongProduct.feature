#Author: your.email@your.domain.com
@greenkart
Feature: Greenkart - Search Wrong Product

@searchWrongProduct
  Scenario: Performing wrong search operation
    Given user is on home page
    When enters wrong product name into searchbox
    Then verifies the searched product