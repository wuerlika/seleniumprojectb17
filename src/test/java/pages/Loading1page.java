package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loading1page {

   public Loading1page(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

    @FindBy( xpath = "//button[@class='btn btn-primary'][1]")
    public WebElement starButton;

   @FindBy(id = "username")
    public  WebElement  usernameInput;

   @FindBy(id = "pwd")
    public WebElement passwordInput;


   @FindBy(id = "loading")
    public WebElement loadingBar;

   @FindBy(id = "flash")
    public WebElement errorMessage;

   @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
   }

