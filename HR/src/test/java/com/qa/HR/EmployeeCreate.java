package com.qa.HR;


import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmployeeCreate {

	WebDriver driver;

	public ExtentTest test;

	ExtentReports report = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\HR\\Report\\Orange Report.html", true);

	@Before
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		test = report.startTest("Start the Test");

		driver.manage().window().maximize();
		driver.get("http://opensource.demo.orangehrmlive.com/index.php/auth/login");

		assertEquals("http://opensource.demo.orangehrmlive.com/index.php/auth/login", driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Login Page");
		
		Login login = PageFactory.initElements(driver, Login.class);

		login.userinfo();
		
		assertEquals("http://opensource.demo.orangehrmlive.com/index.php/dashboard", driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Dashboard Page");

	}

	@Given("^the Add Employee Tab$")
	public void the_Add_Employee_Tab() {
		
		AddEButton add = PageFactory.initElements(driver, AddEButton.class);

		add.addTab();
		
		assertEquals("http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee", driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Add Employee Page");

	}

	@When("^I fill out the Employee Details correctly$")
	public void i_fill_out_the_Employee_Details_correctly() {

		Employee employee = PageFactory.initElements(driver, Employee.class);
		employee.addDet();

	}

	@When("^I choose to create Login Details$")
	public void i_choose_to_create_Login_Details() {
		Employee employee = PageFactory.initElements(driver, Employee.class);
		
		employee.check();

	}

	@When("^I fill out the Login Details correctly$")
	public void i_fill_out_the_Login_Details_correctly() throws InterruptedException {
		Employee employee = PageFactory.initElements(driver, Employee.class);
		
		employee.UserDet();
		
		Thread.sleep(2000);

	}

	@When("^I click the Save button$")
	public void i_click_the_Save_button() throws InterruptedException {
		Employee employee = PageFactory.initElements(driver, Employee.class);
		
		employee.save();
		
	}

	@Then("^I can see information about the user$")
	public void i_can_see_information_about_the_user() throws InterruptedException {
		Employee employee = PageFactory.initElements(driver, Employee.class);
		
		assertEquals(employee.firstn + " " +  employee.lastn, driver.findElement(By.xpath("//*[@id=\"profile-pic\"]/h1")).getText());
		test.log(LogStatus.PASS, "Employee can be seen");
		
		Thread.sleep(4000);

	}
	
	@After
	public void teardown() {
		
		report.endTest(test);
		report.flush();
		
		driver.quit();
	}

}
