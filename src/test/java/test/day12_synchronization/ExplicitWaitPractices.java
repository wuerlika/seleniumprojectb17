package test.day12_synchronization;

import Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1page;

public class ExplicitWaitPractices {

/*
TC#40: Dynamically Loaded Page Elements 7
1.Go to http://practice.cybertekschool.com/dynamic_loading/7
2.Wait until title is “Dynamic Title”
3.Assert : Message “Done” is displayed.
4.Assert : Image is displayed.
 */


//WE CREATE @FindBy in Loading7Page class to use it

    @Test
    public void tc40_Dynamically_title_test() {
        String url = "http://practice.cybertekschool.com/dynamic_loading/7";
        Driver.getDriver().get(url);

        Loading7Page loading7Page = new Loading7Page();

        //creating the instance of wendriverwait to use it method
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        String expectedTitle = "Dynamic title";

        //we are using object to set up our Expected condition
        wait.until(ExpectedConditions.titleIs(expectedTitle));

        //done message is displayed
        Assert.assertTrue(loading7Page.downMessage.isDisplayed());

        //image is displayed
        Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());


    }


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
    public void tc41_dynamic_form_test() {
        //1-2>
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        Loading1page loading1page = new Loading1page();
        loading1page.starButton.click();
       //3->
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.invisibilityOf(loading1page.loadingBar));

        //4->
        Assert.assertTrue(loading1page.usernameInput.isDisplayed(),"Username input box is not displayed");
       //5-6->
        loading1page.usernameInput.sendKeys("tomsmith");
        loading1page.passwordInput.sendKeys("sryful");
        //7->
        loading1page.submitButton.click();

        //8->
        Assert.assertTrue(loading1page.errorMessage.isDisplayed());

    }
}