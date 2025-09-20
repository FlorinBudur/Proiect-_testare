package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ExamTest extends BaseTest {

    @Test
    public void testPlaceOrder() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");


        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.goToCart();


        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();


        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInfo("Budur", "Florin", "123456");


        checkoutPage.finishOrder();


        String msg = checkoutPage.getConfirmationMsg();
        Assertions.assertTrue(
                msg.contains("Thank you for your order"),
                "Comanda nu a fost finalizată corect!"
        );
    }

    @Test
    public void testSortByPriceLowToHigh() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortBy("lohi");

        Assertions.assertTrue(productsPage.isSortedByPriceAscending(),
                "Produsele NU sunt sortate corect după preț crescător!");

    }

    @Test
    public void testSortAlphabeticallyAtoZ() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");


        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortBy("az");

        Assertions.assertTrue(productsPage.isSortedAlphabetically(),
                "Produsele NU sunt sortate corect alfabetic (A la Z)!");

    }

    @Test
    public void testCheckoutWithEmptyCartl() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.goToCart();


        CartPage cartPage = new CartPage(driver);
        int itemsCount = cartPage.getNumberOfProductsInCart();
        Assertions.assertEquals(0, itemsCount, "Eroare: coșul NU este gol!");

        cartPage.clickCheckout();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertFalse(currentUrl.contains("checkout-step-one.html"),
                "BUG: Aplicația permite checkout cu coșul gol!");
    }


    @Test
    public void testAddToCartButton() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        Assertions.assertTrue(
                productsPage.isAddToCartButtonVisible(),
                "Butonul Add to Cart NU este vizibil pe pagina principală!"
        );

        productsPage.addFirstProductToCart();

        Assertions.assertTrue(
                productsPage.isRemoveButtonVisible(),
                "Butonul NU s-a schimbat în Remove după adăugare în coș!"
        );
    }

}

