package test.practice.day7;

import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC10_SmartBear_edit_order {
/*
TC #10: SmartBear edit order
1.Open browser and login to SmartBear
2.Click to edit button from the right for “Steve Johns”
3.Change name to “Michael Jordan”
4.Click Update
5.Assert “Michael Jordan” is in the list
 */
   WebDriver driver;
   //step1->
   @BeforeMethod
    public void SetUpDriver(){
       driver= WebDriverFactory.getDriver("chrome");
       driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
       SmartBearUtilities.login(driver);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   }

   @AfterMethod
   public void TearDown()throws InterruptedException{
       Thread.sleep(2000);
       driver.quit();
    }

   @Test

    //Step2->
    public void editSteveJohns(){
       WebElement StevenJohns=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[4]/td[13]"));
       StevenJohns.click();
    //step3->
     WebElement changeName= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
     changeName.clear();
     changeName.sendKeys("Michael Jordan");
     driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']")).click();

     //Step4->
       List<WebElement> nameList=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
       for(WebElement eachName: nameList){
           if(eachName.getText().equals("Michael Jordan")){
           Assert.assertTrue(eachName.getText().equals("Michael Jordan"));
       }}

       }

       @Test
       public void RemoveNameMethod(){
        SmartBearUtilities.removeName(driver,"Steve Johns");
        List<WebElement> nameList=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));

        for(WebElement each:nameList){
            if(each.getText().equals("Steve Johns")){
                Assert.fail();
                return;
            }else {
                Assert.assertTrue(true);
            }
        }

       }
}

