package test.day4_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TC02_FINDELEMENTS_APPLE {
/*
1.Open Chrome browser.
2.Go to https://www.apple.com
3.Click to iPhone.
4.Print out the texts of all links.
5.Print out how many link is missing text.
6.Print out how many link has text.
7.Print out how many total link
 */

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.apple.com");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']")).click();


        List<WebElement> listOfLinks=driver.findElements(By.xpath("//body//a"));

        int linksWithoutText = 0;
        int linksWithText = 0;

        for(WebElement eachLink:listOfLinks){
            System.out.println(eachLink.getText());

           if(eachLink.getText().isEmpty()) {
               linksWithoutText++;
           }else {
               linksWithText++;
           }}

            driver.quit();

            System.out.println("Link with text :"+linksWithText);
            System.out.println("Link with out text:"+linksWithoutText);
            System.out.println("Total link is :"+listOfLinks.size());

    }

}
