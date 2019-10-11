package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SampleExtentReport {
	
	@Test
	public void loginTest() {
		
		//create Object of ExtentHtmlReporter and provide the path where report will generate
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\Users\\share\\eclipse-workspace\\SeleniumPlayground\\Reports\\sampleReport.html");
		
		//create object of the ExtentReports class - This class will create report
		ExtentReports extent = new ExtentReports();
		
		//attach the reporter which will create in step.1
		extent.attachReporter(reporter);
		
		//call createTest method and pass the TestCase name.
		ExtentTest logger = extent.createTest("SampleExtentReport");
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_soft\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://automationpractice.com/index.php");
		logger.log(Status.INFO, "Automating sample automation practice website.");
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "My Store");
		logger.log(Status.PASS, "Page title verified.");
		
		WebElement logo = driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/logo.jpg']"));
		Assert.assertTrue(logo.isDisplayed());
		
		logger.log(Status.PASS, "Verified the logo in Home page.");
		
		//flush method will write the test in report - This is mandatory.
		extent.flush();
		driver.quit();
	}

}
