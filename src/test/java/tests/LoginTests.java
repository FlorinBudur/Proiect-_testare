package tests;

import base.BaseTest;
import pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginValid() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assertions.assertEquals(
                "https://www.saucedemo.com/inventory.html",
                driver.getCurrentUrl(),
                "Eșec la autentificare cu date corecte!"
        );
    }

    @Test
    public void testLoginWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "123456");
        Assertions.assertTrue(
                loginPage.getErrorMessage().contains("Epic sadface: Username and password do not match any user in this service"),
                "Mesajul de eroare nu este afișat pentru parolă greșită!"
        );
    }

    @Test
    public void testLoginInvalidUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Florin", "secret_sauce");
        Assertions.assertTrue(
                loginPage.getErrorMessage().contains("Epic sadface: Username and password do not match any user in this service"),
                "Mesajul de eroare nu este afișat pentru username invalid!"
        );
    }

    @Test
    public void testEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "secret_sauce");
        Assertions.assertTrue(
                loginPage.getErrorMessage().contains("Epic sadface: Username is required"),
                "Mesajul de eroare nu este afișat pentru username gol!"
        );
    }

    @Test
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "");
        Assertions.assertTrue(
                loginPage.getErrorMessage().contains("Epic sadface: Password is required"),
                "Mesajul de eroare nu este afișat pentru parolă goală!"
        );
    }
}

