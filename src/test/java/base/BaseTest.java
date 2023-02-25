package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/***
 * 1. This class is responsible to initialize driver and quit the driver.
 * 2. According to the assignment and scope I preferred to use @befpre and @after methods we usually use
 * @beforeTest and @AfterTest
 * 3. have used driver manager dependency to create driver instance
 */
public class BaseTest {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected WebDriverWait wait;
    protected Properties props;

    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void BeforeTest(String browser){
        //initialize the driver
        if(Objects.equals(browser, "FIREFOX")) {
            setDriver(WebDriverManager.firefoxdriver().create());
        } else if (browser.equals("CHROME")) {
            setDriver(WebDriverManager.chromedriver().create());
        } else if (browser.equals("OPERA")) {
            setDriver(WebDriverManager.operadriver().create());
        }
        getDriver().manage().window().maximize();

    }

    public WebElement waitForElementToDisplay(String locator){
        return wait.until(driver -> driver.findElement(By.cssSelector(locator)));
    }

    @Parameters("browser")
    @AfterMethod
    public void AfterTest(ITestResult result, String browser) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            File destFile = new File("src" + File.separator + browser + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");
            takeScreenshot(destFile);
        }
        getDriver().quit();
    }

    private void takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }

    public Properties getProps() throws IOException, ParseException {
        props=new Properties();
        FileReader reader=new FileReader( System.getProperty("user.dir")+"/src/test/java/TestData/Data.properties");
        props.load(reader);
        return props;
    }
}
