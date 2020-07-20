package Utilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class SmartBearUtilities {


    public static void login(WebDriver driver) {
        //3. Enter username: “Tester”
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");
        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
    }

    /*
    PRACTICE #4: Method: verifyOrder•
    Create a method named verifyOrderin SmartBearUtils class.
    •Methodtakes WebDriver object and String(name).
    •Methodshould verify if given name exists in orders.
    •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    •Create a new TestNG test to test if the method is working as expected.
     *
    WebDriver driver;
    public static void verifyOrder(WebDriver driver, String name){
        List<WebElement> elements =  driver.findElements(By.xpath("//table[@class= 'SampleTable']/tbody/tr/td[2]"));
        String names = "";
        for (WebElement each:elements) {
            names+= each.getText();
        }
        Assert.assertTrue(names.contains(name));
    }


/*
Practice #5: Method: printNamesAndCities
•Create a method named printNamesAndCitiesin SmartBearUtils class.
•Method takes WebDriver object.
•This method should simply print all the names in the List of All Orders.
•Create a new TestNG test to test if the method is working as expected.
•Output should be like:
•Name1: name , City1: city•Name2: name , City2: city


    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[2]"));
        List<WebElement> listOfCities = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[7]"));
        String result = "";
        for(int  i = 0; i < listOfNames.size(); i++){
            result = "Name"+(i+1)+": "+listOfNames.get(i).getText()+" , "+"City"+(i+1)+": "+listOfCities.get(i).getText();
            System.out.println(result);

        }
    }
*/

    public static void verifyOder(WebDriver driver, String name) {

        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each : nameList) {
            if (each.getText().equals(name)) {
                if (each.getText().equals(name)) {
                    Assert.assertTrue(true);
                    return;
                }
            }

            Assert.fail("The name does not exist in the list! Verification failed!");


        }


    }

    public static void printNamesAndCities(WebDriver driver) {
        //the list where we store all the names in the wep table
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        //the list where we store all the of the  cities in the wep table
        List<WebElement> cities = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));
        //instead of creating for each loop ,we will creat regular loop
        //because we can use int i index number to get both names and
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println("name: " + nameList.get(i).getText() + ",   cities: " + cities.get(i).getText());
        }
    }


    public static void removeName(WebDriver driver, String name) {
        //List<WebElement> NameList=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        String xpath = "//td[.='" + name + "']/..//td";
        driver.findElement(By.xpath(xpath)).click();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']")).click();

    }

}