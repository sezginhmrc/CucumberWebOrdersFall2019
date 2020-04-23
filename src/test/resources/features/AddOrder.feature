@Create_Order
Feature: Add order
  As i user, I want to be able to create new orders

  Background: user lading open page

    Given user is on the login page

  Scenario: Verify user successfully create an order

    And user logs in
    And navigates to "Order" page
    When user enter product information:

      | Product     | Quantity | Price per unit | Discount |
      | ScreenSaver | 12       | 20             | 10       |

    And user clicks on Calculate Button
    Then user should verify that total "216" is displayed


    When user enter address information:
      | Customer name | Street     | City   | State   | Zip   |
      | Esma          | CamMahalle | Espiye | Giresun | 28610 |

    And User enter payment information
      | Card | Card Nr:  | Expire date (mm/yy) |
      | Visa | 123456789 | 04/25               |

    And user click on process button
    And user navigates to "View all orders" page
    Then user verifies that order is displayed


      | Name      | Product     | #  | Date      | Street     | City   | State   | Zip   | Card | Card Number | Exp   |
      | Test user | Screensaver | 12 | 04/23/220 | CamMahalle | Espiye | Giresun | 28610 | Visa | 123456789   | 04/25 |
