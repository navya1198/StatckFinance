package stack.finance.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReport {

	public ExtentHtmlReporter extentHtmlReporter;
	public ExtentTest extentTest;
	public ExtentReports extentReports;
	
	public ExtentTest extentreport()
	{
		Date date=new Date();
		SimpleDateFormat file=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String fileName=file.format(date);
		extentHtmlReporter=new ExtentHtmlReporter("C:\\AutomationFrameworkHeaderAndFooter\\StackFinanceAssignment\\Screenshot"+fileName+".html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
        		
		extentTest=extentReports.createTest(getClass().getSimpleName());
		
		return extentTest;
		
	}

	public void getFlush()
	{
		extentReports.flush();
	}

}
	
	
