Feature: Sort products alphabetically

  Background: User logs in to Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  Scenario: Sort products from A to Z
    Given The home page should be displayed
    When I select the filter "Name (A to Z)"
    Then The products should be sorted alphabetically from A to Z
