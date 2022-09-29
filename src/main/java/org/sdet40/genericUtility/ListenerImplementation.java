package org.sdet40.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener
{
	private ExtentReports reports;
	private ExtentTest test;
	public static ExtentTest stest;
	private ExtentSparkReporter spark;
	@Override   //BT
	public void onStart(ITestContext context)
	{
	    spark = new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Title-sdet40");
		spark.config().setReportName("Report Name - sdet40");
		spark.config().setTheme(Theme.DARK);
		
		 reports = new ExtentReports();
		 reports.attachReporter(spark);
		 reports.setSystemInfo("Author", "Harinath");
		 reports.setSystemInfo("OS", "win 10");
		 reports.setSystemInfo("Browser", "chrome");	
	}
	@Override   //BM
	public void onTestStart(ITestResult result)
	{
		 test = reports.createTest(result.getMethod().getMethodName());
		 stest = test;
	/*	 Report report = spark.getReport();
		 System.out.println(report);  */
		 
		
	}

	@Override    //AM
	public void onTestSuccess(ITestResult result) 
	{
		 test.pass(result.getMethod().getMethodName()+" pass");
		
	}

	@Override  //AM
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getMethod().getMethodName()+" fail");
		test.fail(result.getThrowable());
		 try {
			new WebdriverUtility().screenShot(BaseClass.sdriver, BaseClass.sjavaUtility, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override  //AM
	public void onTestSkipped(ITestResult result) {

		test.skip(result.getMethod().getMethodName()+" skip");
		test.skip(result.getThrowable());
	}

	@Override   //AM
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
		
	}

	@Override   //AT
	public void onFinish(ITestContext context) {

		
			reports.flush();
		
	}
	
		

}
