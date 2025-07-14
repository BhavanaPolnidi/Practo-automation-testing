package PageObjectClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--locality']")
	WebElement locationsearchBox;

	@FindBy(xpath = "//span[@class='c-omni-clear']")
	WebElement clearbutton;

	@FindBy(xpath = "//input[@placeholder='Search location']")
	WebElement Firstsearchcontext;

	@FindBy(xpath = "//a[.='Search for hospitals']")
	WebElement searchforhospital;

	@FindBy(xpath = "(//div[@class='c-estb-info']/a)")
	List<WebElement> hospitallist;

	@FindBy(xpath = "(//div[@class='c-omni-suggestion-item'])[1]")
	WebElement searchoption;

	@FindBy(xpath = "//span[@class='u-bold']")
	WebElement ratings;

	@FindBy(xpath = "//span[@class='u-spacer--right-less p-entity__item-title-label']")
	List<WebElement> aminities;

	@FindBy(xpath = "//div[normalize-space()='Bangalore']")
	WebElement banglore;

	@FindBy(xpath = "//input[@placeholder='Search location']")
	WebElement locationInput;
	@FindBy(xpath = "//div[normalize-space()='Bangalore']")
	WebElement bangloreLocation;
	@FindBy(xpath = "//span[contains(text(),'Read more info')]")
	WebElement readMoreInfoButton;
	@FindBy(xpath = "//div[@class=\"c-prime-header\"]//h1[contains(text(),\"Hospitals in Bangalore\")]")
	WebElement FirstResult1;

	@FindBy(xpath = "//span[@class='common__star-rating__value']")
	WebElement ratingElement;

	@FindBy(xpath = "//div[@class='c-omni-suggestion-group']/div")
	List<WebElement> autosuggestion;

	@FindBy(xpath = "//div[@class=\"c-prime-header\"]//h1[contains(text(),\"Hospitals in Bangalore\")]")
	WebElement FirstResult;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions action = new Actions(driver);

	public List<WebElement> hospitalList;
	public static List<String> hospitalList2 = new ArrayList<>();

	public void searchForHospitalClick() {
		searchforhospital.click();
	}

	public void locationsearch(String locationcity) throws InterruptedException {
		locationInput.clear();
		locationInput.click();
		locationInput.sendKeys(locationcity);
//		Thread.sleep(2000);
		bangloreLocation.click();
		// searchoption.click();
	}

	public void displaying_the_list() {
		for (WebElement e : hospitallist) {
			String list = e.getText();
			System.out.println("-------------------------------------------");
			System.out.println(list);
		}
	}

	public void listOfHospitals() {
		int count = 0;
//		Action action=new Action(driver);
		wait.until(ExpectedConditions.visibilityOf(FirstResult));
		hospitalList = driver.findElements(By.xpath("//div[@class=\"c-estb-card\"]//a[@target=\"_blank\"]"));
		System.out.println();
		System.out.println();
		System.out.println(
				"------- Hospital opened 24/7, having Parking fecility and having ratings more than 3.5 --------");
		for (WebElement ele : hospitalList) {
			String HospetialName = ele.getText();
			ele.click();
			Set<String> windows = driver.getWindowHandles();
			List<String> window = new ArrayList<>(windows);
			String parentWindow = window.get(0);
			String childWindow = window.get(1);
			driver.switchTo().window(childWindow);
			action.moveToElement(readMoreInfoButton);
			readMoreInfoButton.click();
			List<WebElement> Amenities = driver.findElements(By.xpath("//div[@data-qa-id=\"amenities_list\"]//span"));
			for (WebElement elem : Amenities) {
				if (elem.getText().equals("24X7 Pharmacy") || elem.getText().equalsIgnoreCase("Parking")) {
//					System.out.println(elem.getText());
					count++;
				}
			}
			double rating = Double.parseDouble(ratingElement.getText());
			if (count > 1 && rating > 3.5) {
				System.out.println("Hospital : " + HospetialName);
				hospitalList2.add(HospetialName);
			}
			count = 0;
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		System.out.println();
		System.out.println();
	}

}
