package test.day7_javafaker_webtables;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectTask3 {

    WebDriver driver;

    @BeforeMethod
    public  void setUp(){
        //1.Open Chrome browser
        //2.Go to http://practice.cybertekschool.com/dropdown
        driver= WebDriverFactory.getDriver("Chrome");
        driver.get(" http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown()throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test_select_date(){
        Select yearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1921");
        String yearActual=yearDropdown.getFirstSelectedOption().getText();
        String exceptedYear="1921";

        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11");
        String monthActual= monthDropdown.getFirstSelectedOption().getText();
        String expectedMonth="December";

        Select dayDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);
        String dayActual=dayDropdown.getFirstSelectedOption().getText();
        String expectedDate="1";

        Assert.assertEquals(yearActual,exceptedYear);
        Assert.assertEquals(monthActual,expectedMonth);
        Assert.assertEquals(dayActual,expectedDate);


    }


}
