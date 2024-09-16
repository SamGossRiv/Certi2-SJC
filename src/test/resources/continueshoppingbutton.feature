Feature: Continue shopping button functionality

  Background: User logs in to Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  Scenario: Verify that the continue shopping button works correctly
    Given The home page should be displayed
    When I add to the cart the product "Sauce Labs Backpack"
    And I click on the cart button
    Then I click on the continue shopping button
    Then The home page should be displayed again
