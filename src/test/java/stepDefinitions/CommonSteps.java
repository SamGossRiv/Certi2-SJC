package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();

    @Given("I am in sauce demo web page")
    public void goToSauceDemoPage() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
}
