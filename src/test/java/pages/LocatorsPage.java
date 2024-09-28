package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LocatorsPage {

    private final WebDriver driver;

    // Locator for the search input field
    public static final By SEARCH_INPUT = By.cssSelector("#twotabsearchtextbox");

    // Locator for the search icon
    public static final By SEARCH_ICON = By.cssSelector("input[type='submit']");

    // Locator for the hamburger menu
    public static final By HAMBURGER_MENU_URLS = By.xpath("//div[@class='nav-left']//parent::div[@id='nav-main']");

    // Locator for the Add to cart button
    public static final By ADD_TO_CART_BUTTON = By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']");

    // Locator for the continue button
    public static final By CONTINUE_BUTTON = By.xpath("//span[@id='continue']");

    // Locator for the sign in field
    public static final By SIGN_IN_BUTTON = By.xpath("//input[@id='signInSubmit']");

    // Locator for the item price
    public static final By ITEM_PRICE = By.xpath("//span[@id='sc-subtotal-amount-activecart']");

    // Locator for the cart icon
    public static final By CLICK_CART_ICON = By.xpath("//div[@id='attach-desktop-sideSheet']//div[@class='a-fixed-left-grid']//form//input");

    // Locator for the check item
    public static final By CHECK_ITEM = By.xpath("//span[text()='Currently unavailable.']");

    // Locator for the quantity dropdown
    public static final By CLICK_DROPDOWN = By.xpath("//span[@tabindex='-1']");

    // Constructor to initialize WebDriver
    public LocatorsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the input username and password field
    public WebElement loginInput(String input) {
        return driver.findElement(By.xpath("//input[@id='" + input + "']"));

    }
}
