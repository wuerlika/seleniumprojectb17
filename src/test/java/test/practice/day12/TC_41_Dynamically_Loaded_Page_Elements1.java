package test.practice.day12;

import Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1page;

public class TC_41_Dynamically_Loaded_Page_Elements1 {
/*
1.Go to http://practice.cybertekschool.com/dynamic_loading/1
2.Click to start
3.Wait until loading bar disappears
4.Assert username inputboxis displayed
5.Enter username: tomsmith
6.Enter password: incorrectpassword
7.Click to Submit button
8.Assert “Your username is invalid!” text is displayed
 */

   @Test
    public void Dynamic_loaded_Page_element_test(){
       Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
       Loading1page loading1page=new Loading1page();
       loading1page.starButton.click();
       WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
       wait.until(ExpectedConditions.invisibilityOf(loading1page.loadingBar));

       Assert.assertTrue(loading1page.usernameInput.isDisplayed());
       loading1page.usernameInput.sendKeys("tomsmith");
       loading1page.passwordInput.sendKeys("fgjgkgk");
       loading1page.submitButton.click();

       Assert.assertTrue(loading1page.errorMessage.isDisplayed());



   }



}
