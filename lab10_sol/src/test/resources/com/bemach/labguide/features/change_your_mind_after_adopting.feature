Feature: Changing your mind after adopting a puppy

  As a puppy lover
  I want to change my mind after adopting a puppy
  So I can choose another puppy.

  @change-your-mind
  Scenario: Changing your mind after adopting a puppy before pay
    Given I am on the puppy adoption site "http://localhost:3000"
    When I click the View Details button for "Brook"
    And I click the Adopt Me! button
    And I click the Change your mind button and accept OK
    Then I should be back on the home page
