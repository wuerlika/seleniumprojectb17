package test.day9_testBase_properties_driverUtil;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DriverUtilityPractice {

@Test

    public void driver_practice(){
    Driver.getDriver().get("https://www.google.com");
                     
    WebElement googleSearch=Driver.getDriver().findElement(By.name("q"));
    googleSearch.sendKeys(ConfigurationReader.getProperty("testdata")+ Keys.ENTER);
}




}
