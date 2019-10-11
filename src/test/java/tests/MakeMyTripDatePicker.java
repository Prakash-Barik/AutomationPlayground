package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTripDatePicker {
	
	WebDriver driver;
	String filePath = "C:\\Users\\share\\eclipse-workspace\\SeleniumPlayground\\Screenshots";
	
	@Test
	public void testMakemyTrip() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium_soft\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[contains(text(),'From')]")).click();
		System.out.println("clicked on the from field");
		driver.findElement(By.xpath("//p[contains(text(),'Bangalore, India')]")).click();
		System.out.println("clicked bangalore as the start point.");
		
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
		System.out.println("clicked on the To field.");
		WebElement toField = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		toField.click();
		toField.sendKeys("bbi");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),'Bhubaneswar, India')]")).click();

		driver.findElement(By.xpath("//label[@for='departure']")).click();
		System.out.println("clicked on the departure date picker.");
		
		driver.findElement(By.xpath("//div[@aria-label='Thu Oct 10 2019']")).click();
		System.out.println("selected the departure date");
		
		driver.findElement(By.xpath("//p[contains(text(),'Tap to add a return date for bigger discounts')]")).click();
		System.out.println("clicked on the return date picker.");
		
		driver.findElement(By.xpath("//div[@aria-label='Wed Oct 16 2019']")).click();
		System.out.println("selected the return date.");
		
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		System.out.println("after entering the details, clicked on search button..");
		Thread.sleep(3500);
		driver.close();
		/*
		 * TakesScreenshot scrShot =((TakesScreenshot) driver); File srcFile =
		 * scrShot.getScreenshotAs(OutputType.FILE); File
		 * destFile = new File(filePath);
		*/
		
	}

}
