package TestCases;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import PageObjectClass.Diagnostic_page;
import PageObjectClass.HealthandWellnessPage;
import PageObjectClass.HomePage;
import TestBase.BaseClass;
import Utills.ExcelOuputUtils;

public class TC_02_DiagnosticPage extends BaseClass {

	@Test(priority = 1)
	public void valiationfortitleTC2() throws IOException {

		Diagnostic_page dg = new Diagnostic_page(driver);
		assertEquals(true, dg.validation());
		captureScreen("Home Page TC2");
	}

	@Test(priority = 2)
	public void diagnosticclick() throws IOException {

		Diagnostic_page pg = new Diagnostic_page(driver);
		pg.clickonsurgeriesandlabtest();
	}

	@Test(priority = 3)
	public void validationfordiagnosticpage() throws IOException {

		String act_title = driver.getTitle();
		String exp_title = "Blood Tests | Book Diagnostic Tests from Home at Best Prices | Practo";
		assertEquals(exp_title, act_title);
		captureScreen("Diagnostic Page");
	}

	@Test(priority = 4)
	public void topcitiesdisplay() throws IOException {

		Diagnostic_page pg = new Diagnostic_page(driver);
		pg.printcities();
		try {
			ExcelOuputUtils.ExcelOutputData1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		captureScreen("Top Cities List");

	}

}
