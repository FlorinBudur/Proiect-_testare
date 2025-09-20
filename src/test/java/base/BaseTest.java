package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUpTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private"); // modul incognito pentru Firefox

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
