package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//FeatureFile/DiagnosticPage.feature"},
                 glue = { "stepDefination"},
                 plugin = { "pretty","html:ExtentReports//CucumberReport//cucumberReport.html",
                		 "rerun:target/rerun.txt",
				         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRun {

}
