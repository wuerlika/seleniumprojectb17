package test.practice.day5;

import Utilities.WebDriverFactory;
import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_5SelectingValueFromNon_SelectDropdow {

    /*
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown
    3.Click to non-select dropdown
    4.Select Facebook from dropdown
    5.Verify title is “Facebook -Log In or Sign Up
     */

    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void TearDown()throws InterruptedException{
       Thread.sleep(2000);
       driver.quit();
    }

    @Test
    public void SelectFaceBookOption(){


        WebElement webSiteDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a"));
        webSiteDropdown.click();

        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebookLink.click();

        String expectedFacebookTitle = "Facebook - Log In or Sign Up";
        //String getting the actual title
        String  actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedFacebookTitle);





    }
}
