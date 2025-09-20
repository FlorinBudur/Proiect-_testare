package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;


    By checkoutButton = By.id("checkout");
    By cartItems = By.className("cart_item");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
    public int getNumberOfProductsInCart() {
        return driver.findElements(cartItems).size();
    }
}

