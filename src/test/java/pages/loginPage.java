package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;

public class loginPage {

    /*
    we will store all Login related web elements and methods in to this class.
     */


    public loginPage(){
       PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="prependedInput")
    public WebElement usernameInput;

    @FindBy(id="prependedInput2")
    public  WebElement passwordInput;


    //
    @FindBy(id="_submit")
    public WebElement loginButton;

    //locating error message
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement requestButton;

    @FindBy(partialLinkText = "Forgot your password?")
    public WebElement forgetPasswordlink;

    public  void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    public void loginUserName(String username){
        usernameInput.sendKeys(username);
        loginButton.click();
    }
}
