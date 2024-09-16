package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import pages.CheckoutCompletePage;
import org.openqa.selenium.WebDriver;

public class CheckoutCompleteSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

    @And("A message that says {string} should be displayed")
    public void verifyCheckoutCompleteMessage(String message) {
        Assertions.assertTrue(checkoutCompletePage.isThankYouMessageDisplayed(message));
    }


}
