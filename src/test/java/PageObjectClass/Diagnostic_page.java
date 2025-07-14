package PageObjectClass;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Diagnostic_page extends BasePage {
	public Diagnostic_page(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "(//div[.='Surgeries'])[2]")
	WebElement surgeries;

	@FindBy(xpath = "//div[.='Lab Tests']")
	WebElement labtest;

	@FindBy(xpath = "//ul[@class='u-br-rule u-marginb--std-half u-pointer u-padb--dbl o-flex o-flex__justify--between']//li")
	List<WebElement> cities;

	public static List<String> listoftopcities = new ArrayList<>();

	public boolean validation() {
		return surgeries.isDisplayed();
	}

	public void clickonsurgeriesandlabtest() {
		surgeries.click();
		boolean lab= labtest.isDisplayed();
	     labtest.click();
 	}

	public void printcities() {
		for (WebElement e : cities) {
			String text = e.getText();
			System.out.println(text);
			listoftopcities.add(text);
 		}
	}
}
