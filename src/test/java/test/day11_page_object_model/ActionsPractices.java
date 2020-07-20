package test.day11_page_object_model;

import Utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ActionsPractices {

  Actions actions;
  @AfterMethod
    public void tearDown(){
      Driver.getDriver().quit();
  }
@Test
    public void scrolling_with_actions(){
    //get our page
    Driver.getDriver().get("http://practice.cybertekschool.com/");
    //creating actions instance tobe able to use its method
    Actions actions=new Actions(Driver.getDriver());


    //locating the web element we want to scroll to
    WebElement cybertekSchoolLink=Driver.getDriver().findElement(By.linkText("Cybertek School"));

    //using actions instance we use to moveToElement method
    actions.moveToElement(cybertekSchoolLink).perform();

}

@Test
    public void tc16_double_click_test(){
    //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    Driver.getDriver().get(" https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    Driver.getDriver().manage().window().maximize();

    //2. Switch to iframe.
    //1-index, 2.-id-name value, 3.-locate it as a web element and
    Driver.getDriver().switchTo().frame("iframeResult");

    //3. Double click on the text "Double-click me to change my text color."
    WebElement textToDoubleClick=Driver.getDriver().findElement(By.id("demo"));
    actions=new Actions(Driver.getDriver());

    //4. Assert: Text's "style" attribute value contains "red".
    String actual = textToDoubleClick.getAttribute("style");
    String expected = "color: red;";

    Assert.assertTrue(actual.equals(expected));

}

@Test
    public void tc17_drag_and_drop_test(){
    //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
    Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index ");
    Driver.getDriver().manage().window().maximize();

    //2. Drag and drop the small circle to bigger circle.
    WebElement smallCircle=Driver.getDriver().findElement(By.id("draggable"));
    WebElement bigCircle=Driver.getDriver().findElement(By.id("droptarget"));


    actions=new Actions(Driver.getDriver());
    //actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();
    actions.dragAndDrop(smallCircle,bigCircle).perform();

    //3. Assert:
    //-Text in big circle changed to: "You did great!"
    String actual=bigCircle.getText();
    String expected="You did great!";
}
    @Test
    public void tc18_right_click_test() {
        //1. Go to https://the-internet.herokuapp.com/context_menu
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        //2. Right click to the box.
        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));
        actions = new Actions(Driver.getDriver());
        actions.contextClick(box).perform();
        //3. Alert will open.
        Alert alert=Driver.getDriver().switchTo().alert();

        //4. Accept alert
        alert.accept();
        //No assertion needed for this practice.


    }}


















