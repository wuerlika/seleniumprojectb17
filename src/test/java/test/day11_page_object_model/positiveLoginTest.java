package test.day11_page_object_model;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.loginPage;

public class positiveLoginTest {
    loginPage login;



    @AfterMethod
    public void tearDown()throws InterruptedException{
        Thread.sleep(3000);
        Driver.getDriver().quit();
    }

    @Test
    public void Store_manager_login_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        login=new loginPage();
        String username=ConfigurationReader.getProperty("storemanager_username");
        String password=ConfigurationReader.getProperty("storemanager_password");

        login.login(username,password);//here we don't need to do login.loginButton.click   becuse in login method its already
        //incloud loginButton


        //title verification
        String expectedTitele="Dashboard";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitele);




    }


}
