package com.weconnect.TestBase;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.weconnect.Utilities.ExtentReportManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setup()  {
		
		//System.setProperty("webdriver.edge.driver", "C:/Program Files/msedgedriver.exe");
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://account.we-connect.io/login");
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}

}
