package TestCases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {
	public  ExtentSparkReporter htmlreporter;
	public  ExtentReports extent;
	public 	ExtentTest test;
	
	  public void onFinish(ITestContext context) {

	    extent.flush();
	  
	    
	  }
	  public void onStart(ITestContext context) {

		  htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\HospitalsReport.html");
		  extent = new ExtentReports();
		  extent.attachReporter(htmlreporter);
		  htmlreporter.config().setDocumentTitle("Google Automation Report");
		  htmlreporter.config().setReportName("Automation Report");
	      htmlreporter.config().setTheme(Theme.DARK);
		  
		  extent.setSystemInfo("Computer Name","Local Host");
		  extent.setSystemInfo("Environment","QA");
		  extent.setSystemInfo("Tester Name","Sharathkumaar Sk");
		  extent.setSystemInfo("os","Windows10");
		  extent.setSystemInfo("Browser","Edge");
	  }
		public void onTestSuccess(ITestResult result) {

		      test = extent.createTest(result.getName());
		      test.log(Status.PASS , "Test case passed : "+result.getName());
			  test.info("Test Completed");
		  }
		  
		  public void onTestFailure(ITestResult result) {
			  test = extent.createTest(result.getName());
			  test.log(Status.FAIL, "Test case failed : "+result.getThrowable());
			  test.info("Test interrupted");
		  }
		  public void onTestSkipped(ITestResult result) {
			  test = extent.createTest(result.getName());
			  test.log(Status.SKIP, "Test case skipped : "+result.getName());
			  test.info("Test skipped");
		  }

	


}
