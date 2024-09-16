package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.YourCartPage;

public class YourCartSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    YourCartPage yourCartPage = new YourCartPage(driver);

    @And("I click on the checkout button")
    public void clickOnCheckoutButton() {
        yourCartPage.clickOnCheckoutButton();
    }


    @When("I remove the product {string}")
    public void i_remove_the_product(String productName) {
        yourCartPage.removeProduct(productName);
    }


    @Then("The cart should contain {int} items")
    public void the_cart_should_contain_items(Integer itemCount) {
        int actualItemCount = yourCartPage.getItemCount();
        Assertions.assertEquals(itemCount, actualItemCount, "The cart does not contain the expected number of items.");
    }

    @And("I click on the continue shopping button")
    public void clickOnContinueShoppingButton() {
        yourCartPage.clickOnContinueShoppingButton();
    }

}
