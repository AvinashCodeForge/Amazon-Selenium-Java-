package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Objects;


public class LoginTests extends BaseTest {

    String EMAIL = "avinashch9998@gmail.com";
    String PASSWORD = "demoaccount@9";
    String URL = "https://www.amazon.in/ref=nav_signin";
    String TITLE = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

    @BeforeMethod
    public void test_signIn() throws InterruptedException {
        driver.get(URL);
        LoginPage login = new LoginPage(driver);
        login.hoverOverAndClickOnSignInButton();
        login.userEmail(EMAIL);
        login.clickContinueButton();
        login.userPassword(PASSWORD);
        login.clickSignInButton();

    }

    @Test
    public void test_verifyLoginPageTitle() {
        String title = driver.getTitle();
        assert Objects.equals(title, TITLE);
    }

    @Test
    public void test_verifySearchItemDisplay() {
        LoginPage login = new LoginPage(driver);
        login.clickSearchIcon();
        login.clickSearchButton();
        String title = login.getTitle();
        assert Objects.equals(title, "Amazon.in : apple iphone 15 128 gb - yellow");
    }

    @Test
    public void test_verifyProductPage() {
        LoginPage login = new LoginPage(driver);
        login.clickSearchIcon();
        login.clickSearchButton();
        login.verify_search_results();
        String title = login.getTitle();
        assert Objects.equals(title, "Amazon.in : apple iphone 15 128 gb - yellow");
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
