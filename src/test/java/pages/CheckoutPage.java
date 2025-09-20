package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;


    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By confirmationMsg = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutInfo(String fName, String lName, String zip) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }

    public void finishOrder() {
        driver.findElement(finishBtn).click();
    }

    public String getConfirmationMsg() {
        return driver.findElement(confirmationMsg).getText();
    }
    public String getFirstNameValue() {
        return driver.findElement(firstName).getAttribute("value");
    }

    public String getLastNameValue() {
        return driver.findElement(lastName).getAttribute("value");
    }

    public String getPostalCodeValue() {
        return driver.findElement(postalCode).getAttribute("value");
    }

}
