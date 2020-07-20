package test.WarmUpTest.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
1.Open Chrome browser.
2.Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3.Verify “Check	All”button text	is “Check All”.
4.Click	to “Check All” button5.Verify all check	boxes are checked.
6.Verify button	text changed to"Un checked all".
 */
public class P06_SeleniumEasy_CheckboxVerification_ection2 {
    public static void main(String[] args) throws InterruptedException{


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");



        WebElement checkAll= driver.findElement(By.xpath("//input[@value='Check All']"));
        checkAll.click();

        Thread.sleep(3000);
        WebElement UncheckAll=driver.findElement(By.xpath("//input[@value='Uncheck All']"));
        if(checkAll.isDisplayed()){
            System.out.println("Check all verification is PASSED!");
        }else {
            System.out.println("Check all verification is FAILED!");
        }

        if (UncheckAll.isDisplayed()){
            System.out.println("Passed!");
        }else {
            System.out.println("failed!");
        }
        }


    }


