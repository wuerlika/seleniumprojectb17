package test.day6_testng_dtopdowns;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/dropdown
3.Verify “Simple dropdown” default selected value is correctExpected: “Please select an option”.
4.Verify“State selection” default selected value is correctExpected: “Select a Stat
 */
public class Dropdown_Intro {

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
        driver.close();
}


    @Test
    public  void test1_default_value_verification(){

      //3.Verify “Simple dropdown” default selected value is correctExpected: “Please select an option”.
        Select simpleDropDown=new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        String actualDefaultOfSimpleDropdown=simpleDropDown.getFirstSelectedOption().getText();
        String expectedDefaultOfSimpleDropdown="Please select an option";
        Assert.assertEquals(actualDefaultOfSimpleDropdown,expectedDefaultOfSimpleDropdown);

       //4.Verify“State selection” default selected value is correctExpected: “Select a Stat
        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualDefaultOfStateDropdown=stateDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfStateDropdown="Select a Stat";

        Assert.assertEquals(actualDefaultOfSimpleDropdown,expectedDefaultOfSimpleDropdown);

    }


    /*
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown
    3.Select Illinois
    4.Select Virginia
    5.Select California
    6.Verify final selected option is California.Use all Select options.
    (visible text, value, index)
     */

   @Test
   public  void    teat2_state_value_verificatuon()throws InterruptedException{
       //1-2->
       Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
       //3->
       //Select by using  .selectByValue(); method ->Expected the attribute value of "value" attribute
       Thread.sleep(1000);
       stateDropdown.selectByValue("IL");

       //4-> Selecting using select byVisibleText(); method->expected
       Thread.sleep(1000);
       stateDropdown.selectByVisibleText("Virginia");

       //5->
       Thread.sleep(1000);
       stateDropdown.deselectByIndex(5);

       //6->
       String expectedOption="California";
       String actualSelectedOption = stateDropdown.getFirstSelectedOption().getText();

       Assert.assertEquals(actualSelectedOption,expectedOption);
      // Assert.assertTrue(expectedOption, actualSelectedOption);

   }




}
