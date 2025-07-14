package stepDefination;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import PageObjectClass.Diagnostic_page;
import TestBase.CucumberBaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class StepDefination1 {
	WebDriver driver;
	@Given("I am on the Diagnostics page")
	public void i_am_on_the_diagnostics_page() {
		driver = CucumberBaseClass.getDriver();
		Diagnostic_page dg = new Diagnostic_page(driver);
		String actual_title = driver.getTitle();
		String exp_title = "Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests";
		assertEquals(exp_title, actual_title);
	}
	@When("I pick all the top cities names")
	public void i_pick_all_the_top_cities_names() {
		Diagnostic_page dg = new Diagnostic_page(driver);
		assertEquals(true, dg.validation());
	}
	@Then("I store the top cities names in a List")
	public void i_store_the_top_cities_names_in_a_list() {
		Diagnostic_page dg = new Diagnostic_page(driver);
		dg.clickonsurgeriesandlabtest();
	}
	@Then("I display the List of top cities names")
	public void i_display_the_list_of_top_cities_names() {
		Diagnostic_page dg = new Diagnostic_page(driver);
		dg.printcities();
	}
}
