package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.OverviewPage;

public class OverviewSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    OverviewPage overviewPage = new OverviewPage(driver);

    @Given("I click on finish button")
    public void clickOnContinueButton() {
        overviewPage.clickOnFinishButton();
    }
}
