package com.weconnect.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {
	
	// Constructor extending from BasePage
	public LoginPage (WebDriver driver ) {
		
		super(driver);
	}
	
	
	// Locators
	
	@FindBy(xpath="//input[@name='username']")
	WebElement txtEmailField;

	@FindBy(xpath="//input[@name='password']")
	WebElement txtPasswordField;
	

	@FindBy(xpath="//iframe[contains(@title, 'reCAPTCHA')]")
	WebElement captchaIframe;
	
	@FindBy(xpath="//*[@id='recaptcha-anchor']")
	WebElement captchaCheckBox;
	
	@FindBy(xpath="//button[@id='kt_login_signin_submit']")
	public WebElement btnLogin;
	
	
	@FindBy(xpath="//div[@class='tutorial__title d-flex align-items-center']")
	WebElement webElement1;
	
	
	@FindBy(xpath="//span[@class='m-nav__link-icon-wrapper header-icon avatar-icon color-0']")
	WebElement drpDwnMyaacnt;
		
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logOut;
	
	
	// Actions
	
	public void addemail (String email) {
		txtEmailField.clear();
		txtEmailField.sendKeys(email);
	}
	
	public void addPassword (String password) {
		txtPasswordField.clear();
		txtPasswordField.sendKeys(password);
	}
	
	
	public void captchaCheckBox() throws InterruptedException {
		 
		driver.switchTo().frame(captchaIframe); // Switching to Iframe
		captchaCheckBox.click();
		Thread.sleep(15000);
		
		// Switch back to the main page after clicking the CAPTCHA checkbox
        driver.switchTo().defaultContent();
        Thread.sleep(10000);
	}
	
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	
	public void clickMyaacount() {
		drpDwnMyaacnt.click();
		
	}
	
	public String dashBoardElement() {
		return webElement1.getText();
	}
	
	public void clickLogOut() {
		logOut.click();
		
	}
	

	
	
}
