package test.WarmUpTest.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*1.Open Chrome browser.
    2.Go to http://practice.cybertekschool.com/forgot_password.
    3.Enter any email into input box.
    4.Click on Retrieve password.
    5.Verify URL contains: Expected: “email_sent”.
    6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!”*/
//TC#3
public class PracticeCybertek_ForgotPasswordURLverification {

    public static void main(String[] args)throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().fullscreen();

        driver.get(" http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(3000);
        driver.findElement(By.name("email")).sendKeys("master@cybertek.com");

        Thread.sleep(3000);
        driver.findElement(By.id("form_submit")).click();

       // Thread.sleep(3000);
       // driver.close();

       String currentUle=driver.getCurrentUrl();
       String expectedUrl="email_sent";
       if(currentUle.contains(expectedUrl)){
           System.out.println("URL Passed");
       }else {
           System.out.println("URL Failed");
       }

       String currentText=driver.findElement(By.name("confirmation_message")).getText();
       String exceptedText="Your e-mail's been sent!";
       if(currentText.contains(exceptedText)){
           System.out.println("Content verification passed");
       }else {
           System.out.println("Content verification failed");
       }


    }
}
