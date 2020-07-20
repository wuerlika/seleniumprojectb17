package test.practice.day8;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.util.Set;

public class WindowHandleWarmup extends TestBase {
/*
TC-WarmUp# : Window Handlepractice
1.Create a new class called:
WindowHandleWarmup
2.Create new test and make set ups
3.Go to : https://www.amazon.com
4.Copy paste the lines from below into your class
5.Create a logic to switch to the tab where Etsy.com is open
6.Assert: Title contains “Etsy”Lines to be pasted:
((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
These lines will simple open new tabsusing something called JavaScriptExecutand get those pages.
We will learn JavaScriptExecutor later as well.



WebDriver driver;
@BeforeMethod
//Step1->
    public void SetUpDriver() {
    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}
@AfterMethod
   public void TearDown()throws InterruptedException{
   // Thread.sleep(3000);
   // driver.quit();
}
*/

 @Test
 //Step 3,4->
    public void test()throws InterruptedException{



    driver.get("https://www.amazon.com");




     ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
     Thread.sleep(2000);

     ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
     Thread.sleep(2000);

     ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
     Thread.sleep(2000);

     //step5->
     Set<String> windowHandles=driver.getWindowHandles();
     for (String each:windowHandles){
         driver.switchTo().window(each);
         System.out.println("current title:"+driver.getTitle());
         if(driver.getCurrentUrl().contains("etsy")){

     //step6->
         Assert.assertTrue(driver.getTitle().contains("Etsy"));
             break;
         }
     }
}


}
