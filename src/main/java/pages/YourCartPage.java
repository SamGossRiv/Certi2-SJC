package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }

    public void removeProduct(String productName) {
        String formattedProductName = productName.toLowerCase().replace(" ", "-");
        String removeButtonId = "remove-" + formattedProductName;
        WebElement removeButton = driver.findElement(By.id(removeButtonId));
        removeButton.click();
    }

    public int getItemCount() {
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        String itemCountText = cartBadge.getText();
        return Integer.parseInt(itemCountText);
    }

    public void clickOnContinueShoppingButton() {
        WebElement continueShoppingButton = driver.findElement(By.id("continue-shopping"));
        continueShoppingButton.click();
    }

}
