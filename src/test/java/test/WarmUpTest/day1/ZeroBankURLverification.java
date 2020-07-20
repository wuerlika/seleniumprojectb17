package test.WarmUpTest.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
       1.Open Chrome browser.
       2.Go to http://zero.webappsecurity.com/login.html.
       3.Get attribute value of href from the “forgot your password”link.
       4.Verify attribute value containsExpected: “/forgot-password.html”
        */
//TC#4
public class ZeroBankURLverification {

    public static void main(String[] args)throws  InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get(" http://zero.webappsecurity.com/login.html");
        Thread.sleep(3000);
       String currantResult= driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
       String expectedResult="/forgot-password.html";

       if(currantResult.contains(expectedResult)){
           System.out.println("Zero bank URL verification Pssed");
       }else {
           System.out.println("Zero bank URL verification Failed");


    }
}}
