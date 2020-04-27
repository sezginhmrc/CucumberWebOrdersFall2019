@Smoke_Test
Feature: Add order
  As i user, I want to be able to create new orders


  Scenario: Verify user successfully create product information
    Given user is on the login page
    And user logs in
    And navigates to "Order" page
    When user enter product information:

      | Product     | Quantity | Price per unit | Discount |
      | ScreenSaver | 12       | 20             | 10       |

    And user clicks on Calculate Button
    Then user should verify that total "216" is displayed


    And user enter address information:
      | Customer name | Street  | City          | State    | Zip   |
      | Test User     | 5th Ave | New York City | New York | 10011 |

    And User enter payment information
      | Card | Card Nr:  | Expire date (mm/yy) |
      | Visa | 123456789 | 04/25               |

    And user click on process button
    Then system should displayed "New order has been successfully added."
    And  navigates to "View all orders" page
    Then user verifies that order is displayed

      | Test User     |
      | ScreenSaver   |
      | 12            |
      | 04/23/2020    |
      | 5th Ave       |
      | New York City |
      | New York      |
      | 10011         |
      | Visa          |
      | 123456789     |
      | 04/25         |