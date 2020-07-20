package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*
Task :
    - Write a static method in WebDriverFactory class
    - Return type is WebDriver
    - method name getDriver
    - it accepts one String argument, and returns the browser according to what string is passed
    - if "chrome" --> returns chrome browser
    - if "firefox" --> returns firefo browser

 */

public class WebDriverFactory {

public static WebDriver getDriver(String browserType){
    if(browserType.equalsIgnoreCase("Chrome")){
        WebDriverManager.chromedriver().setup();
        return  new ChromeDriver();
    }else if(browserType.equalsIgnoreCase("Firefox")){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
    else {
        System.out.println("Given browser type dose not exist .Driver =null!");
        return null;
    }
}

}
