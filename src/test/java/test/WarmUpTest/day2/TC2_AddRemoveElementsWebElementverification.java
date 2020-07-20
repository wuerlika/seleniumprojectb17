package test.WarmUpTest.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1.. Open Chrome browser.
2. Go to http://practice.cybertekschool.com/add_remove_elements.
3. Click to “Add Element” button.
 4. Verify “Delete” button is displayed after clicking.
 5. Click to “Delete” button.
 6. Verify “Delete” button is NOT displayed after clicking.
  USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */
public class TC2_AddRemoveElementsWebElementverification {
    public static void main(String[] args)throws InterruptedException {
       //1.
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //2.
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //3.
        Thread.sleep(3000);
        WebElement addElementButton =driver.findElement(By.xpath("//button[@onclick='addElement()']"));
           addElementButton.click();

        //4.w
        WebElement DeleteButtonDisplayed=driver.findElement(By.xpath("//button[@class='added-manually']"));

        if(DeleteButtonDisplayed.isDisplayed()){
            System.out.println("Delete button verification is Passed!");
        }else {
            System.out.println("Delete button verification is Failed!");
        }

        //5.
          Thread.sleep(3000);
           DeleteButtonDisplayed.click();

        //6.
         WebElement deleteNotDisplayed= driver.findElement(By.xpath("//div[@id='elements']"));

        if(deleteNotDisplayed.isDisplayed()){
            System.out.println("Delete Button is not displayed");
        }else{
            System.out.println("Delete Button is displayed");
        }

        driver.quit();

    }


}
