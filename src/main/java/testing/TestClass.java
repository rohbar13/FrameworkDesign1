package testing;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.BaseClass;

public class TestClass extends BaseClass{

	ExtentReports extent = new ExtentReports();
	ExtentHtmlReporter htmlreport = new ExtentHtmlReporter("test-output//extentreport.html");
	
	@Test
	public void testingHomePage() throws IOException {
		String testCaseID1 = "TC_HomePage_001";

		extent.attachReporter(htmlreport);
		
		ExtentTest test1 = extent.createTest(testCaseID1);
		
		WebDriver driver = openBrowser();
		
		getURL(driver, "https://www.easemytrip.com/");
		
		String title = driver.getTitle();
		
		if(title.contains("flight")) {
			test1.pass("Title Validated");
		}else {
			test1.fail("Title Validation Failed");
		}
		
		String pic1 = captureScreenshot(driver, testCaseID1);
		
		test1.addScreenCaptureFromPath(pic1);
		
		String testCaseID2 = "TC_HomePage_002";
		ExtentTest test2 = extent.createTest(testCaseID2);
		
		try
		{
			clickElement(driver.findElement(By.linkText("Flights")));
			test2.pass("Test Case Passed");
		}catch (Exception e) {
			test2.fail("Test Case Failed");
		}
		
		String pic2 = captureScreenshot(driver, testCaseID2);
		test2.addScreenCaptureFromPath(pic2);
		
		driver.quit();
		extent.flush();
	}
}
