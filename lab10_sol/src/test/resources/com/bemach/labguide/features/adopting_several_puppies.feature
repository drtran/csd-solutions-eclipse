Feature: Adopting several puppies

  As a puppy lover
  I want to adopt puppies
  So they can chew my furniture

  @simple-several-puppies
  Scenario: Adopting two puppies from the website
    Given I am on the puppy adoption site "http://localhost:3000"
    When I complete adopting these puppies:
    | Brook    |
    | Hanna    |
    | Ruby Sue |
    And I complete the adoption using this information "Mr. Cheezy", "123 Main Street", "cheezy@mail.com", "Check"
    Then I should see "Thank you for adopting a puppy!"