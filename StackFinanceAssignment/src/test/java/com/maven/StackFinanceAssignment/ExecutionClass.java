package com.maven.StackFinanceAssignment;

import java.lang.reflect.Method;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import stack.finance.Base.BaseClass;
import stack.finance.pages.HomePage;
import stack.finance.reports.ExtentReport;



public class ExecutionClass extends BaseClass {

	AndroidDriver driver1 = null;
	public ExtentReports extentReports;
	HomePage hp;
	
	static ExtentReport report = new ExtentReport();
	static ExtentTest extentTest;
	@BeforeClass
	public void beforeClass() throws Exception {

		driver1 = setUP_Android("Android", "10", "52953f4", "http://0.0.0.0:4723/wd/hub");

	}

	@BeforeMethod
	public void beforeMethod(Method result) {
		driver1.launchApp();
		hp = new HomePage(driver1);
	}

	@Test(priority = 1)
	public void verify_VerifyLoginAndCreateButton() throws Exception {
		try {
			Thread.sleep(10000);
			hp.clickOnSkipButton();
			extentTest = report.extentreport();
			extentTest.log(Status.PASS, "browser launched");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(priority = 2)
	public void verifyCreateAccount() throws Exception {
		// loadingWait("username");
		try {
			Thread.sleep(10000);
			hp.clickOnSkipButton();
			hp.verifyCreateAccountButton();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}