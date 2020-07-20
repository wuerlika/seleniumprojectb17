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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_1and2 {
    /*
    TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
    1.Open Chrome browser.
    2.Go to http://practice.cybertekschool.com/dropdown.
    3.Verify “Simple dropdown” default selected value is correctExpected: “Please select an option”.
    4.Verify“State selection” default selected value is correctExpected: “Select a State"
     */
    //1,2->
    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown()throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    //3->
    @Test
    public void Verify() {
        Select SimpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        String actualDefualtOfSimpleDropdown = SimpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfSimpleDropdown = "Please select an option";
        Assert.assertEquals(actualDefualtOfSimpleDropdown, expectedDefaultOfSimpleDropdown);
    }


   //4->
   @Test
   public void Verify_StateSelection(){
        Select StateSelection=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualDefaultOfStateSelection=StateSelection.getFirstSelectedOption().getText();
        String exceptedDefaultOfStateSelection="Select a State";
        Assert.assertEquals(actualDefaultOfStateSelection,exceptedDefaultOfStateSelection);
   }

        /*
        TC #2: Selecting state from State dropdown and verifyingresult
        1.Open Chrome browser
        2.Go to http://practice.cybertekschool.com/dropdown
        3.Select Illinois
        4.Select Virginia
        5.Select California
        6.Verify final selected option is California.Use all Select options.(visible text, value, index)
        */


   @Test
   public void StateValue()throws InterruptedException{
       Select finalSelectedOption=new Select(driver.findElement(By.xpath("//select[@id='state']")));

       Thread.sleep(2000);
       finalSelectedOption.selectByValue("IL");

       Thread.sleep(2000);
       finalSelectedOption.selectByVisibleText("Virginia");

       Thread.sleep(2000);
       finalSelectedOption.selectByIndex(5);

       String actualSelectOption=finalSelectedOption.getFirstSelectedOption().getText();
       String exceptedOption="California";
       Assert.assertEquals(actualSelectOption,exceptedOption);

}
       /*
       TC #3: Selecting date on dropdown and verifying
       1.Open Chrome browser.
       2.Go to http://practice.cybertekschool.com/dropdown
       3.Select “December 1st, 1921” and verify it is selected.
       4.Select year using: visible textSelect ,month using : value attributeSelect ,day using: index number
       */

    //TC#3->
    @Test
    public void VerifySelectOption()throws InterruptedException{

        Select VerifySelectOptionYear=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Thread.sleep(2000);
        VerifySelectOptionYear.selectByVisibleText("1921");

        Select VerifySelectOptionMonth=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Thread.sleep(2000);
        VerifySelectOptionMonth.selectByValue("11");

        Select VerifySelectOptionDay=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        Thread.sleep(2000);
        VerifySelectOptionDay.selectByIndex(0);

        String actualSelectOptionYear=VerifySelectOptionYear.getFirstSelectedOption().getText();
        String exceptedYear="1921";

        String actualSelectOptionMonth=VerifySelectOptionMonth.getFirstSelectedOption().getText();
        String exceptedMonth="December";

        String actualSelectOptionDay=VerifySelectOptionDay.getFirstSelectedOption().getText();
        String exceptedDay="1";

        Assert.assertEquals(actualSelectOptionYear,exceptedYear);
        Assert.assertEquals(actualSelectOptionMonth,exceptedMonth);
        Assert.assertEquals(actualSelectOptionDay,exceptedDay);

    }

        /*
        TC #4: Selecting value from multiple select dropdown
        1.Open Chrome browser
        2.Go to http://practice.cybertekschool.com/dropdown
        3.Select all the options from multiple select dropdown.
        4.Print out all selected values.
        5.Deselect all values
        */

    @Test
    public void SelectAllOption(){
        Select AllOption=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        List<WebElement> list=AllOption.getAllSelectedOptions();
        for(WebElement each:list){
            System.out.println(each.getText());
        }
        AllOption.deselectAll();
    }

     /*
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown
    3.Click to non-select dropdown
    4.Select Facebook from dropdown
    5.Verify title is “Facebook -Log In or Sign Up
     */


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