package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    private final LocatorsPage locatorsPage;
    public static String ITEM = "apple iphone 15 128 gb - yellow";

    // Constructor to initialize WebDriver and locators
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.locatorsPage = new LocatorsPage(driver);
    }

    // Method to get the title of the page
    public String getTitle() {
        return driver.getTitle();
    }

    // Method to click on the search icon
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(LocatorsPage.SEARCH_ICON);
        searchButton.click();
    }

    // Method to enter the item name in the search input field
    public void clickSearchInputField() {
        WebElement searchIcon = driver.findElement(LocatorsPage.SEARCH_INPUT);
        searchIcon.sendKeys(ITEM);
    }
}
