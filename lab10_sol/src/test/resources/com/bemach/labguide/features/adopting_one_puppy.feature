Feature: Adopting a puppy

  As a puppy lover
  I want to adopt a puppy
  So they can chew my furniture

  @simple-one-puppy
  Scenario: Adopting one puppy from the website
    Given I am on the puppy adoption site "http://localhost:3000"
    When I click the View Details button for "Brook"
    And I click the Adopt Me! button
    And I click the Complete the Adoption button
    And I complete the adoption using this information "Mr. Cheezy", "123 Main Street", "cheezy@mail.com", "Check"
    Then I should see "Thank you for adopting a puppy!"

  @simple-on-puppy-with-table
  Scenario: Adopting one puppy from the website
    Given I am on the puppy adoption site "http://localhost:3000"
    When I click the View Details button for "Brook"
    And I click the Adopt Me! button
    And I click the Complete the Adoption button
    And I complete the adoption with:
      | orderName | orderAddress    | orderEmail         | orderPaymentType |
      | Cheezy    | 123 Main Street | cheezy@example.com | Check            |
    Then I should see "Thank you for adopting a puppy!"
