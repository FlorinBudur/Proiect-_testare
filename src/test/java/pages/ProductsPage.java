package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    // Locatori
    private By firstProductAddBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBtn = By.id("remove-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");
    private By sortDropdown = By.className("product_sort_container");
    private By priceElements = By.className("inventory_item_price");
    private By nameElements = By.className("inventory_item_name");

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Acțiuni
    public void addFirstProductToCart() {
        driver.findElement(firstProductAddBtn).click();
    }

    public void removeFirstProductFromCart() {
        driver.findElement(removeBtn).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public void sortBy(String optionValue) {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        dropdown.selectByValue(optionValue);
    }

    // Verificări
    public boolean isSortedByPriceAscending() {
        List<WebElement> prices = driver.findElements(priceElements);
        List<Double> actual = prices.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .toList();
        List<Double> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);
        return actual.equals(sorted);
    }

    public boolean isSortedAlphabetically() {
        List<WebElement> names = driver.findElements(nameElements);
        List<String> actual = names.stream().map(WebElement::getText).toList();
        List<String> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);
        return actual.equals(sorted);
    }

    public boolean isAddToCartButtonVisible() {
        return driver.findElement(firstProductAddBtn).isDisplayed();
    }

    public boolean isRemoveButtonVisible() {
        return driver.findElement(removeBtn).isDisplayed();
    }
}


