package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseTest {

    private WebDriver driver;

    String getStartedButtonLocator = "button[type='submit']";

    public HomePage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String getButtonText(){
        return waitForElementToDisplay(getStartedButtonLocator).getText();
    }

    public HomePage goToUrl(String url){
        driver.get(url);
        return this;
    }

}

