Feature: Getting Information for several customers
  As a partner application,
  I want to get information of a customer by a customer ID
  So that, I can send promotion information to that customer.

  @several-customers
  Scenario Outline: Getting a customer record by a given customer ID
    And that a customer exists with "<customer_id>", "<company_name>", "<contact_name>", "<contact_title>", and "<phone>"
    When I call MongoRS service with a given "<customer_id>"
    Then I should receive a customer record with "<customer_id>", "<company_name>", "<contact_name>", "<contact_title>", and "<phone>"

    Examples:
      | customer_id | company_name       | contact_name   | contact_title | phone          |
      | EASTC       | Eastern Connection | Ann Devon      | Sales Agent   | (171) 555-0297 |
      | DUMON       | Du monde entier    | Janine Labrune | Owner         | France         |