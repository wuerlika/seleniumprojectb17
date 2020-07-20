package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.WeakHashMap;

public class p3_CybertekURLVerification {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(3000);
       WebElement emailInput= driver.findElement(By.name("email"));

       emailInput.sendKeys("wuerlika@gimail.com");

        Thread.sleep(3000);
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();



        String actualUrl = driver.getCurrentUrl();
        String expectedInUrl = "email_sent";
        System.out.println("The current Url ->"+actualUrl);

        if(actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification Passed");
        }else {
            System.out.println("URL verification Failed");
        }


        WebElement confirmationMessage=driver.findElement(By.name("confirmation_message"));
         String actualMessageText= confirmationMessage.getText();
         String exceptedMessageText="Your e-mail's been sent!";

         if(actualMessageText.equals(exceptedMessageText)){
             System.out.println("Confirmation message text verification Passed");
         }else {
             System.out.println("Confirmation message text verification Failed");
         }


         if (confirmationMessage.isDisplayed()){
             System.out.println("Message is displayed, verification PASSED!");
         }else{
             System.out.println("Message is NOT displayed, verification FAILED!");
         }
      Thread.sleep(3000);
      driver.quit();

    }






}
