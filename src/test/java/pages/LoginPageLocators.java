package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class LoginPageLocators {

    public static final By SEARCH_BAR_ICON = By.cssSelector("#twotabsearchtextbox");
    String ITEM = "apple iphone 15 128 gb - yellow";
    public static final By SEARCH_ICON = By.cssSelector("input[type='submit']");
    public static final By URLS = By.tagName("a");
    public static final By HAMBURGER_MENU_URLS = By.xpath("//div[@class='nav-left']//parent::div[@id='nav-main']");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']");
    public static final By CONTINUE_BUTTON = By.xpath("//span[@id='continue']");
    public static final By SIGN_IN_BUTTON = By.xpath("//input[@id='signInSubmit']");
    public static final By ITEM_PRICE = By.xpath("//span[@id='sc-subtotal-amount-activecart']");
    public static final By CLICK_CART_ICON = By.xpath("//div[@id='attach-desktop-sideSheet']//div[@class='a-fixed-left-grid']//form//input");
    public static final By CHECK_ITEM = By.xpath("//span[text()='Currently unavailable.']");
    public static final By CLICK_DROPDOWN = By.xpath("//span[@tabindex='-1']");

    private final WebDriver driver;

    public LoginPageLocators(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSearchIcon() {
        WebElement searchIcon = driver.findElement(LoginPageLocators.SEARCH_BAR_ICON);
        searchIcon.click();
    }

    public void clickAddToCartButton() {
        WebElement addToCartButton = driver.findElement(LoginPageLocators.ADD_TO_CART_BUTTON);
        addToCartButton.click();
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(LoginPageLocators.CONTINUE_BUTTON);
        continueButton.click();
    }

    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(LoginPageLocators.SIGN_IN_BUTTON);
        signInButton.click();
    }

    public void clickDropDown() {
        WebElement dropDownButton = driver.findElement(LoginPageLocators.CLICK_DROPDOWN);
        dropDownButton.click();
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(LoginPageLocators.SEARCH_ICON);
        searchButton.click();
    }

    public void checkItemPrice() {
        WebElement itemPrice = driver.findElement(LoginPageLocators.ITEM_PRICE);
        itemPrice.click();
    }

    public void clickCartIcon() {
        WebElement cartIcon = driver.findElement(LoginPageLocators.CLICK_CART_ICON);
        cartIcon.click();
    }

    public void checkItem() {
        WebElement checkItem = driver.findElement(LoginPageLocators.CHECK_ITEM);
        checkItem.click();
    }

    public WebElement loginInput(String input){
        return driver.findElement(By.xpath("//input[@id='" + input + "']"));
    }

    public void hoverOverAndClickOnSignInButton(){
        Actions actions = new Actions(driver);
        // Step 1: Trigger verification email via Selenium
        WebElement element = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(element).build().perform();
        WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign in']"));
        signIn.click();
    }
}
