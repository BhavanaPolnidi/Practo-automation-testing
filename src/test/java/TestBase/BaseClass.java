package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
	protected WebDriver driver;
	public static Properties prop;
	public static String targetFilePath;
//	@Parameters("browserName")
	@BeforeClass(groups = { "regression", "master" }, dependsOnMethods = {})
	public WebDriver getDriver() throws IOException {
		// Properties File
		FileReader filepath = new FileReader(
				"C:\\Users\\2389291\\OneDrive - Cognizant\\Desktop\\hackathonProject\\src\\test\\resources\\ConfigureFile.properties");
		prop = new Properties();
		prop.load(filepath);
		String browserName=prop.getProperty("browser");
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
		}

		driver.get(prop.getProperty("appUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	public void captureScreen(String name) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		targetFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + name + ".png";
		File targetFile = new File(targetFilePath);
		FileUtils.copyFile(sourceFile, targetFile);
	}

	@AfterClass()
	public void teardown() {
		driver.quit();
	}
}
