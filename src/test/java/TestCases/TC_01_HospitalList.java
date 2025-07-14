package TestCases;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import PageObjectClass.HomePage;
import TestBase.BaseClass;
import Utills.ExcelOuputUtils;
import Utills.ExcelUtils;

public class TC_01_HospitalList extends BaseClass {
	@Test(priority = 1)
	public void validationoftitle() throws IOException {
		String act_title = driver.getTitle();
		String exp_title = "Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests";
		captureScreen("HomePage Opened");
		assertEquals(exp_title, act_title);
	}

	@Test(priority = 2)
	public void searchforhospitals() throws IOException {
		PageObjectClass.HomePage hp = new PageObjectClass.HomePage(driver);
		hp.searchForHospitalClick();
		captureScreen("Hospital List Click");
	}

	@Test(priority = 3)
	public void locationsearch() throws InterruptedException, IOException {
		PageObjectClass.HomePage hp = new PageObjectClass.HomePage(driver);
		hp.locationsearch(ExcelUtils.CityName());
		captureScreen("Banglore Location");
	}

	@Test(priority = 4)
	public void HospitalList() throws InterruptedException, IOException {
		PageObjectClass.HomePage hp = new PageObjectClass.HomePage(driver);
		// hp.displaying_the_list();
		hp.listOfHospitals();
		try {
			ExcelOuputUtils.ExcelOutputData2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		captureScreen("List of Hospitals");
	}

}
