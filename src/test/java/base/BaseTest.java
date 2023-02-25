package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Objects;

/***
 * 1. This class is responsible to initialize driver and quit the driver.
 * 2. According to the assignment and scope I preferred to use @befpre and @after methods we usually use
 * @beforeTest and @AfterTest
 * 3. have used driver manager dependency to create driver instance
 */
public class BaseTest {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    @Parameters("browser")
    @BeforeMethod
    public void BeforeTest(String browser){
        //initialize the driver
        if(Objects.equals(browser, "FIREFOX")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else if (browser.equals("CHROME")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browser.equals("OPERA")) {
            driver = WebDriverManager.operadriver().create();
        }
        driver.manage().window().maximize();

    }

    public WebElement waitForElementToDisplay(String locator){
        return wait.until(driver -> driver.findElement(By.cssSelector(locator)));
    }

    @AfterMethod
    public void AfterTest(){
        driver.quit();
    }
}
