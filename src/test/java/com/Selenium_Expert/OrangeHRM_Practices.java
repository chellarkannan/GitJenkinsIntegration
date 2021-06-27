package com.Selenium_Expert;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import com.Selenium_Expert.OrangeHRM_Login;
import com.google.common.io.Files;
public class OrangeHRM_Practices {

	public static final String workdir= System.getProperty("user.dir");
	public static WebDriver driver;
	
	/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class)
            .withTimeout(Duration.ofSeconds(60));
           */
	
	@BeforeClass
	public void setup() {
		
		//implementation		
		System.setProperty("webdriver.chrome.driver",workdir+"/drivers/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		HashMap<String,String> prefs = new HashMap<String,String>();
		prefs.put("download.default_directory", workdir+"/Reports");
		options.setExperimentalOption("prefs",prefs);
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");	
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		
	}
	@Test(priority=0)
	public void loginPage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OrangeHRM_Login.loginBtn)));
		WebElement password = driver.findElement(By.xpath(OrangeHRM_Login.password)); 
		WebElement loginBtn = driver.findElement(By.xpath(OrangeHRM_Login.loginBtn));		
		WebElement loginID = driver.findElement(By.xpath(OrangeHRM_Login.loginID));		
		loginID.sendKeys("Admin");
		password.sendKeys("admin123");
		loginBtn.click();
		System.out.println(driver.getTitle());
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(src, new File(workdir+"/Reports/"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	}
}
