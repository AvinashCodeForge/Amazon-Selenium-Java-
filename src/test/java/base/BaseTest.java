package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;

    public BaseTest(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\Avinash\\IdeaProjects\\SeleniumProject\\src\\main\\java\\config\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            driver = new ChromeDriver(); // remove the 'WebDriver' declaration here
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
        }
    }
}
