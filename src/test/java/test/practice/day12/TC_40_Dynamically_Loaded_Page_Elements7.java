package test.practice.day12;

import Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.day12_synchronization.Loading7Page;

public class TC_40_Dynamically_Loaded_Page_Elements7 {
   /*
   1.Go to http://practice.cybertekschool.com/dynamic_loading/7
   2.Wait until title is “Dynamic title”
   3.Assert : Message “Done” is displayed.
   4.Assert : Image is displayed
    */

   @Test
    public void TC_40Dynamic_loadedPage_test(){
       //1->
       Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");
       Loading7Page loading7Page=new Loading7Page();
       //2->
       WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
       //3->
       String dynamicTtile="Dynamic title";
       wait.until(ExpectedConditions.titleIs(dynamicTtile));

       Assert.assertTrue(loading7Page.downMessage.isDisplayed());
       //4->
       Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());

   }


}
