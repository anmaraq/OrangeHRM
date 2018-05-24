package com.qa.HR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEButton {

	@FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/b")
	private WebElement pim;

	@FindBy(xpath = "//*[@id=\"menu_pim_addEmployee\"]")
	private WebElement addE;

	public void addTab() {
		pim.click();
		addE.click();

	}
}
