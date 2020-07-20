package test.practice.day10;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC31_Vytrack_wrongUserName_negativeTest {

/*
1. Go to https://qa2.vytrack.com
2. Enter incorrectusername
3. Enter correctpassword
4. Verify error message text is as expectedExpected:
“Invalid user name or password.”
Note: Follow Page Object Model design pattern
 */

    @Test
    public void UserName_NegativeTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        TC30_login_page login=new TC30_login_page();

        login.usernameInput.sendKeys("ghkgkhk");
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(login.passwordInput));
        login.passwordInput.sendKeys("UserUser123");
        login.loginButton.click();

        Assert.assertTrue(login.errorMessage.isDisplayed());

        String expectedText="Invalid user name or password.";
        String actualText=login.errorMessage.getText();
        Assert.assertEquals(actualText,expectedText);
    }


}
