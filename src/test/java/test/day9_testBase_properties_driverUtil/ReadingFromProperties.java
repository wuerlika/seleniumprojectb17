package test.day9_testBase_properties_driverUtil;

import Utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void ReadingProperties_file()throws IOException {

        //Properties class object allows us to read from configuration.properties();

        Properties properties=new Properties();

        //we need show where is file is stored. we need the path of the file.
        String path="configuration.properties";

        //we need to open this configuration.properties file in java memory
        FileInputStream file=new FileInputStream(path);

        //we need to load the opened into the properties Object
        properties.load(file);

        //we can read configuration.properties files using properties object
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));
    }

    @Test
    public void using_configuration_file_utility(){
      String browser  =ConfigurationReader.getProperty("browser");
        System.out.println("browser"+browser);

        String username=ConfigurationReader.getProperty("suername");
        System.out.println("User name"+username);
    }



}
