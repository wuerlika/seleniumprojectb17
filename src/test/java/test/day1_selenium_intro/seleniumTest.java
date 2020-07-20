package test.day1_selenium_intro;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {
    public static void main(String[] args)throws    InterruptedException {
        WebDriverManager.chromedriver().setup();

     WebDriver driver=new ChromeDriver();

     driver.get("https://www.google.com");

     Thread.sleep(2000);
     driver.navigate().back();//this line will go to next page

       Thread.sleep(2000);
       driver.navigate().forward();


        Thread.sleep(2000);
        driver.navigate().refresh();//this line will refresh the page

        driver.navigate().to("https://facebook.com");

        System.out.println(driver.getTitle());

        System.out.println( driver.getCurrentUrl());

        driver.close();




    }
}
