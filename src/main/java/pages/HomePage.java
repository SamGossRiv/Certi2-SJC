package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement sauceDemoTitle;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productsTitle;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartIcon;

    @FindBy(className = "product_sort_container")
    WebElement filterDropdown;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrices;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean sauceDemoTitleIsDisplayed() {
        return sauceDemoTitle.isDisplayed();
    }

    public boolean isProductInHomePage(String productName){
        for(WebElement element : productsTitle){
            if(element.getText().equalsIgnoreCase(productName)){
                return true;
            }
        }
        return false;
    }

    public void addProductToCart(String productName){
        String productId = "add-to-cart-" + productName.replace(" ", "-").toLowerCase();
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();
    }

    public boolean verifyCartIconNumber(String cartNumber){
        String actualCartNumber = cartIcon.getText();
        return actualCartNumber.equalsIgnoreCase(cartNumber);
    }

    public void removeProductFromCart(String productName){
        String productId = "remove-" + productName.replace(" ", "-").toLowerCase();
        WebElement removeProductButton = driver.findElement(By.id(productId));
        removeProductButton.click();
    }

    public void clickOnCartButton(){
        cartIcon.click();
    }

    public void selectFilterOption(String filterOption) {
        Select dropdown = new Select(filterDropdown);
        dropdown.selectByVisibleText(filterOption);
    }

    public boolean areProductsSortedByPriceDescending() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }

        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Collections.reverseOrder());

        return prices.equals(sortedPrices);
    }

    public boolean verifyProductsSortedAlphabetically() {
        List<String> productNames = new ArrayList<>();
        for (WebElement product : productsTitle) {
            productNames.add(product.getText());
        }

        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);

        return productNames.equals(sortedProductNames);
    }

    public void clickOnContinueShoppingButton() {
        WebElement continueShoppingButton = driver.findElement(By.id("continue-shopping"));
        continueShoppingButton.click();
    }

}
