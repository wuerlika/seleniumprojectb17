package test.day5_testNg_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNgClass {



@BeforeMethod
public void setUp(){
    System.out.println("Before method running");

}
@AfterMethod
public  void  tearDown(){
    System.out.println("after method running");
}

  @Test
public  void  test1(){
      System.out.println("Test one is running...");
}
@Test
public void test2(){
    System.out.println("Test second is running...");
}


}
