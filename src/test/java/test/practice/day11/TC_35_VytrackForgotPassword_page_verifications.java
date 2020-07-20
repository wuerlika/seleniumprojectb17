package test.practice.day11;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.loginPage;

public class TC_35_VytrackForgotPassword_page_verifications {
  /*
  1. Go to https://qa3.vytrack.com
  2. Click to “Forgot your password?”link
  3. Verify title changed to expectedExpected: “Forgot Password”
  4. Verify url is as expected:Expected: “https://qa3.vytrack.com/user/reset-request”
     Note: Follow Page Object Model design pattern
   */

  loginPage loginPage;

  @AfterMethod
  public void tearDown(){

    Driver.getDriver().quit();
  }

  @Test
    //1->
    public void VytrackForgotPassword_page_verifications(){
     //2->
      Driver.getDriver().get("https://qa3.vytrack.com");
      Driver.getDriver().manage().window().maximize();
      WebElement forgetPasswor=Driver.getDriver().findElement(By.partialLinkText("Forgot your password?"));
      forgetPasswor.click();
      //3->
      String curealTitle=Driver.getDriver().getTitle();
      String expectedTitle="Forgot Password";
      Assert.assertEquals(curealTitle,expectedTitle);
     //4->
      String actualUrl=Driver.getDriver().getCurrentUrl();
      String exceptedUrl="https://qa3.vytrack.com/user/reset-request";
      Assert.assertEquals(actualUrl,exceptedUrl);




  }

    //TC35_Other way slution  Follow Page Object Model design pattern
    @Test
     public void Tc35_pattern(){
     Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url3"));

     loginPage=new loginPage();
     loginPage.forgetPasswordlink.click();

      String curealTitle=Driver.getDriver().getTitle();
      String expectedTitle="Forgot Password";
      Assert.assertEquals(curealTitle,expectedTitle);
      //4->
      String actualUrl=Driver.getDriver().getCurrentUrl();
      String exceptedUrl="https://qa3.vytrack.com/user/reset-request";
      Assert.assertEquals(actualUrl,exceptedUrl);

    }


}
