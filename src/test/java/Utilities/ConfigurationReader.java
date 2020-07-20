package Utilities;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

//1-create properties object
    private static Properties properties=new Properties();

     //statice be able to only run one before than every thing run.
     //we can not dractly write code inside of class,it should be write into kind of block of main method,
    // ,so we can use static block to write our code here ,can slowe our problem.

      static {
     //2-get the path and store in the String ,or directly pass into fileInputStream obj
        String path = "configuration.properties";
     //3-we need to open file
        try {
            FileInputStream file=new FileInputStream(path);
     //4-we need to load file
            properties.load(file);
      //5-close.file
         file.close();

        } catch (IOException e) {
            System.out.println("Properties file not found");
        }
    }
    //our own custom method read get value from configuration.properties file
    public static String getProperty(String keyWord){
         return  properties.getProperty(keyWord) ;
    }
}
