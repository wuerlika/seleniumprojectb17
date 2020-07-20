package test.practice.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
/*
Task :
    - Write a static method in WebDriverFactory class
    - Return type is WebDriver
    - method name getDriver
    - it accepts one String argument, and returns the browser according to what string is passed
    - if "chrome" --> returns chrome browser
    - if "firefox" --> returns firefo browser

 */

  public static WebDriver getDriver(String str){
      if(str.equalsIgnoreCase("Chrome")){
          WebDriverManager.chromedriver().setup();
          return new ChromeDriver();

      }if(str.equalsIgnoreCase("firefox")){
          WebDriverManager.firefoxdriver().setup();
          return  new FirefoxDriver();

      }else {

          return  null;
      }

  }

}
