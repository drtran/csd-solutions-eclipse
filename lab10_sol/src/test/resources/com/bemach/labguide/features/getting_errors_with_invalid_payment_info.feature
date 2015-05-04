Feature: Getting errors when entering invalid payment info

  As a site administrator
  I want to see errors displayed properly when invalid payment information is entered
  So we can provide better tech support

  @no-payment-info
  Scenario: Adopting one puppy from the website
    Given I am on the puppy adoption site "http://localhost:3000"
    When I click the View Details button for "Brook"
    And I click the Adopt Me! button
    And I click the Complete the Adoption button
    And I complete the adoption using no information
    Then I should see this error message "5 errors prohibited this order from being saved:"
