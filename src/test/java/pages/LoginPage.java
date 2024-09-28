package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class LoginPage {

    private final WebDriver driver;
    private final LocatorsPage locatorsPage;
    public static String ITEM = "apple iphone 15 128 gb - yellow";

    // Constructor to initialize WebDriver and locators
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.locatorsPage = new LocatorsPage(driver);
    }

    // Method to get the title of the page
    public String getTitle() {
        return driver.getTitle();
    }

    // Method to hover and click on the Sign In button
    public void hoverOverAndClickOnSignInButton() {
        Actions actions = new Actions(driver);
        // Step 1: Trigger verification email via Selenium
        WebElement element = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(element).build().perform();
        WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign in']"));
        signIn.click();
    }

    // Method to enter the user's email
    public void userEmail(String email) throws InterruptedException {
        WebElement mail_field = locatorsPage.loginInput("ap_email");
        for (char single : email.toCharArray()) {
            mail_field.sendKeys(String.valueOf(single));
            Thread.sleep(500); // Sleep for 0.5 seconds
        }
    }

    // Method to enter the user's password
    public void userPassword(String password) throws InterruptedException {
        WebElement password_field = locatorsPage.loginInput("ap_password");
        for (char single : password.toCharArray()) {
            password_field.sendKeys(String.valueOf(single));
            Thread.sleep(500); // Sleep for 0.5 seconds
        }
    }

    // Method to click on continue button after entering the username
    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(LocatorsPage.CONTINUE_BUTTON);
        continueButton.click();
    }

    // Method to click on sign-in button
    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(LocatorsPage.SIGN_IN_BUTTON);
        signInButton.click();
    }
}
