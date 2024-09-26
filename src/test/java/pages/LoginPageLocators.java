package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class LoginPageLocators {

    private final WebDriver driver;


    public static final By SEARCH_BAR_ICON = By.cssSelector("#twotabsearchtextbox");
    public static final By SEARCH_ICON = By.cssSelector("input[type='submit']");
    //public static final By HAMBURGER_MENU_URLS = By.xpath("//div[@class='nav-left']//parent::div[@id='nav-main']");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']");
    public static final By CONTINUE_BUTTON = By.xpath("//span[@id='continue']");
    public static final By SIGN_IN_BUTTON = By.xpath("//input[@id='signInSubmit']");
    public static final By ITEM_PRICE = By.xpath("//span[@id='sc-subtotal-amount-activecart']");
    public static final By CLICK_CART_ICON = By.xpath("//div[@id='attach-desktop-sideSheet']//div[@class='a-fixed-left-grid']//form//input");
    public static final By CHECK_ITEM = By.xpath("//span[text()='Currently unavailable.']");
    public static final By CLICK_DROPDOWN = By.xpath("//span[@tabindex='-1']");

    public LoginPageLocators(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement loginInput(String input) {
        return driver.findElement(By.xpath("//input[@id='" + input + "']"));

    }
}
