package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice2 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://www.cyberteckschool.com");

        String currentUrl = driver.getCurrentUrl();
        System.out.println("driver.getCurrentUrl(); " + driver.getCurrentUrl());


        String actualTitle=driver.getTitle();
        String expectedTtle="cybertek";

        if (actualTitle.equalsIgnoreCase(expectedTtle)){
            System.out.println("cybertek title veritication Passed");
        }else {
            System.out.println("cybertek title veritication failed");
        }
    }
}
