package test.practice.day4;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TestNg {
//TestNg ->
    //stands for test  next  generation .
    //TestNg is unit testing tool that allow us create flow using annotations.
    //first we create methods,the we use testNg ananotations to creating running flow.
    //These tools enables unit testing, functional testing...
    // •Provides assertions for verifying
    // •We can use annotation to control test flow
    // •We can generate some reports
    @BeforeSuite
 public void BeforeSuit(){
     System.out.println("BeforeSuit");
 }



@BeforeTest
  public void beforeTest(){
      System.out.println("Before test");
  }


 @BeforeClass
  public void Before(){
      System.out.println("Before class");
  }




    @BeforeMethod
public void setUp(){
    System.out.println("Before method");
}

@Test(priority = 3)
public  void test1(){
    String word1="java";
    String word2="java";
    System.out.println("Test1");
    Assert.assertEquals(word1,word2);

}
 //@Ignore
@Test(priority = 2)
public  void test2(){
    String word3="java ";
    String word4="java";
    System.out.println("Test2");
   // Assert.assertEquals(word3,word4);//Failed
}
@Test(priority = 1)
public  void test3(){
        Assert.assertTrue( 5>4);//failed
    System.out.println("Test 3");
    throw new SkipException("skip");//test 3 will skipped
}

@AfterMethod
    public void  tearDown(){
    System.out.println("After method");
}
@AfterClass
public void AfterClass(){
    System.out.println("After class");
}
@AfterTest
public void AfterTest(){
    System.out.println("After test");
}
@AfterSuite
public void AfterSuit(){
    System.out.println("After suit");
}
}
