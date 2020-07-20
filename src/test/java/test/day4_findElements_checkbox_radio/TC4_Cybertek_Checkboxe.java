package test.day4_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1.Goto http://practice.cybertekschool.com/checkboxes
2.Confirm checkbox #1 is NOT selected by default
3.Confirm checkbox #2 is SELECTED by default.
4.Click	checkbox #1	to select it.
5.Click	checkbox #2	to deselect	it.
6.Confirm checkbox #1 is SELECTED.
7.Confirm	checkbox	#2	is	NOT
 */
public class TC4_Cybertek_Checkboxe {
    public static void main(String[] args)throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        if(!checkBox1.isSelected()){
            System.out.println("Check box 1 is not selected.verification Passed!");
        }else {
            System.out.println("Check box 1 is not selected.verification Failed");
        }

        //3.confirm check box 2 is selected by default

        WebElement checkBox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //4.
        checkBox1.click();
        Thread.sleep(3000);

        //5.
        checkBox2.click();
        Thread.sleep(3000);

        //6.
        if(checkBox2.isSelected()){
            System.out.println("Check box 2 is selected by default.verification is Passed!");
        }else
        {
            System.out.println("Check box 2 is selected by default.verification is Failed!");
        }

        driver.quit();

    }


}
