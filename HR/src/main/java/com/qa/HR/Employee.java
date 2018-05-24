package com.qa.HR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Employee {
	
	String idnum = "9250";
	String firstn = "Anmar";
	String lastn = "Mah";
			
	

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	private WebElement first;

	@FindBy(xpath = "//*[@id=\"lastName\"]")
	private WebElement last;
	
	@FindBy(xpath = "//*[@id=\"employeeId\"]")
	private WebElement id;

	@FindBy(xpath = "//*[@id=\"btnSave\"]")
	private WebElement save;

	@FindBy(xpath = "//*[@id=\"chkLogin\"]")
	private WebElement checkmark;

	@FindBy(xpath = "//*[@id=\"user_name\"]")
	private WebElement username;

	@FindBy(xpath = "//*[@id=\"user_password\"]")
	private WebElement pass;

	@FindBy(xpath = "//*[@id=\"re_password\"]")
	private WebElement repass;

	public void addDet() {
		first.sendKeys(firstn);
		last.sendKeys(lastn);
		id.clear();
		id.sendKeys(idnum);
		
	}

	public void check() {

		checkmark.click();

	}

	public void UserDet() {
		username.sendKeys("abcdef");
		pass.sendKeys("abc123");
		repass.sendKeys("abc123");


	}
	
	public void save() {

		save.click();

	}

}
