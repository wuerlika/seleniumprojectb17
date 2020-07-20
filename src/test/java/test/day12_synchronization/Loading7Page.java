package test.day12_synchronization;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loading7Page {


    public Loading7Page(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//strong")
    public WebElement downMessage;

    @FindBy(xpath = "//img[@class='rounded mx-auto d-block']")
    public  WebElement spongeBobImage;

}
