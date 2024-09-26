package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Properties;


public class LoginTests extends BaseTest {

    String TITLE = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

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

    @Test
    public void test_verifyLoginPageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, TITLE);
    }

    @Test
    public void test_verifySearchItemDisplay() {
        LoginPage login = new LoginPage(driver);
        login.clickSearchIcon();
        login.clickSearchButton();
        String title = login.getTitle();
        Assert.assertEquals(title, "Amazon.in : apple iphone 15 128 gb - yellow");
    }

    @Test
    public void test_verifyProductPage() {
        LoginPage login = new LoginPage(driver);
        login.clickSearchIcon();
        login.clickSearchButton();
        login.verify_search_results();
        String title = login.getTitle();
        Assert.assertEquals(title, "Amazon.in : apple iphone 15 128 gb - yellow");
    }

    @Test
    public void test_verifyItemAddedToCartSuccessfully() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        driver.manage().window().maximize();
        login.clickSearchIcon();
        login.clickSearchButton();
        login.verify_search_results();
        login.switchTab();
        login.clickAddToCartButton();
    }

    @Test
    public void test_verifyItemInCart() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        driver.manage().window().maximize();
        login.clickSearchIcon();
        login.clickSearchButton();
        login.verify_search_results();
        login.switchTab();
        login.clickAddToCartButton();
        Thread.sleep(2000);
        login.clickCartIcon();
        login.checkItemPrice();
        Thread.sleep(2000);
    }
}
