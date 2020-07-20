package test.WarmUpTest.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: Practice Cybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser.
2. Go to http://practice.cybertekschool.com/forgot_password.
3. Locate all the WebElements on the page using XPATH locator only
 (total of 6)
 a. “Home” link
 b. “Forgot password” header
 c. “E-mail” text
 d. E-mail input box
 e. “Retrieve password” button
 f. “Powered byCybertek School” text .
 4. Verify all WebElements are displayed.
 */
public class TC1_Xpath_Practice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //a.home
        boolean isHomeDisplayed=driver.findElement(By.xpath("/html/body/nav/ul/li/a")).isDisplayed();

        if(isHomeDisplayed){
            System.out.println("Home link Verification is Passed!");
        }else{
            System.out.println("Home link Verification is Failed!");
        }


         //b."Forgot password"
        boolean isForgetPasswordDisplayed= driver.findElement(By.xpath("/html/body/div/div/div/div/h2")).isDisplayed();
        if(isForgetPasswordDisplayed){
            System.out.println("Forgot password verification is Passed!");
        }else {
            System.out.println("Forgot password  verification is Failed!");
        }

        //c.“E-mail” text

         boolean isEmailDisplayed=driver.findElement(By.xpath("//label[@for='email']")).isDisplayed();
        if(isEmailDisplayed){
            System.out.println("E-mail verification is Passed");
        }else {
            System.out.println("E-mail verification is Failed");
        }

        //d.E-mail input box
        boolean isEmailInPutBoxDisplayed=driver.findElement(By.xpath("//input[@type='text']")).isDisplayed();
        if (isEmailInPutBoxDisplayed){
            System.out.println("E-mail in put box verification is Passed!");
        }else {
            System.out.println("E-mail in put box verification is Failed");
        }

        //e.“Retrieve password” button
        boolean RetrievePassWordIsDisplayed=driver.findElement(By.xpath("//button[@id='form_submit']")).isDisplayed();
        if(RetrievePassWordIsDisplayed){
            System.out.println("Retrieve password button verification is Passed!");
        }else {
            System.out.println("Retrieve password button verification is Failed!");
        }

        //f.“Powered byCybertek School” text
        boolean PoweredDisplayed=driver.findElement(By.xpath("//div[@style='text-align: center;']")).isDisplayed();
        if(PoweredDisplayed){
            System.out.println("Powered  verification is Passed!");
        }else {
            System.out.println("Powered  verification is Failed!");
        }
        driver.quit();
    }
}
