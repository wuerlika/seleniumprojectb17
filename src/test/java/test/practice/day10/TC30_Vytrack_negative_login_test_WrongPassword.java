package test.practice.day10;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.loginPage;

import java.util.concurrent.TimeUnit;

public class TC30_Vytrack_negative_login_test_WrongPassword {

/*1. Go to https://qa2.vytrack.com
2. Enter correct username
3. Enter incorrectpassword
4. Verify error message text is as expectedExpected:
 “Invalid user name or password.”
 Note: Follow Page Object Model design pattern
 */
  @BeforeMethod
  public void tearDown()throws InterruptedException{
     // Thread.sleep(2000);
   //   Driver.getDriver().quit();
  }
  @Test
    public void WrongPassword_negativeTest(){
     Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
     Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     TC30_login_page login=new TC30_login_page();
     login.usernameInput.sendKeys("wuerlika");
     login.passwordInput.sendKeys("679yq");
     login.loginButton.click();

     login.errorMessage.getText();
     Assert.assertTrue(login.errorMessage.isDisplayed());



  }


}
