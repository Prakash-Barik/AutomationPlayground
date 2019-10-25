package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot {
	
	WebDriver driver;
	String baserURL = "https://www.google.com/";
	String filePath = "C:\\Users\\Prakash\\Desktop\\Screenshots\\";
	
	@Test
	public void sampleScreenshotTest() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Soft\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baserURL);
		driver.manage().window().maximize();
		takeScreenshot();
		System.out.println("1st sceenshot captured successfully");
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("kgf");
		Thread.sleep(2000);
		takeScreenshot();
		System.out.println("2nd screenshot captured successfully..");
		driver.quit();
	}
	
	private void takeScreenshot(){
		TakesScreenshot scr = ((TakesScreenshot)driver);
		File srcFile = scr.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ss").format(new Date());
		File dstFile = new File(filePath+"screenshot"+timeStamp+".png");
		try {
			FileUtils.copyFile(srcFile, dstFile);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

