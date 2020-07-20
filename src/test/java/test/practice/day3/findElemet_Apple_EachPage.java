package test.practice.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.lang.reflect.Array;
import java.util.List;

public class findElemet_Apple_EachPage {
    public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();
           WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.apple.com");

            List<String> links=new ArrayList<String>();
            links.add(".ac-gn-link-mac");
            links.add(".ac-gn-link-ipad");
            links.add(".ac-gn-link-iphone");
            links.add(".ac-gn-link-watch");
            links.add(".ac-gn-link-tv");
            links.add(".ac-gn-link-music");
            links.add(".ac-gn-link-support");
            for (String eachLink:links) {
                driver.findElement(By.cssSelector(eachLink)).click();
                System.out.println(driver.getTitle());

                List<WebElement> listOfLinks=driver.findElements(By.xpath("//body//a"));
                int linksWithoutText=0;
                int linksWithText=0;
                for (WebElement eachLink1: listOfLinks) {
                    String textOfEachLink=" ";
                    if (textOfEachLink.isEmpty()){
                        linksWithoutText++;
                    }else{
                        System.out.println(textOfEachLink);
                        linksWithText++;
                    }
                }
                System.out.println("Total links on this page: "+listOfLinks.size());
                System.out.println("Links without text: "+linksWithoutText);
                System.out.println("Links with text: " +linksWithText);
                System.out.println("********************************************");
            }

        }
    }


