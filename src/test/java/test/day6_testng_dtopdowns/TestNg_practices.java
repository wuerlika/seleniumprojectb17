package test.day6_testng_dtopdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg_practices {

WebDriver driver;

    public void BeforeClass() {

        WebDriver driver = new ChromeDriver();
        driver.get("http//:www.google.com");
    }

    @BeforeMethod
    public void BeforeMethod(){

        System.out.println("BeforeMethod running");
    }

 @Test
    public void test1(){

        System.out.println("Test1 running ");
    }




   @Test
   public void test2(){
        System.out.println("Test2 running");
    }


    @Test
    public void Test3(){
        System.out.println("Test3 running");
        String actualTitle="Amazon prime";
        String expectedtITle="prime";
        Assert.assertTrue(actualTitle.contains(expectedtITle));
        //ig the boolean value we pass ing asserTrue in"true"  ,assertion will pass.
        //else it will fail ,
    }

    @AfterMethod
    public void AfterMetod(){
        System.out.println("AfterMethod running");

    }


    public  void AfterClass(){

    }


}
