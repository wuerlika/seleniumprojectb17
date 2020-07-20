package test.practice.day5;

import Utilities.WebDriverFactory;
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

public class CT_3_4 {
/*
TC #3: Selecting date on dropdown and verifying
1.Open Chrome browser.
2.Go to http://practice.cybertekschool.com/dropdown
3.Select “December 1st, 1921” and verify it is selected.
4.Select year using: visible textSelect ,month using : value attributeSelect ,day using: index number
 */

    //1,2->
    WebDriver driver;


    @BeforeMethod
    public void SetUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void TearDown()throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    //3->
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
    //4
    public void SelectAllOption(){
     Select AllOption=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        List<WebElement> list=AllOption.getAllSelectedOptions();
        for(WebElement each:list){
            System.out.println(each.getText());
        }
      AllOption.deselectAll();


    }

}
