package test.day12_synchronization;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.ForgetPasswordPage;
import pages.loginPage;

public class ForgotPasswordTest {

 /* 1. Go to https://qa3.vytrack.com
            2. Click to "Forgot your password?" link
3. Verify title changed to expected
    Expected: "Forgot Password"
            4. Verify url is as expected:
    Expected: "https://qa3.vytrack.com/user/reset-request"
    Note: Follow Page Object Model design pattern
 */


 @Ignore
@AfterMethod
    public void tearDown()throws InterruptedException{
    Thread.sleep(4000);
    Driver.getDriver().quit();
}
@Test
    public void tc35_title_url_verification() {
    Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
    loginPage loginpage = new loginPage();
    loginpage.forgetPasswordlink.click();

    //verifying title as expected
    String expectedTitle = "Forgot Password";
    String actualTitle = Driver.getDriver().getTitle();

    Assert.assertEquals(actualTitle, expectedTitle);

    //verifying the url is as expected
    String expectedUrl = Driver.getDriver().getCurrentUrl();
    String actualUrl = "https://qa2.vytrack.com/user/reset-request";

    Assert.assertEquals(actualUrl, expectedUrl);

}





    @Test
     public void tc36_error_message_verification(){
    Driver.getDriver().get(ConfigurationReader.getProperty("forgotpassword_url"));
    ForgetPasswordPage forgetPasswordPage=new ForgetPasswordPage();
    //send random string
    String randomString="fhjgk";
    forgetPasswordPage.inputBox.sendKeys(randomString);

    //clicking to request button
    forgetPasswordPage.requestButton.click();

    //verify error message is displayed
    Assert.assertTrue(forgetPasswordPage.errorMessage.isDisplayed());

    //verify error message text value is expected and contains random strin
     String expectedText="There is no active user with username or email address \""+randomString+"\".";
     String actualText=forgetPasswordPage.errorMessage.getText();

     Assert.assertEquals(actualText,expectedText);



}

}
