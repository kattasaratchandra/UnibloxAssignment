package tests;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

public class UrlTest extends BaseTest {
    HomePage home;

    @BeforeMethod
    public  void beforeMethod(){
        home = new HomePage(driver);
    }

    @Test(dataProvider = "test data")
    public void HttpTest(String url) {
        try {
            home.goToUrl(url);
            String actual = home.getButtonText();
            Assert.assertEquals(actual, "Get Started");
        } catch (Exception e) {
            System.out.println(e.toString());
            if (e.toString().contains("Reached error page") || e.toString().contains("ERR_NAME_NOT_RESOLVED")
                    || e.toString().contains("Malformed URL")) {
                System.out.println("exception handled");
            } else {
                throw e;
            }
        }
    }

    @DataProvider(name = "test data")
    public Object[][] dataProviderfunc(){
        return new Object[][] { {"http://d3j8nuwp74eyml.cloudfront.net/5U5PU/S2xbn"},
                {"https://d3j8nuwp74eyml.cloudfront.net/5U5PU/S2xbn"},
                {"   https://d3j8nuwp74eyml.cloudfront.net/5U5PU/S2xbn"},
                {"https://d3j8nuwp74eyml.cloudfront.net/5U5PU/S2xbn   "},
                {"https://d3j8nuwp74eyml.com/5U5PU/S2xbn"},
                {"https://d3j8nuwp74eyml.cloudfront.net"},
                {"https:// d3j8nuwp74eyml. cloudfront. net /5U5PU/ S2xbn"},
                {"https://d3j8nuwp74eyml.com/5U5PU/S2xbn"},
                {"https://d3j8nuwp74eyml.in/5U5PU/S2xbn"},
                {"https://d3j8nuwp74eyml.org/5U5PU/S2xbn"},
                {"https://d3j8nuwp74eyml.com"},
                {"https://d3j8nuwp74eyml/5U5PU/S2xbn"},
                {"https://.cloudfront.net/5U5PU/S2xbn"}};

    }

}

