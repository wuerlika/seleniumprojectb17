package test.practice.day10;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.day7_javafaker_webtables.TC3;

public class TC32_Vytrack_positive_login_testSales_Manager {
  /*
  1. Go to https://qa2.vytrack.com
  2. Enter correct username
  3. Enter correct password
  4. Verify title changedExpected: “Dashboard”
     Note: Follow Page Object Model design pattern
   */




  @Test
    public void positive_loginTest(){
      Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
      TC30_login_page login=new TC30_login_page();
      login.usernameInput.sendKeys("salesmanager266");
      login.passwordInput.sendKeys("UserUser123");
      login.loginButton.click();

      String expectedTitle="Dashboard";
      String actualTile=Driver.getDriver().getTitle();
      Assert.assertEquals(actualTile,expectedTitle);


  }



}
