Feature: Verify sorting functionality

  Background: User logs in to Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  Scenario: Sort products from high to low price
    Given The home page should be displayed
    When I select the filter "Price (high to low)"
    Then The products should be sorted by price in descending order
