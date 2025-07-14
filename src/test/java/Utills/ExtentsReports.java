package Utills;
 
import java.awt.Desktop;
 import java.io.File;
 import java.io.IOException;
 //import java.net.URL;
 
//Extent report 5.x...//version
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.List;
 import org.testng.ITestContext;
 import org.testng.ITestListener;
 import org.testng.ITestResult;
 import com.aventstack.extentreports.ExtentReports;
 import com.aventstack.extentreports.ExtentTest;
 import com.aventstack.extentreports.Status;
 import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 import com.aventstack.extentreports.reporter.configuration.Theme;
 import TestBase.BaseClass;
  public class ExtentsReports extends BaseClass implements ITestListener {
 
	public ExtentSparkReporter sparkReporter;
 	public ExtentReports extent;
 	public ExtentTest test;
 	String repName;
 	public void onStart(ITestContext testContext) {
 
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
 		repName = "Test-Report-" + timeStamp + ".html";// dynamic name of report
 		sparkReporter = new ExtentSparkReporter(".\\ExtentReports\\" + repName);// specify location of the report
 		sparkReporter.config().setDocumentTitle("Practo Automation Report"); // Title of report
 		sparkReporter.config().setReportName("Finding Hospitals"); // name of the report
 		sparkReporter.config().setTheme(Theme.DARK);
 		extent = new ExtentReports();
 		extent.attachReporter(sparkReporter);
 		extent.setSystemInfo("Application", "Finding Hospitals");
 		extent.setSystemInfo("Module", "Hackathon Project");
 		extent.setSystemInfo("Environemnt", "QAE");
 
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
 		extent.setSystemInfo("Browser", browser);
 
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
 		if (!includedGroups.isEmpty()) {
 			extent.setSystemInfo("Groups", includedGroups.toString());
 		}
 	}
 
	public void onTestSuccess(ITestResult result) {
 //		test = extent.createTest(result.getTestClass().getName());
 		test = extent.createTest(result.getName());
 		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
 		test.log(Status.PASS, result.getName() + " got successfully executed");
 		/*try {
 			BaseClass bc=new BaseClass();
 			String imgPath = bc.extentreportscreenshot(result.getName());
 			test.addScreenCaptureFromPath(imgPath);
 		}
 		catch (IOException e1) {
 			e1.printStackTrace();
 		}*/
 		String imgPath =BaseClass.targetFilePath;
 		test.addScreenCaptureFromPath(imgPath);
		
 	}
 
	public void onTestFailure(ITestResult result) {
 		test = extent.createTest(result.getTestClass().getName());
 		test.assignCategory(result.getMethod().getGroups());
 		test.log(Status.FAIL, result.getName() + " got failed");
 		test.log(Status.INFO, result.getThrowable().getMessage());
 	/*	try {
 			String imgPath = new BaseClass().extentreportscreenshot(result.getName());
 			test.addScreenCaptureFromPath(imgPath);
 		}
 		catch (IOException e1) {
 			e1.printStackTrace();
 		}*/
 	}
 
	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
 		test.assignCategory(result.getMethod().getGroups());
 		test.log(Status.SKIP, result.getName() + " got skipped");
 		test.log(Status.INFO, result.getThrowable().getMessage());

	}
 
	public void onFinish(ITestContext testContext) {
 		extent.flush();
 		String pathOfExtentReport = System.getProperty("user.dir")+"\\ExtentReports\\"+repName;
 		File extentReport = new File(pathOfExtentReport);
 		try {
 			Desktop.getDesktop().browse(extentReport.toURI());
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 
	}
 
}

 