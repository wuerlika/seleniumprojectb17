package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {

  public ForgetPasswordPage(){
      PageFactory.initElements(Driver.getDriver(),this);
  }
    //input box
    @FindBy(id = "prependedInput")
    public WebElement inputBox;

    //request button
    @FindBy(xpath = "//button[.='Request']")
    public WebElement requestButton;

    //error message
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;


}
