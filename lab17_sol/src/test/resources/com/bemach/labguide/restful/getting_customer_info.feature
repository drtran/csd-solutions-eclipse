Feature: Getting Customer Information Service
  As a partner application,
  I want to get information of a customer by a customer ID
  So that, I can send promotion information to that customer.

  @simple-test
  Scenario: Getting a customer record by a given customer ID
    Given that a customer exists with "EASTC", "Eastern Connection", "Ann Devon", "Sales Agent", and "(171) 555-0297"
    When I call MongoRS service with a given "EASTC"
    Then I should receive a customer record with "EASTC", "Eastern Connection", "Ann Devon", "Sales Agent", and "(171) 555-0297"
