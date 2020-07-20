package test.day6_testng_dtopdowns;

import Utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNg_Practice {




    WebDriver driver;

    @BeforeMethod

    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");

    }


    @AfterMethod
    public void tearDown()throws InterruptedException{

            Thread.sleep(2000);
            driver.close();
    }

    @Test
    public void google_title_test(){
            String expectedTitle="Google";
            String actualTitle=driver.getTitle();
            //the line were we do assertion
           // if you use assertTrue,argument you are passing is supposed to be returning boolean.
        Assert.assertTrue(actualTitle.equals(expectedTitle));
          // if you are using assertEquals ,you need to pass two argument of the same type
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void google_search_title_verification(){
            //open browser
           //go to http://gooogle.com
           // search "apple"
           //locating the google search box
        //WebElement appleSearchBox=
    }


}