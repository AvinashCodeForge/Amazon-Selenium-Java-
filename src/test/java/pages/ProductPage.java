package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ProductPage {

    private final WebDriver driver;
    private final LocatorsPage locatorsPage;

    // Method to get the title of the page
    public String getTitle() {
        return driver.getTitle();
    }

    // Constructor to initialize WebDriver and locators
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.locatorsPage = new LocatorsPage(driver);
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

    // Method to click on the Add to Cart button
    public void clickAddToCartButton() throws InterruptedException {
        WebElement addToCartButton = driver.findElement(LocatorsPage.ADD_TO_CART_BUTTON);
        addToCartButton.click();
        Thread.sleep(2000);
    }
}
