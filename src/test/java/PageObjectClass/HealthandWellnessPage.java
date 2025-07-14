package PageObjectClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HealthandWellnessPage extends BasePage {

	public HealthandWellnessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

// All Locators
 	@FindBy(xpath = "//span[@class='nav-interact']")
	WebElement ForCorporateButton;
	
	@FindBy(xpath = "//a[starts-with(text(),'Health')]")
	WebElement HealthandWellnessButton;
	
	@FindBy(id = "name")
	WebElement Your_Name;
	
	@FindBy(id = "organizationName")
	WebElement Your_Organization_Name;
	
	@FindBy(name = "contactNumber")
	WebElement Contact_number;
	
	@FindBy(id = "officialEmailId")
	WebElement Your_EmailId;
	
	@FindBy(id = "organizationSize")
	WebElement Your_organizationSize;
	
	@FindBy(xpath = "//option[@value='501-1000']")
	WebElement Range_organizationSize;
	
	@FindBy(id = "interestedIn")
	WebElement You_are_interestedInbutton;
	
	@FindBy(xpath = "//option[@value='A career opportunity']")
	WebElement You_are_interestedIn;
	
	@FindBy(xpath = "//button[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-grey-3']")
	WebElement Shedule_demo_button;
	
	@FindBy(xpath = "//button[text()='Schedule a demo']")
	WebElement Shedule_demo_button1;
	
	@FindBy(xpath = "(//div[@class='u-text--bold text-alpha'])[1]")
	WebElement Thnx;
	
	@FindBy(xpath = "(//h2[@class=\"u-m-b--20 text-beta\"])[1]")
	WebElement Shedulebutton;

// All Methods 

	public boolean click() {
		ForCorporateButton.click();
		HealthandWellnessButton.click();
		return Shedulebutton.isDisplayed();
	}

	public boolean ClickOnHealthwithInvalidData(List<String> ExcelInputData) throws InterruptedException {

		Your_Name.sendKeys(ExcelInputData.get(0));
		Thread.sleep(3000);
		Your_Organization_Name.sendKeys(ExcelInputData.get(1));
		Contact_number.sendKeys(ExcelInputData.get(2));
		Your_EmailId.sendKeys(ExcelInputData.get(3));
		Your_organizationSize.click();
		Range_organizationSize.click();
		You_are_interestedInbutton.click();
		You_are_interestedIn.click();
		Thread.sleep(3000);
		boolean Actual = Shedule_demo_button.isEnabled();
		Your_Name.clear();
		Your_Organization_Name.clear();
		Contact_number.clear();
		Your_EmailId.clear();
		return Actual;
	}
	
 

	
	public void ClickOnHealthwithValidData(List<String> ExcelInputData1) throws Exception {

		Your_Name.sendKeys(ExcelInputData1.get(0));
		Your_Organization_Name.sendKeys(ExcelInputData1.get(1));
		Contact_number.sendKeys(ExcelInputData1.get(2));
		Your_EmailId.sendKeys(ExcelInputData1.get(3));
		Your_organizationSize.click();
		Range_organizationSize.click();
		You_are_interestedInbutton.click();
		You_are_interestedIn.click();
		Thread.sleep(3000);
		Shedule_demo_button1.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(Thnx));

	}

 
	public boolean validate() {
		return Thnx.isDisplayed();
  	}

}
