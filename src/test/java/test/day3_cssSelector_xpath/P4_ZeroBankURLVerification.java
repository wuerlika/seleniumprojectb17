package test.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_ZeroBankURLVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement  forgotPassWordLink= driver.findElement(By.partialLinkText("Forgot"));
        String acualHrefValue =forgotPassWordLink.getAttribute("href");
        String expectedInHrefValue="/forgot-password.html";

        System.out.println("Actual Href Value ="+acualHrefValue);

        if(acualHrefValue.contains(expectedInHrefValue)){
            System.out.println("Href value verification Passed");
        }else {
            System.out.println("Href value verification Failed");
        }

        System.out.println("Is forgot password displayed?"+forgotPassWordLink.isDisplayed());//return true


        driver.quit();

    }




}
