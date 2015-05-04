Feature: Adopting several puppies

  As a puppy lover
  I want to adopt puppies
  So they can chew my furniture

  @simple-several-puppies-outline
  Scenario Outline: Adopting two puppies from the website
    Given I am on the puppy adoption site "http://localhost:3000"
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