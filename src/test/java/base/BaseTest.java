package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentManager;

public class BaseTest {
    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeAll
    public static void setupReport() {
        extent = ExtentManager.getInstance();
    }

    @BeforeEach
    public void setup(TestInfo testInfo) {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private"); // incognito mode

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        test = extent.createTest(testInfo.getDisplayName());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void flushReport() {
        extent.flush();
    }
}

