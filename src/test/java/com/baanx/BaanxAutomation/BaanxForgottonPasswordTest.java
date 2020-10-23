package com.baanx.BaanxAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


/**
 * Automation testing for the forgotton passowrd page. After the user has inputted the email and pressed reset,
 * it will then send a email to the users email to reset the password.
 * @author dh11a
 *
 */
public class BaanxForgottonPasswordTest extends BaseClass {

	public static ExtentReports report;
	public static ExtentTest logger;


	@BeforeClass
	public void beforeClass(){
		report = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		//extent.addSystemInfo("Environment","Environment Name")
		report
		.addSystemInfo("Host Name", "Baanx Testing Report")
		.addSystemInfo("Environment", "Automation Testing")
		.addSystemInfo("User Name", "dhanyaal");
		//You could find the xml file below. Create xml file in your project and copy past the code mentioned below
		report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

		try {
			report = new ExtentReports("reports/BaanxForgottonPasswordTestReport.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
		report.flush();
	}

	@Test
	//	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	public static void 		BaanxForgottonPasswordTest() throws MalformedURLException, Throwable {
		logger = report.startTest("BaanxForgottonPasswordTest");

		// Calling the capabilities method from the base class. 
		AndroidDriver<AndroidElement> driver = Capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on login button
		driver.findElementByXPath("//android.widget.Button[@text='Login']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Login Button Clicked");

		// Clicking on Forgotten password? button
		driver.findElementByXPath("//android.widget.Button[@text='Forgotten password?']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Forgotten password? Button Clicked");


		// Inputting email address to change the passowrd
		driver.findElementById("com.baanx.baanx:id/email_address_input_et").sendKeys("dh11any@hotmail.com");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Email address entered");


		// Aftter inputting the email pressing the reset button.
		driver.findElementByXPath("//android.widget.Button[@text='Reset']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Reset Button Clicked");

		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "OK Button Clicked");
	}

}
