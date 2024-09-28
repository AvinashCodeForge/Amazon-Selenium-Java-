package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPage {

    private final WebDriver driver;
    private final LocatorsPage locatorsPage;

    // Constructor to initialize WebDriver and locators
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.locatorsPage = new LocatorsPage(driver);
    }

    // Method to check item price after adding into the cart
    public void checkItemPrice() {
        WebElement itemPrice = driver.findElement(LocatorsPage.ITEM_PRICE);
        String itemValue = itemPrice.getText();
        System.out.print(itemValue);
    }

    // Method to click on cart icon
    public void clickCartIcon() {
        WebElement cartIcon = driver.findElement(LocatorsPage.CLICK_CART_ICON);
        cartIcon.click();
    }

    // Method to check the item is in stock
    public void checkItem() {
        WebElement checkItem = driver.findElement(LocatorsPage.CHECK_ITEM);
        checkItem.click();
    }

    // Method to click on dropdown to select the quantity
    public void clickDropDown() {
        WebElement dropDownButton = driver.findElement(LocatorsPage.CLICK_DROPDOWN);
        dropDownButton.click();
    }
}
