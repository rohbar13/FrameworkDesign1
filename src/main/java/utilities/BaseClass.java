package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BaseClass {

	public WebDriver openBrowser() {
		Reporter.log("Open Browser");
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public void getURL(WebDriver driver,String URL) {
		Reporter.log("Open URL "+URL);
		driver.get(URL);
	}
	
	public String captureScreenshot(WebDriver driver,String filename) throws IOException {
		Reporter.log("Capture Screenshot");
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("screenshot//"+filename+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
	public void clickElement(WebElement element) {
		Reporter.log("Click Element "+element.getText());
		element.click();
	}
	
}
