package test.practice.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TC11_CreateAmethod_called_removeName {
   /*
   TC #11: Create a method called removeName()
   1.Accepts two parameters: WebDriver, String name
   2.Method will remove the given name from the list of Smartbear
   3.Create a new TestNG test, and call your method.
   4.Assert that your method removed the given name



    public static void removeName(WebDriver driver, String name) {
        //List<WebElement> NameList=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        String xpath = "//td[.='" + name + "']/..//td";
        driver.findElement(By.xpath(xpath)).click();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']")).click();
    }

    */

    public static void removeName(WebDriver driver, String name) throws InterruptedException{
        List<WebElement> NameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        List<String>listOfNames=new ArrayList<>();
        for(WebElement each: NameList){
            listOfNames.add(each.getText());
        }
        for(int i=0; i<listOfNames.size();i++){
            if(listOfNames.get(i).equalsIgnoreCase(name)){
                driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr["+(i+2)+"]/td[1]")).click();
                Thread.sleep(200);
                driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']")).click();
            }
        }



    }

}
