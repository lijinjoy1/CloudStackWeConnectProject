package com.weconnect.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.weconnect.TestBase.BaseClass;
import com.weconnect.Utilities.DataProviderUtil;
import com.weconnect.Utilities.ExtentReportManager;
import com.weconnect.pageObjects.LoginPage;


public class TC001_LoginPageTest extends BaseClass {

    @Test(dataProvider = "excelDataProvider" , dataProviderClass = DataProviderUtil.class)
    public void verifyLogin(String email, String password) throws InterruptedException {

    	
    	
        try {
            LoginPage loginpage = new LoginPage(driver);
            
            loginpage.addemail(email);
            loginpage.addPassword(password); 
            
            //loginpage.login(email, password);
            
            loginpage.captchaCheckBox();

            
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            Thread.sleep(2000);

            // Click login button
            loginpage.clickLogin();

            try {
            	
            String expecteddashBoardElemen  = loginpage.dashBoardElement();
            String actualdashBoardElement = "Get Started!";
            if (actualdashBoardElement.equals(expecteddashBoardElemen)) {
            	
            	System.out.println("Login successful");
            
            }}catch (Exception e) {
            
            	System.out.println("Login successful failed !!!!!!!!!!!!!!!!!");
            	System.out.println("Exception occurred: and failed" +e.getMessage());
            }
                     
            loginpage.clickMyaacount();
            Thread.sleep(2000);
            loginpage.clickLogOut();

        } catch (Exception e) {
          
          
        	System.out.println("Exception occurred: and failed" );
            Assert.fail();
        }
    }
}
