package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @And("The home page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assertions.assertTrue(homePage.sauceDemoTitleIsDisplayed());
    }

    @And("The product {string} should be displayed in the home page")
    public void verifyProductIsDisplayed(String productName){
        Assertions.assertTrue(homePage.isProductInHomePage(productName));
    }

    @And("I add to the cart the product {string}")
    public void addProductToCart(String productName) throws InterruptedException {
        homePage.addProductToCart(productName);
    }

    @And("The cart icon should display {string}")
    public void verifyCartIconNumber(String iconNumber){
        Assertions.assertTrue(homePage.verifyCartIconNumber(iconNumber));
    }

    @And("I remove the product {string} from the cart")
    public void removeProductFromCart(String productName){
        homePage.removeProductFromCart(productName);
    }

    @And("I click on the cart button")
    public void clickOnCartIcon(){
        homePage.clickOnCartButton();
    }


    @And("I select the filter {string}")
    public void selectFilter(String filterOption) {
        homePage.selectFilterOption(filterOption);
    }

    @And("The products should be sorted by price in descending order")
    public void verifyProductsAreSortedByPrice() {
        Assertions.assertTrue(homePage.areProductsSortedByPriceDescending());
    }

    @And("The products should be sorted alphabetically from A to Z")
    public void verifyProductsSortedAlphabetically() {
        Assertions.assertTrue(homePage.verifyProductsSortedAlphabetically(), "Products are not sorted alphabetically from A to Z.");
    }

    @Then("The home page should be displayed again")
    public void the_home_page_should_be_displayed_again() {
        Assertions.assertTrue(homePage.sauceDemoTitleIsDisplayed(), "The home page is not displayed as expected.");
    }


}
