package test.practice.day11;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;

public class TC36_Vytrack_forgot_password_page_verification {
    /*
    1.Go to https://qa2.vytrack.com/user/reset-request
    2.Enter random username
    3. Click to request button
    4. Verifyerror message is displayed
    5. Verify error message text is as expected.Expected:
        There is no active user with username or email address “given text”.
        .Note: Follow Page Object Model design patter
     */

    loginPage loginPage;

    @Test
    public  void forgetPasswordErrorMessageVerification(){
        Driver.getDriver().get("https://qa2.vytrack.com/user/reset-request");
        loginPage=new loginPage();
        loginPage.usernameInput.sendKeys("dghlbl");
        loginPage.requestButton.click();
        String randomString="dghlbl";
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        String expectedText="There is no active user with username or email address \""+randomString+"\".";
       String actualText=loginPage.errorMessage.getText();
       Assert.assertEquals(actualText,expectedText);



    }


}
