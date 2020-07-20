package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PI_GoogleTitel {
    public static void main(String[] args)throws InterruptedException {

       //this line creates the connection between driver and selenium.
        //and set up the driver.
        WebDriverManager.chromedriver().setup();

       //creating instance of ChromeDriver  to able to do action on chromeBrowser
       WebDriver driver=new ChromeDriver();
        //to do use firefox driver  :WebDriver driver =new firefoxDriver();

        //maximize size of windows.
       driver.manage().window().maximize();
       //we get google.com
       driver.get("http://www.google.com");
        System.out.println("driver.getTitle()->"+driver.getTitle());
        System.out.println("diver.getCurrentUrl()->"+driver.getCurrentUrl());

       //Browser Navigation
        Thread.sleep(2000);
        //this line take user to the previous page
        driver.navigate().back();
        Thread.sleep(2000);//just able to se selenium movement
        driver.navigate().forward();

        Thread.sleep(2000);
        driver.navigate().refresh();//this line will refresh the page

        driver.navigate().to("https://facebook.com");
        System.out.println(driver.getTitle());//print out wep side title
       //diver.get("URL")vs driver.navigate().to("URL")
        //the both do exactly same thing.
        //driver.get("URl") will wait the page to be loaded before continuing
        //driver.navigate().to() does not wait the whole page loaded ,just continues .which some times
        //creates issues.
        System.out.println(driver.getCurrentUrl());//this get pages URL

        driver.getPageSource();//return page source of the current page that we want tobe.

        driver.manage().window().maximize();//the line below maximizes the browser page after opening it

        driver.close();//cloese the currently opened browser page
       // driver.guit() will close all of the opened
       String actualTitle= driver.getTitle();
       String expectedTitle="Google";

       if(actualTitle.equals(expectedTitle)){
           System.out.println("Google title verification Passed");
       }
       else {
           System.out.println("Google title verification is fail");
       }

    }


}
