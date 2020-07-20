package test.practice.day6;

import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC6_CybertekRegistrationFormConfirmation {
    /*
    Note: Use JavaFaker when possible.
    1.Open browser
    2.Go to website: http://practice.cybertekschool.com/registration_form
    3.Enter first name
    4.Enter last name
    5.Enter username
    6.Enter email address
    7.Enter password
    8.Enter phone number
    9.Select a gender from radio buttons
    10.Enter date of birth
    11.Select Department/Office
    12.Select Job Title
    13.Select programming language from checkboxes
    14.Clickto sign up button
    15.Verify success message “You’ve successfully completed registration.”is displayed.
     */
   WebDriver driver;

   @BeforeMethod
    public void SetUp(){
       driver= WebDriverFactory.getDriver("Chrome");
       driver.get("http://practice.cybertekschool.com/registration_form");
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       driver.manage().window().maximize();
   }

  /* @AfterMethod
    public void TearDown()throws InterruptedException {
       Thread.sleep(4000);
       driver.close();
   }
*/
    @Test
    public void Test1()throws InterruptedException{

        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
        WebElement emailAddress=driver.findElement(By.xpath("//input[@name='email']"));
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        WebElement phoneNumber=driver.findElement(By.xpath("//input[@name='phone']"));
        WebElement dateOfBirth=driver.findElement(By.xpath("//input[@name='birthday']"));

        Faker faker= new Faker();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        userName.sendKeys(faker.name().username().replace(".",""));
        password.sendKeys(faker.internet().password());
        emailAddress.sendKeys(faker.internet().emailAddress());
        phoneNumber.sendKeys(faker.phoneNumber().phoneNumber().replace(".","-"));
        dateOfBirth.sendKeys("05/04/1982");

        driver.findElement(By.xpath("//input [@value='female']")).click();
        Thread.sleep(2000);
        Select DepartmentOffice=new Select(driver.findElement(By.xpath("//select[@name='department']")));
        DepartmentOffice.selectByVisibleText("Department of Engineering");
        Thread.sleep(2000);
        Select jobTitle=new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(3);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='java']")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String actual=driver.findElement(By.xpath("//div[@class='alert alert-success']/p")).getText();
        String expected="You've successfully completed registration!";
        Assert.assertEquals(actual,expected);











    }


}
