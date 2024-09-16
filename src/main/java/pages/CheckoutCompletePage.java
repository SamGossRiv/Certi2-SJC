package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    WebDriver driver;

    @FindBy(css = "h2.complete-header")
    WebElement thankYouForYourOrderLabel;

    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isThankYouMessageDisplayed(String message){
        try {
            String actualMessage = thankYouForYourOrderLabel.getText();
            return actualMessage.equalsIgnoreCase(message);  // Retorna directamente la comparación
        } catch (Exception e) {
            System.out.println("El mensaje de confirmación no se encontró: " + e.getMessage());
            return false;  // Retorna false si ocurre alguna excepción
        }
    }
}
