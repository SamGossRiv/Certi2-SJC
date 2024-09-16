Feature: Checkout with invalid data

  Background: User logs in to Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  Scenario: Checkout with invalid customer data
    Given The home page should be displayed
    When I add to the cart the product "Sauce Labs Backpack"
    And I click on the cart button
    And I click on the checkout button
    And I fill the checkout information with
      | 123456   | @@@@     | 000000 |
    And I click on continue button
    Then A message that says "Error: First Name is required" should be displayed
