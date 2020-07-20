package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Faker_paractice {
//Java faker :is used to create fake data for testing purposes
//It is sa small library tha has the ability to create randomly generated data.
//Useful when you have a bunch of input that you need to enter on a page  .
//you can use Java faker for this purpose ,It will generate random data for you .
// full name,  first /last name ,address , phoneNumber , email ,and dozens of other different option.
 @Test

     public void faker_test(){
         Faker faker = new Faker();
         String name = faker.name().fullName(); // Miss Samanta Schmidt
         System.out.println("name = " + name);

         String firstName = faker.name().firstName(); // Emory
         System.out.println("firstName = " + firstName);

         String lastName = faker.name().lastName(); // Barton
         System.out.println("lastName = " + lastName);
         String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
         System.out.println("streetAddress = " + streetAddress);

         String gameOfThrones=faker.gameOfThrones().quote();
         System.out.println("game of the thrones"+gameOfThrones);

         String  chuckNorris=faker.chuckNorris().fact();

     }
 }


