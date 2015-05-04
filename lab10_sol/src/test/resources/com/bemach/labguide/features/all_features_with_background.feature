@run-all
Feature: Adopting a puppy

  As a puppy lover
  I want to adopt a puppy
  So they can chew my furniture

  Background:
    Given I am on the puppy adoption site "http://localhost:3000"

  @simple-one-puppy
  Scenario: Adopting one puppy from the website
    When I click the View Details button for "Brook"
    And I click the Adopt Me! button
    And I click the Complete the Adoption button
    And I complete the adoption using this information "Mr. Cheezy", "123 Main Street", "cheezy@mail.com", "Check"
    Then I should see "Thank you for adopting a puppy!"

  @simple-two-puppies
  Scenario: Adopting two puppies from the website
    When I click the View Details button for "Brook"
    And I click the Adopt Me! button
    And I click on Adopt Another Puppy
    And I click the View Details button for "Hanna"
    And I click the Adopt Me! button
    And I click the Complete the Adoption button
    And I complete the adoption using this information "Mr. Cheezy", "123 Main Street", "cheezy@mail.com", "Check"
    Then I should see "Thank you for adopting a puppy!"


  @simple-on-puppy-with-table
  Scenario: Adopting one puppy from the website
    When I click the View Details button for "Brook"
    And I click the Adopt Me! button
    And I click the Complete the Adoption button
    And I complete the adoption with:
      | orderName | orderAddress    | orderEmail         | orderPaymentType |
      | Cheezy    | 123 Main Street | cheezy@example.com | Check            |
    Then I should see "Thank you for adopting a puppy!"

  @simple-several-puppies
  Scenario: Adopting two puppies from the website
    When I complete adopting these puppies:
      | Brook    |
      | Hanna    |
      | Ruby Sue |
    And I complete the adoption using this information "Mr. Cheezy", "123 Main Street", "cheezy@mail.com", "Check"
    Then I should see "Thank you for adopting a puppy!"

  @simple-several-puppies-outline
  Scenario Outline: Adopting two puppies from the website
    When I click the View Details button for "<pet_name>"
    And I click the Adopt Me! button
    And I click the Complete the Adoption button
    And I complete the adoption with "<payment_type>":
      | orderName | orderAddress    | orderEmail         | orderPaymentType |
      | Cheezy    | 123 Main Street | cheezy@example.com | Check            |
      | Sleezy    | 123 Main Street | sleezy@example.com | Credit card      |
      | Crazy     | 123 Main Street | crazy@example.com  | Purchase order   |
    Then I should see "Thank you for adopting a puppy!"
    Examples:
      | pet_name | payment_type   |
      | Brook    | Check          |
      | Hanna    | Credit card    |
      | Ruby Sue | Purchase order |