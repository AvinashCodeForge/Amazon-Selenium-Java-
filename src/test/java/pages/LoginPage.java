package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;


public class LoginPage {

    private final WebDriver driver;
    private final LoginPageLocators locators;
    public static String ITEM = "apple iphone 15 128 gb - yellow";

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

    // Method to click on continue button after entering the username
    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(LoginPageLocators.CONTINUE_BUTTON);
        continueButton.click();
    }

    // Method to click on sign-in button
    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(LoginPageLocators.SIGN_IN_BUTTON);
        signInButton.click();
    }

    // Method to click on the search icon
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(LoginPageLocators.SEARCH_ICON);
        searchButton.click();
    }

    // Method to check item price after adding into the cart
    public void checkItemPrice() {
        WebElement itemPrice = driver.findElement(LoginPageLocators.ITEM_PRICE);
        String itemValue = itemPrice.getText();
        System.out.print(itemValue);
    }

    // Method to click on cart icon
    public void clickCartIcon() {
        WebElement cartIcon = driver.findElement(LoginPageLocators.CLICK_CART_ICON);
        cartIcon.click();
    }

    // Method to check the item is in stock
    public void checkItem() {
        WebElement checkItem = driver.findElement(LoginPageLocators.CHECK_ITEM);
        checkItem.click();
    }

    // Method to click on dropdown to select the quantity
    public void clickDropDown() {
        WebElement dropDownButton = driver.findElement(LoginPageLocators.CLICK_DROPDOWN);
        dropDownButton.click();
    }

    // Method to enter the item name in the search input field
    public void clickSearchInputField() {
        WebElement searchIcon = driver.findElement(LoginPageLocators.SEARCH_INPUT);
        searchIcon.sendKeys(ITEM);
    }

    // Method to click on the Add to Cart button
    public void clickAddToCartButton() throws InterruptedException {
        WebElement addToCartButton = driver.findElement(LoginPageLocators.ADD_TO_CART_BUTTON);
        addToCartButton.click();
        Thread.sleep(2000);
    }

    // Method to find the search item from the search results
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

    // Method to switch the tabs
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
