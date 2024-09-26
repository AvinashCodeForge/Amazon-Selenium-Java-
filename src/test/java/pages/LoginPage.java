package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class LoginPage {

    private final WebDriver driver;
    private final LoginPageLocators locators;
    String ITEM = "apple iphone 15 128 gb - yellow";

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
        WebElement mail_field = locators.loginInput("ap_email");
        for (char single : email.toCharArray()) {
            mail_field.sendKeys(String.valueOf(single));
            Thread.sleep(500); // Sleep for 0.5 seconds
        }
    }

    // Method to enter the user's password
    public void userPassword(String password) throws InterruptedException {
        WebElement password_field = locators.loginInput("ap_password");
        for (char single : password.toCharArray()) {
            password_field.sendKeys(String.valueOf(single));
            Thread.sleep(500); // Sleep for 0.5 seconds
        }
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(LoginPageLocators.CONTINUE_BUTTON);
        continueButton.click();
    }

    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(LoginPageLocators.SIGN_IN_BUTTON);
        signInButton.click();
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(LoginPageLocators.SEARCH_ICON);
        searchButton.click();
    }

    public void checkItemPrice() {
        WebElement itemPrice = driver.findElement(LoginPageLocators.ITEM_PRICE);
        String itemValue = itemPrice.getText();
        System.out.print(itemValue);
    }

    public void clickCartIcon() {
        WebElement cartIcon = driver.findElement(LoginPageLocators.CLICK_CART_ICON);
        cartIcon.click();
    }

    public void checkItem() {
        WebElement checkItem = driver.findElement(LoginPageLocators.CHECK_ITEM);
        checkItem.click();
    }

    public void clickDropDown() {
        WebElement dropDownButton = driver.findElement(LoginPageLocators.CLICK_DROPDOWN);
        dropDownButton.click();
    }

    public void clickSearchIcon() {
        WebElement searchIcon = driver.findElement(LoginPageLocators.SEARCH_BAR_ICON);
        searchIcon.sendKeys(ITEM);
    }

    public void clickAddToCartButton() throws InterruptedException {
        WebElement addToCartButton = driver.findElement(LoginPageLocators.ADD_TO_CART_BUTTON);
        addToCartButton.click();
        Thread.sleep(2000);
    }

    public void verify_search_results(){
        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> search_results = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        String search_item = "Apple iPhone 15 (128 GB) - Yellow";

        for (WebElement item : search_results) {
            wait.until(ExpectedConditions.visibilityOf(item));
            if (search_item.equals(item.getText())){
                item.click();
                break;
            }
        }
    }
    public void switchTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        String firstTab = driver.getWindowHandle();

        String secondTab = windowHandles.stream()
                .filter(handle -> !handle.equals(firstTab))
                .findFirst()
                .get();  // Get the new tab handle

        driver.switchTo().window(secondTab);
    }
}
