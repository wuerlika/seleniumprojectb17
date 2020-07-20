package test.day8_alerts_iframes_windows;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC7_CybertekMonthDropdownDefaultValue {
    /*
    TC#7: Cybertek “month”dropdown default value
    1.Open browser2.Go to website: http://practice.cybertekschool.com/dropdown
    3.Verify default value is always showing the current month Expected:
     If currently in June, should show June selected
     */
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        //1.Open Chrome browser
        //2.Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void p7_monthDropdownDefaultValueTest(){
        Select monthDropdown= new Select(driver.findElement(By.xpath("//select[@id='month']")));
        String actualDropdown=monthDropdown.getFirstSelectedOption().getText();
        String expectedDropdown= LocalDateTime.now().getMonth().name();

        System.out.println("expect Dropdown="+expectedDropdown);

        //1- First way of doing this assertion
        Assert.assertEquals(actualDropdown.toLowerCase(), expectedDropdown.toLowerCase());

        //2- Second way of doing same assertion
        Assert.assertTrue(actualDropdown.equalsIgnoreCase(expectedDropdown));

        //PRACTICE #8:
        // Storing all of the options in the month dropdown into the list of web elements
        List<WebElement> actualDropdownOptions = monthDropdown.getOptions();

        List<String> expectedMonths = Arrays.asList("January", "February", "March", "April", "May", "June", "July"
                , "August", "September", "October", "November", "December");




    }
}