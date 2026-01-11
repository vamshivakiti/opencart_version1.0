package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperiesFile {
   
	public static void main(String[] args) throws IOException {
		//location of the properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Testdata\\config.properties");
	
  //Loading the properties file
  Properties propobj = new Properties();
  propobj.load(file);
	
  //Reading the data from properties file.
 String appUrl= propobj.getProperty("url");
  String email=propobj.getProperty("email");
   String password= propobj.getProperty("password");
  String custId= propobj.getProperty("customerId");
  System.out.println(appUrl +"-"+ email+"--"+password+"---"+custId);
  
  
  
	}

}
