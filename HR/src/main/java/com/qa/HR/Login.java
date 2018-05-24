package com.qa.HR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(xpath = "//*[@id=\"txtUsername\"]")
	private WebElement user;

	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	private WebElement pass;

	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	private WebElement login;

	public void userinfo() {
		user.sendKeys("Admin");
		pass.sendKeys("admin");
		login.click();

	}

}
