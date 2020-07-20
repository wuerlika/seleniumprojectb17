package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P_5SmartBear {
    public static void main(String[] args) {
       //basic login authentication
        //1-Open chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2-goto"http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3-verify title equal
        //expected :Web Orders login
        String actualTitle=driver.getTitle();
        String exceptedInTitel="Web Orders Login";
        if (actualTitle.equals(exceptedInTitel)){

            System.out.println("Home page title verification passed");
        }else {
            System.out.println("Home page title verification failed");
        }
       //4-enter username :Tester

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        //5-enter password
         driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");

         //6-click "Sing in "button
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
        //7-verify title
        if (driver.getTitle().equals("Web Orders")){
            System.out.println("Landing page title verificationb passed");
        }else {
            System.out.println("Landing page title verification failed");
        }
    }
}
