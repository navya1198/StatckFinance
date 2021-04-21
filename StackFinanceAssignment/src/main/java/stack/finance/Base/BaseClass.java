package stack.finance.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import stack.finance.reports.ExtentReport;


public class BaseClass {

	public AppiumDriver driver;
	public static AndroidDriver driver1;
	ExtentReport rep = new ExtentReport();
	static Properties prop;

	public static int TotalCount = 0;
	public static int countPass = 0;
	public static int countFail = 0;
	public static int status = 0;


	public AndroidDriver<MobileElement> setUP_Android(String pName, String pVersion, String devicename, String url)
			throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, pVersion);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, pName);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		capabilities.setCapability("appActivity", "co.stackfinance.stackfinanceapp.MainActivity");
		capabilities.setCapability("appPackage", "co.stackfinance.stackfinanceapp");
		URL url1 = new URL(url);
		driver1 = new AndroidDriver(url1, capabilities);
		System.out.println("App launched");
		return driver1;
	}

	@BeforeSuite
	public void beforeSuite() throws Exception {
		System.out.println("App Launched");
	}

	@AfterClass
	public void afterclass() {
		// System.out.println("After Class");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Total TestCases : " + TotalCount);
		System.out.println("Total Passed : " + countPass);
		System.out.println("Total Failed : " + countFail);
		rep.getFlush();
	}

	public AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

}
