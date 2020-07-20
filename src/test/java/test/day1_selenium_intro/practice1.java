package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com");
        System.out.println("get title->"+driver.getTitle());

       String actualTitle=driver.getTitle();
       String expectedTitle="Google";

       if(actualTitle.equals(expectedTitle)){
           System.out.println("Google title veritication Passed");
       }else {
           System.out.println("Google title verification FAILED");
       }

    }
}
