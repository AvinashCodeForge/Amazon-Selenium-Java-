package tests;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.Objects;


public class LoginTests extends BaseTest {

    String EMAIL = "avinashch9998@gmail.com";
    String PASSWORD = "demoaccount@9";
    String URL = "https://www.amazon.in/ref=nav_signin";

    @Test
    public void test_signIn() throws InterruptedException {
        driver.get(URL);
        LoginPage login = new LoginPage(driver);
        login.hoverOnSignIn();
        login.userEmail(EMAIL);
        login.continueButton();
        login.userPassword(PASSWORD);
        login.signIn();
        String title = login.getTitle();
        assert Objects.equals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");

    }
}
