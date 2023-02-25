package tests;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.Properties;

public class UrlTest extends BaseTest {
    HomePage home;

    @BeforeMethod
    public  void beforeMethod(){
        home = new HomePage(getDriver());
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
    public Object[][] dataProviderfunc() throws IOException, ParseException {
        Properties data = getProps();
        return new Object[][] { {data.getProperty("httpLink")},
                {data.getProperty("httpsLink")},
                {data.getProperty("UrlSpacesAtTheStart")},
                {data.getProperty("UrlSpacesAtTheEnd")},
                {data.getProperty("UrlSpacesInBetween")},
                {data.getProperty("extensionWithCom")},
                {data.getProperty("extensionWithIn")},
                {data.getProperty("extensionWithOrg")},
                {data.getProperty("extension.ComWithoutPathParameter")},
                {data.getProperty("withoutAnyExtension")},
                {data.getProperty("onlyExtension")},
                {data.getProperty("UrlWithSlash")},
                {data.getProperty("ValidUrlWithoutPathParameter")}};

    }

}

