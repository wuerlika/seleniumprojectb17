package test.WarmUpTest.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1.Open Chrome browser.
2.Go to http://zero.webappsecurity.com/login.html.
3.Enter username: username.
4.Enter password: password.
5.Click sign in button.
6.Verify username is displayed on the page.
7.Verify the title Zero –Account Summary.
8.Verify the link Account Summary’s href value contains:
 “account-summary”Print out results in validation formats
 */
//#5
public class BasicAuthenticationZeroBank {
    public static void main(String[] args)throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");

        Thread.sleep(3000);
        driver.findElement(By.name("user_login")).sendKeys("username");

        Thread.sleep(3000);
        driver.findElement(By.name("user_password")).sendKeys("password");

        Thread.sleep(3000);
        driver.findElement(By.name("submit")).click();

        if(driver.findElement(By.linkText("username")).getText().equals("username")){
            System.out.println("User name passed");
        }else {
            System.out.println("User name Failed ");
    }

        if(driver.getTitle().equals("Zero - Account Summary")){
            System.out.println("Zero bank title verification Passed");
        }else{
            System.out.println("Zero bank title verification Failed");
        }

     if(driver.findElement(By.linkText("Account Summary")).getAttribute("href") .contains("account-summary")) {
         System.out.println("Value Passed");
     }else {
         System.out.println("Value Failed");
     }
}}
