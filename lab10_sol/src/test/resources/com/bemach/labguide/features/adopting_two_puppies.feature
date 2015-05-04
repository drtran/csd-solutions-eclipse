Feature: Adopting two puppies

  As a puppy lover
  I want to adopt puppies
  So they can chew my furniture

  @simple-two-puppies
  Scenario: Adopting two puppies from the website
    Given I am on the puppy adoption site "http://localhost:3000"
    When I click the View Details button for "Brook"
    And I click the Adopt Me! button
    And I click on Adopt Another Puppy
    And I click the View Details button for "Hanna"
    And I click the Adopt Me! button
    And I click the Complete the Adoption button
    And I complete the adoption using this information "Mr. Cheezy", "123 Main Street", "cheezy@mail.com", "Check"
    Then I should see "Thank you for adopting a puppy!"

