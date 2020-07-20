package test.practice.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class get_title {
    public static void main(String[] args) {
        //set up chrome driver
        WebDriverManager.chromedriver().setup();
        //create object of Chrome class driver
        WebDriver driver = new ChromeDriver();
        //open chrome
        driver.get("http://www.google.com");
        //get title
        String Title = driver.getTitle();
        System.out.println(Title);//Google
    }
}