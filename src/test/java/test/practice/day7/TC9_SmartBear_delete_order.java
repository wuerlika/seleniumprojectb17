package test.practice.day7;

import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC9_SmartBear_delete_order {
/*
1.Open browser and login to SmartBear
2.Delete “Mark Smith” from the list
3.Assert it is deleted from the list
 */

    WebDriver driver;

    @BeforeTest
    //step1->
    public void SetUP(){
        driver= WebDriverFactory.getDriver("CHROME");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.login(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void TearDown()throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void DeletedMarkSmith()throws InterruptedException{
        //Step2->
       WebElement MarkSmith=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
       MarkSmith.click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//input[@value='Delete Selected']")).click();
       Thread.sleep(2000);

       //Step3->
        List<WebElement> Allname=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for(WebElement each:Allname){
           // if(each.getText().equalsIgnoreCase("Mark Smith")){
           Assert.assertFalse(each.getText().equals("Mark Smith"));
            }
        }




    }
















