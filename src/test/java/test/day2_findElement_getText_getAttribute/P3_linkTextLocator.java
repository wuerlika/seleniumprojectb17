package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_linkTextLocator {
    public static void main(String[] args) {


  // 1-open a chrome browser and go to google
  WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com");


   //2-click to gmail link from to right
   driver.findElement(By.linkText("Gmail")) .click();
   String actualGmailTitle=driver.getTitle();
   String exceptedInTitel="Gmail";

   if (actualGmailTitle.startsWith(exceptedInTitel)){
       System.out.println("gmail title verification passed");
   }else {
       System.out.println("gmail title verification failed");

   }

   //4-go back to google page by using back()
   driver.navigate().back();

   String acualTitle =driver.getTitle();
   String expectedTitle="Google";
   if(actualGmailTitle.equalsIgnoreCase(exceptedInTitel)){
       System.out.println("Google page title verification passed");
   }
    else {
       System.out.println("Google page title verification passed");
   }
}
}