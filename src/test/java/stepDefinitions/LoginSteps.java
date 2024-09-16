package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I set the user name text box with {string}")
    public void setUserName(String userName) {
        loginPage.setUserNameTextBox(userName);
    }

    @And("I set the password text box with {string}")
    public void setPassword(String password) {
        loginPage.setPasswordTextBox(password);
    }

    @And("I click on the login button")
    public void clickOnLogin() {
        loginPage.clickOnLoginButton();
    }

    @Then("An error message that says {string} should be displayed")
    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assertions.assertEquals(expectedMessage, actualMessage, "The error message does not match the expected one.");
    }


}
