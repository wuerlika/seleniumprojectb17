package test.day10_jsexecutor_upload_actions;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Uploading {



    @Test
    public void Uploading_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        WebElement chooseFile=Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        chooseFile.sendKeys("/Users/hurlikamuhammattursun/Desktop/SeleniumClass/something");
        //WebElement fileUpload=
    }
}
