package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;
    private final LoginPageLocators locators;

    // Constructor to initialize WebDriver and locators
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.locators = new LoginPageLocators(driver);
    }

    // Method to get the title of the page
    public String getTitle() {
        return driver.getTitle();
    }

    // Method to hover and click on the Sign In button
    public void hoverOnSignIn() {
        locators.hoverOverAndClickOnSignInButton();
    }

    // Method to enter the user's email
    public void userEmail(String email) throws InterruptedException {
        WebElement mail_field = locators.loginInput("ap_email");
        for (char single : email.toCharArray()){
            mail_field.sendKeys(String.valueOf(single));
            Thread.sleep(1000); // Sleep for 3 seconds
        }
    }

    // Method to enter the user's password
    public void userPassword(String password) throws InterruptedException {
        WebElement password_field= locators.loginInput("ap_password");
        for (char single: password.toCharArray()){
            password_field.sendKeys(String.valueOf(single));
            Thread.sleep(1000); // Sleep for 3 seconds
        }
    }
    public void continueButton() throws InterruptedException {
        locators.clickContinueButton();
        Thread.sleep(1000);
    }
    public void signIn(){
        locators.clickSignInButton();
    }
}
