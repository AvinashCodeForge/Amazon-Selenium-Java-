package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class ProductPageTest extends BaseTest {

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

    private void searchIem(){
        HomePageTests home = new HomePageTests();
        home.test_verifySearchItemDisplay();
    }

    @Test
    public void test_verifyProductPage() {
        ProductPage product = new ProductPage(driver);
        searchIem();
        product.verify_search_results();
        String title = product.getTitle();
        Assert.assertEquals(title, "Amazon.in : apple iphone 15 128 gb - yellow");
    }

    @Test
    public void test_verifyItemAddedToCartSuccessfully() throws InterruptedException {
        ProductPage product = new ProductPage(driver);
        searchIem();
        product.verify_search_results();
        product.switchTab();
        product.clickAddToCartButton();
    }
}
