package test.day7_javafaker_webtables;

import Utilities.SmartBearUtilities;
import Utilities.WebDriverFactory;
import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3 {
   /*
   1.Open browser and login to Smartbear software
   2.Click on View all orders
   3.Verify Susan McLaren has order on date “01/05/2010
    */
    WebDriver driver;
    @BeforeMethod
    public void SetUp(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);
}
    @Test
   public  void Susan(){
    WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

    String expectedDate = "01/05/2010";
    String actualDate = susansDate.getText();

        Assert.assertEquals(actualDate, expectedDate);

}}
