package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleTitleVerification {
    public static void main(String[] args) {
//Tc #4 :Google search
//1-open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

//2-go to :https://google.com
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

//3-write "apple " on search box
        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);

//4-Click google search button
//5-verify title:

        String actualTitle=driver.getTitle();
        String expectedInTitle="apple";
        if (actualTitle.startsWith(expectedInTitle)){
            System.out.println("Google search verification  title  passed");
        }else {
            System.out.println("Google search verification title  failed");
        }



    }


}
