package test.practice.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args)throws Throwable {
       //set up wep driver
        WebDriverManager.chromedriver().setup();

        //create an object of chrome driver browser
        WebDriver driver=new ChromeDriver();

        //open browser ,get url
        String url="https://google.com";
        String url2="https://www.amazon.com";
        driver.get(url);
        // other way ->driver.get("https://google.com");

        //open full screen
        driver.manage().window().fullscreen();


       //Sleep 3 second then open second page amazon
        Thread.sleep(3000);

        //open second page on same browser
        driver.navigate().to(url2);

        //Sleep 3 second ,back to previous URL
        Thread.sleep(3000);

        //will navigate back to the previous URL
        driver.navigate().back();//google

        //Sleep 3 second the back to orginal page
        Thread.sleep(3000);

        //back to the orginal page // amazon
        driver.navigate().forward();

        //Sleep 3 second refresh wap page
        Thread.sleep(3000);

        // refresh page amazon
        driver.navigate().refresh();

        //Sleep 3 second then  close page
        Thread.sleep(3000);

        //close web browser
     //   driver.close();

        //close ityer browser
        driver.quit();




    }



}
