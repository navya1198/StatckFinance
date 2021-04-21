package stack.finance.pages;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import stack.finance.Base.BaseClass;


public class HomePage extends BaseClass {


	public HomePage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
		
	}

	@AndroidFindBy(id = "Skip")
	MobileElement skipButton;
	
	@AndroidFindBy(id = "Proceed")
	MobileElement proceedButton;
	
	@AndroidFindBy(id = "Get Your Money Right.")
	MobileElement getYourMoney;
	
	@AndroidFindBy(id = "Create an Account")
	MobileElement creatAccountButton;
	
	@AndroidFindBy(id = "Login")
	MobileElement loginButton;
	
	@AndroidFindBy(id = "Continue with Email")
	MobileElement continueWithEmail;
	
	@AndroidFindBy(id = "Continue with Google")
	MobileElement continueWithGoogle;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='First Name']")
	MobileElement firstName;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Last Name']")
	MobileElement lastName;
	@AndroidFindBy(className = "//android.widget.EditText[@text='Email Address']")
	MobileElement emailAddress;
	@AndroidFindBy(className = "//android.widget.EditText[@text='Password']")
	MobileElement password;
	@AndroidFindBy(className = "//android.widget.EditText[@text='Confirm Password']")
	MobileElement confirmPassword;
	

	public void clickOnSkipButton() throws InterruptedException {
		skipButton.click();
		System.out.println("Skip is clicked");
		Thread.sleep(3000);
		if(loginButton.isDisplayed() && creatAccountButton.isDisplayed())
		{
			System.out.println(getYourMoney.getText());
			getYourMoney.getText().equals("Get Your Money Right");
			creatAccountButton.click();
			System.out.println("LoginButton and CreateAccountButton is Displayed");
		}
		else
			System.out.println("FAIL");
	
	}

	public void verifyCreateAccountButton() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		if(continueWithEmail.isDisplayed() && continueWithGoogle.isDisplayed())
		{   
			System.out.println("LoginButton and CreateAccountButton is Displayed");
			continueWithEmail.isDisplayed();
			continueWithEmail.click();
			firstName.sendKeys("Navya");
			lastName.sendKeys("A");
			emailAddress.sendKeys("Navyaprabh@gmail.com");
			password.sendKeys("Password@1");
			confirmPassword.sendKeys("Password@1");
			System.out.println("All the details entered Successfully");
			proceedButton.click();
			
		}
		else
			System.out.println("FAIL");
	}
	
}
