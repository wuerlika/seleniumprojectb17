package test.day4_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2.Go to https://www.apple.com
3.Click to all of   headers one by one a.Mac, iPad, iPhone, Watch, TV, Music, Support.
4.Printout how many links on each page with the titles of the pages.
5.Loop through all
6.Print out how many link is missing textTOTAL.
7.Print out how many link has textTOTAL.
8.Print out how many total linkTOTAL
 */
public class TC03_FINDELEMENTS_APPLE {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.apple.com");

        System.out.println("=======================Mac==========================");

        WebElement Mac=driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']"));
        Mac.click();

        String MacPageTitle=driver.getTitle();
        System.out.println("Mac page title"+MacPageTitle);

        List<WebElement> listOfMac=driver.findElements(By.xpath("//body//a"));
        int MaclinksWithoutText = 0;
        int MaclinksWithText = 0;

        for(WebElement eachLink:listOfMac){
            if(eachLink.getText().isEmpty()) {
               MaclinksWithoutText++;
            }else {
                MaclinksWithText++;
            }}
        System.out.println("Mac page link with text :"+MaclinksWithText+"\n"+"Mac link with out text:"+MaclinksWithoutText+"\n"+"Mac total link is :"+listOfMac.size());


        System.out.println("========================iPad page:=================================");


        Thread.sleep(3000);
        WebElement iPad=driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-ipad']"));
        iPad.click();
        String iPadPageTitle=driver.getTitle();
        System.out.println("iPad page title"+iPadPageTitle);
        List<WebElement> listOfIpad=driver.findElements(By.xpath("//body//a"));
        int iPadLinksWithoutText = 0;
        int iPadLinksWithText = 0;
        for(WebElement eachLink:listOfIpad){
            if(eachLink.getText().isEmpty()) {
                iPadLinksWithoutText++;
            }else {
                iPadLinksWithText++;
            }}
        System.out.println("iPad page link with text :"+iPadLinksWithText+"\n"+"iPad link with out text:"+iPadLinksWithoutText+"\n"+"iPad total link is :"+listOfIpad.size());


        System.out.println("============================iPhone=========================================");
        Thread.sleep(3000);
        WebElement iPhone=driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iPhone.click();
        String iPhonePageTitle=driver.getTitle();
        System.out.println("iPad page title"+iPhonePageTitle);
        List<WebElement> listOfIphone=driver.findElements(By.xpath("//body//a"));
        int iPhoneLinksWithoutText = 0;
        int iPhoneLinksWithText = 0;
        for(WebElement eachLink:listOfIphone){
            if(eachLink.getText().isEmpty()) {
                iPhoneLinksWithoutText++;
            }else {
                iPadLinksWithText++;
            }}

        System.out.println("iPone page link with text:"+iPhoneLinksWithText+"\n"+"iPad link with out text:"+iPhoneLinksWithoutText+"\n"+"iPhone total link is"+listOfIphone.size());


        System.out.println("=========================iWatch=====================================");

        Thread.sleep(3000);
        WebElement Watch=driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-watch']"));
        Watch.click();
        String iWatchPageTitle=driver.getTitle();
        System.out.println("iWatch page title"+iWatchPageTitle);
        List<WebElement> listOfIwatch=driver.findElements(By.xpath("//body//a"));
        int iWatchLinksWithoutText = 0;
        int iWatchLinksWithText = 0;
        for(WebElement eachLink:listOfIwatch){
            if(eachLink.getText().isEmpty()) {
                iWatchLinksWithoutText++;
            }else {
                iWatchLinksWithText++;
            }}
        System.out.println("iWatch page link with text :"+iWatchLinksWithText+"\n"+"iWatch page link with out text :"+iWatchLinksWithoutText+"\n"+"iWatch page total link is:"+listOfIwatch.size());


        System.out.println("==========================TV=====================================");

        Thread.sleep(3000);
        WebElement TV=driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-tv']"));
        TV.click();
        String TVPageTitle=driver.getTitle();
        System.out.println("TV page title"+TVPageTitle);
        List<WebElement> listOfTV=driver.findElements(By.xpath("//body//a"));
        int TVLinksWithoutText = 0;
        int TVLinksWithText = 0;
        for(WebElement eachLink:listOfTV){
            if(eachLink.getText().isEmpty()) {
                TVLinksWithoutText++;
            }else {
                TVLinksWithText++;
            }}
        System.out.println("TV page link with text :"+TVLinksWithText+"\n"+"TV page link with out text :"+TVLinksWithoutText+"\n"+"iWatch page total link is:"+listOfTV.size());

        System.out.println("============================Music===================================");

        Thread.sleep(4000);
        WebElement Music=driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-music']"));
        Music.click();
        String MusicPageTitle=driver.getTitle();
        System.out.println("TV page title"+MusicPageTitle);
        List<WebElement> listOfMusic=driver.findElements(By.xpath("//body//a"));
        int MusicLinksWithoutText = 0;
        int MusicLinksWithText = 0;
        for(WebElement eachLink:listOfMusic){
            if(eachLink.getText().isEmpty()) {
                MusicLinksWithoutText++;
            }else {
                MusicLinksWithText++;
            }}
        System.out.println("Music page link with text :"+MusicLinksWithText+"\n"+"Music pag link with out text :"+MusicLinksWithoutText+"\n"+"Music page total link is:"+listOfMusic.size());

        System.out.println("=======================Support=============================");

        Thread.sleep(3000);
        WebElement Support=driver.findElement(By.xpath("//li[@class='ac-gn-item ac-gn-item-menu ac-gn-support']"));
        Support.click();
        String SupportPageTitle=driver.getTitle();
        System.out.println("TV page title"+SupportPageTitle);
        List<WebElement> listOfSupport=driver.findElements(By.xpath("//body//a"));
        int SupportLinksWithoutText = 0;
        int SupportLinksWithText = 0;
        for(WebElement eachLink:listOfSupport){
            if(eachLink.getText().isEmpty()) {
                SupportLinksWithoutText++;
            }else {
                SupportLinksWithText++;
            }}
        System.out.println("Support page link with text :"+SupportLinksWithText+"\n"+"Support pag link with out text :"+SupportLinksWithoutText+"\n"+"Music page total link is:"+listOfSupport.size());

        Thread.sleep(3000);
        driver.quit();


    }


}
