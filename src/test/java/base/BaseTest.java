package base;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public WebDriver setup(){
       driver = new ChromeDriver();
        return driver;
    }

    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}
