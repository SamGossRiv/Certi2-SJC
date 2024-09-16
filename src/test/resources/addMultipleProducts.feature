Feature: Add multiple products to cart

  Background: User logs in to Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  Scenario: Add multiple products to the cart
    Given The home page should be displayed
    When I add to the cart the product "Sauce Labs Backpack"
    And I add to the cart the product "Sauce Labs Bike Light"
    And I add to the cart the product "Sauce Labs Bolt T-Shirt"
    And I click on the cart button
    Then The cart should contain 3 items
