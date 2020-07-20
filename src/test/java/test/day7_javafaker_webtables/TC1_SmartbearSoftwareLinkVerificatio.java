package test.day7_javafaker_webtables;

import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC1_SmartbearSoftwareLinkVerificatio {

/*
1.Open browser.
2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3.Enter username: “Tester”.
4.Enter password: “test”.
5.Click to Login button.
6.Print out count of all the links on landing page.
7.Print out each link text on this page
 */
     WebDriver driver;


    @BeforeMethod
     public void SetUp(){
     driver= WebDriverFactory.getDriver("chrome") ;
     driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      SmartBearUtilities.login(driver);
   //   SmartBearUtilities.verifyOrder(driver,"Susan McLaren");
   //   SmartBearUtilities.printNamesAndCities(driver);
    }


    //3->



    @Test
    public void p1_smartbear_login_test(){
         //6->
        List<WebElement> allLinks=driver.findElements(By.xpath("//body//a"));
        System.out.println("Number of the links"+allLinks);

        //7->
        int expectedNumberOfLink=6;
        int actualNumberOfLink=allLinks.size();

        Assert.assertEquals(actualNumberOfLink,6);

        for (WebElement link:allLinks){
            System.out.println(link.getText());
        }
     }
      /*
     C#2: Smartbear software order placing
     (1-5 down by 1test)
     6. Click on Order
     7. Select familyAlbum from product, set quantity to 2
     8. Click to "Calculate" button
     9. Fill address Info with JavaFaker
     • Generate: name, street, city, state, zip code
     10. Click on "visa" radio button
     11. Generate card number using JavaFaker
     12. Click on "Process"
     13.Verify success message "New order has been successfully added."
      */

    @Test
     public void p2_smartbear_oder_placing()throws InterruptedException{
      //6->Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

        //quantityInput.clear(); //just deletes if there is any existing input in the input box.
        Thread.sleep(1000);

        //Imitating as if the user is pressing the BACKSPACE key on keyboard to delete something.
        quantityInput.sendKeys(Keys.BACK_SPACE);

        Thread.sleep(1000);
        quantityInput.sendKeys("2");

        //8. Click to “Calculate” button
        WebElement calculateButton=driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker//• Generate: name, street, city, state, zip code
        WebElement inputCustomerName=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement inputStreetName=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement inputCityName=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement inputStateName=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement inputZipCode=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        Faker faker=new Faker();
        inputCustomerName.sendKeys(faker.name().fullName());

        inputStreetName.sendKeys(faker.address().streetAddress());

        inputCityName.sendKeys(faker.address().cityName());

        inputStateName.sendKeys(faker.address().state());

        inputZipCode.sendKeys(faker.address().zipCode().replace("-",""));

        //10. Click on “visa” radio button
        WebElement VisaRadioButton=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        VisaRadioButton.click();

       //11. Generate card number using JavaFaker
        WebElement VisaCardNumberInput=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        VisaCardNumberInput.sendKeys(faker.finance().creditCard().replace("-",""));

        WebElement expirationDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("12/25");

        //12. Click on “Process”
        WebElement ProcessButton=driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        ProcessButton.click();

        //13.Verify success message “New order has been successfully added.”
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));

        Assert.assertTrue(successMessage.isDisplayed());


    }


     }
