package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginPageTests extends BaseTest {

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
}
