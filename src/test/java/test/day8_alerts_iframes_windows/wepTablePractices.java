package test.day8_alerts_iframes_windows;

import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class wepTablePractices {

    WebDriver driver;

    @BeforeMethod
    public  void setUp() {
        //1.Open Chrome browser
        //2.Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

   @ Test
    public void p4_VerifyOder_test()throws InterruptedException{
        SmartBearUtilities.login(driver);
        SmartBearUtilities.verifyOder(driver,"Paul Brown");




           }

    @Test
    public void p5_printNameAndCities(){
        SmartBearUtilities.login(driver);
        SmartBearUtilities.printNamesAndCities(driver);
    }
       }







