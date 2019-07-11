@wip
Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.

  Scenario Outline: Customer place an order by purchasing an item from search - customer details are taken from JSON file
    Given user is on Home Page
    When he search for "dress"
    And choose to buy the first item
    And moves to checkout from mini cart
    And enter <customer> personal details on checkout page
    And place the order
    Then verify the order details
    Examples:
      | customer |
      | Natalia  |
      |  Tyler   |



  Scenario: Customer place an order by purchasing an item from search - customer details are taken from DataTable
    Given user is on Home Page
    When he search for "dress"
    And choose to buy the first item
    And moves to checkout from mini cart
    And enter customer personal details  as follows on checkout page
      | first_name | last_name | country             | street_address    | town      | postcode | phone_number| email_address |
      | Natalia    | Lyaskina  | United Kingdom (UK) | 29 Duchess Street | Newcastle | NE12 7PE | 07815111222 | test@test.com |
    And place the order
    Then verify the order details


