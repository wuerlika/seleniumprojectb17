package test.day9_testBase_properties_driverUtil;

import org.testng.annotations.Test;

public class LearningProperties {

//.getProperty();->is accepting e key and return its value
//How we have been passing our testing data?
//What is test data?
//-The data we use to test our application
//ex:user name;password; and other information we pass
    //how we have been passing?
    //usernameInput.sedKeys("wuerlika")
    //passwordInput.sendKeys("123345")
    //loginButton.click();

    //What is hardCoding?
    //->hardcoding is putting our test data into our Tests.
    //->when you hard code, to be able to change the test data you have to goto each and every single test and change the
    //data from there

    //the idea is how to keep these values some where out side of our sours codes(tests), but inside of the project itself.
   //You get your test datda from outside of your code
    //we will create a properties file


    @Test
    public void java_properties_test(){
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }




}
