package test.day4_findElements_checkbox_radio;

import com.google.gson.internal.$Gson$Preconditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

/*
TC #2: SeleniumEasy Checkbox Verification – Section 1
1. Open Chrome browser
2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify "Success – Check box is checked" message is NOT displayed.
4. Click to checkbox under "Single Checkbox Demo" section
5. Verify "Success – Check box is checked" message is displayed.
 */
public class TC5_seleniumEasy_checkBox {

    public static void main(String[] args)throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement successMessage=driver.findElement(By.xpath("//div[@id='txtAge']"));

        if (!checkBox1.isSelected()&&!successMessage.isDisplayed()) {
            System.out.println("default value verification Passed!");
        } else {
            System.out.println("default value verification Failed!");

        }
        Thread.sleep(4000);
        checkBox1.click();

        if (successMessage.isDisplayed()){
            System.out.println("Success message is displayed ,PASSED !" );
        }else {
            System.out.println("Success message is displayed ,FAILED !");
        }
        driver.quit();
}
}



