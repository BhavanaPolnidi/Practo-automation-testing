package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CucumberBaseClass {

	public static WebDriver driver;
	static Properties p;
 
	public static WebDriver initilizeBrowser() throws IOException {
		p = getProperties();
		switch (p.getProperty("browser")) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("No matching browser");
			driver = null;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader("C:\\Users\\2389291\\Downloads\\Hackothon (2) (1)\\Hackothon\\src\\test\\resources\\ConfigureFile.properties");
		p = new Properties();
		p.load(file);
		return p;
	}

	 

}