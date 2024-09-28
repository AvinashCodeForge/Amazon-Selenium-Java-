package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTests extends BaseTest {

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
    public void test_verifySearchItemDisplay() {
        HomePage home = new HomePage(driver);
        home.clickSearchInputField();
        home.clickSearchButton();
        String title = home.getTitle();
        Assert.assertEquals(title, "Amazon.in : apple iphone 15 128 gb - yellow");
    }
}
