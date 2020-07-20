package test.day10_jsexecutor_upload_actions;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScripExcutorPractices {



    @Test
    public void jsexecutor_test() throws InterruptedException{
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        //Syntext of how to use JavaScriptExecutor:
        //1.we create javaScript object and we
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();
        Thread.sleep(4000);

        //2.then hava access to the methoda that are coming from javaScriptExecutor interface
        //this method accepted 2 argument
        //first argument:String.We pass Js code in string.
        //Second argument:We pass OBJ Type if we want to do specific action on something specific.
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", cybertekSchoolLink);
    }








}
