package tests;

import base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class CartPageTest extends BaseTest {

    @BeforeMethod
    public void test_signIn() throws InterruptedException {
        initialization();
        LoginPage login = new LoginPage(driver);
        login.hoverOverAndClickOnSignInButton();
        login.userEmail(prop.getProperty("username"));
        login.clickContinueButton();
        login.userPassword(prop.getProperty("password"));
        login.clickSignInButton();

    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }

    private void cartItem() throws InterruptedException {
        ProductPageTest product = new ProductPageTest();
        product.test_verifyItemAddedToCartSuccessfully();
    }

    @Test
    public void test_verifyItemInCart() throws InterruptedException {
        CartPage cart = new CartPage(driver);
        cartItem();
        Thread.sleep(2000);
        cart.clickCartIcon();
        cart.checkItemPrice();
        Thread.sleep(2000);
    }
}
