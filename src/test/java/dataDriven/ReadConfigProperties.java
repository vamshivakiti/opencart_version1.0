package dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfigProperties {

	public static void main(String[] args) throws FileNotFoundException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("config.properties");
	}

}
