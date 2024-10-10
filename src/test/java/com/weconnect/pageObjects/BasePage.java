package com.weconnect.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public WebDriver driver;

	// Base page contains constructor only
	public BasePage(WebDriver driver ) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}}
