package test.day11_page_object_model;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.loginPage;

public class NegativeLoginTest {
   loginPage loginPage;

   @AfterMethod
   public void tearDown()throws InterruptedException{
       Thread.sleep(4000);
       Driver.getDriver().quit();
   }
    @Ignore
    @Test

  public void negative_login_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        WebElement usernameInput=Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput=Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement loginButton=Driver.getDriver().findElement(By.id("_submit"));

      String  username=ConfigurationReader.getProperty("storemanager_username");
      usernameInput.sendKeys(username);
      passwordInput.sendKeys("lkjzdhvalk");
      loginButton.click();

      WebElement errorMesage=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(errorMesage.isDisplayed(),"Assert message is Not displayed");

    }


    @Test
    public void negative_login_test_with_page_object(){
       Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
       Driver.getDriver().manage().window().maximize();
       loginPage loginpage=new loginPage();

       //sending username
        String username=ConfigurationReader.getProperty("storemanager_username");
        loginpage.usernameInput.sendKeys(username);


        //send our incorrect password


      // String password =ConfigurationReader.getProperty("storemanager_password");
        loginpage.passwordInput.sendKeys("dhjf");


        //click using our logipage object
        loginpage.loginButton.click();

        //asserting error message is disPlayed
        Assert.assertTrue(loginpage.errorMessage.isDisplayed());

        //asserting the text Value of the error message
        String actualyText=loginpage.errorMessage.getText();
        String exceptedText="Invalid user name or password.";

        Assert.assertEquals(actualyText,exceptedText);





    }

    @Test
    public  void tc31_wrong_username_test(){
       Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

      loginPage=new loginPage();
      String username="asnhajknfd";
      String password=ConfigurationReader.getProperty("storemanager_password");
      loginPage.login(username,password);

      //Asserting the text value of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText, expectedText);

    }

}
