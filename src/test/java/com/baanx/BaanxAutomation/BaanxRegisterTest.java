package com.baanx.BaanxAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

// Public class, which extends the base class using the extends keyword. 
public class BaanxRegisterTest extends BaseClass {

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
			report = new ExtentReports("reports/BaanxRegisterTestReport.html");
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
	public static void BaanxRegisterTest() throws MalformedURLException, Throwable {

		logger = report.startTest("BaanxRegisterTest");

		// Calling the capabilities method from the base class. 
		AndroidDriver<AndroidElement> driver = Capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// path id classname, androidUIautomater
		/* XPath Syntax 
		 *tagname[@attribute = 'value']
		 */
		// Text is a unique attribute which can be used to identify the Register x path. 
		driver.findElementByXPath("//android.widget.Button[@text='Register']").click();
		logger.log(LogStatus.PASS, "Register Button Clicked");

		// Inputting referral code HASHPRIX2020
		driver.findElementById("com.baanx.baanx:id/code_input_et").sendKeys("HASHPRIX2020");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Referral code entered");

		driver.findElementByXPath("//android.widget.Button[@text='Validate']").click();
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "Validate Button Clicked");

		// Continue with no promo code
		//		driver.findElementByXPath("//android.widget.Button[@text='continue_no_promo_code_btn']").click();
		//		Thread.sleep(5000);

		// Inputting email
		driver.findElementById("com.baanx.baanx:id/email_address_input").sendKeys("dh11any+1@hotmail.com");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Email address entered");

		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Continue Button Clicked");

		// Clicking on accept to accept the terms and conditions
		driver.findElementByXPath("//android.widget.Button[@text='Accept']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Accept Button Clicked");


		// Inputting password
		driver.findElementById("com.baanx.baanx:id/password_input").sendKeys("Password66!");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Password entered");

		driver.findElementById("com.baanx.baanx:id/confirm_password_input").sendKeys("Password66!");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Confirm Password entered");

		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Continue Button Clicked");

		// Selecting title
		driver.findElementByXPath("//android.widget.TextView[@text='Mr']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "MR Text view Button Clicked");

		//		driver.findElementByXPath("//android.widget.TextView[@text='Miss']").click();
		//		Thread.sleep(3000);
		//		driver.findElementByXPath("//android.widget.TextView[@text='Ms']").click();
		//		Thread.sleep(3000);
		//		driver.findElementByXPath("//android.widget.TextView[@text='Mrs']").click();
		//		Thread.sleep(3000);
		//		driver.findElementByXPath("//android.widget.TextView[@text='Dr']").click();
		//		Thread.sleep(3000);
		//		driver.findElementByXPath("//android.widget.TextView[@text='Prof']").click();
		//		Thread.sleep(3000);
		//		driver.findElementByXPath("//android.widget.TextView[@text='Prof']").click();
		//		Thread.sleep(3000);
		//		driver.findElementByXPath("//android.widget.TextView[@text='Other']").click();
		//		Thread.sleep(3000);

		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Continue Button Clicked");


		// Clicking on gender
		driver.findElementByXPath("//android.widget.TextView[@text='Male']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "male Text view Button Clicked");


		//		driver.findElementByXPath("//android.widget.TextView[@text='Female']").click();
		//		Thread.sleep(3000);
		//		
		//		driver.findElementByXPath("//android.widget.TextView[@text='Other']").click();
		//		Thread.sleep(3000);

		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Continue Button Clicked");


		// Input first name
		driver.findElementById("com.baanx.baanx:id/firstname_input").sendKeys("dhanyaal");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "First name entered");

		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Continue Button Clicked");

		// Input second name
		driver.findElementById("com.baanx.baanx:id/lastname_input").sendKeys("rashid");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Last name entered");

		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Continue Button Clicked");


		// Input date of birth
		driver.findElementById("com.baanx.baanx:id/dob_input").sendKeys("09/07/1995");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Date Of Birth entered");

		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Continue Button Clicked");

		// Enter address details
		driver.findElementById("com.baanx.baanx:id/addressLine_input_1").sendKeys("94");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Address 1 entered");

		// Street
		driver.findElementById("com.baanx.baanx:id/addressLine_input_2").sendKeys("Wellington road");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Address 2 entered");

		// Town
		driver.findElementById("com.baanx.baanx:id/town_or_city_input").sendKeys("Oldham");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Town or City entered");

		// Postcode
		driver.findElementById("com.baanx.baanx:id/postcode_input").sendKeys("OL8 1RR");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Post Code entered");

		//		// United kingdom
		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Continue Button Clicked");

		//		driver.findElementByXPath("//android.view.ViewGroup").click();

		//		driver.findElementById("com.baanx.baanx:id/title_tv").sendKeys("United Kingdom");
		//		Thread.sleep(3000);

		// Inputting phone number
		// Postcode
		driver.findElementById("com.baanx.baanx:id/phone_input").sendKeys("07982871086");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Phone Number entered");

		driver.findElementByXPath("//android.widget.Button[@text='Verify Phone Number']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Verify Phone Number Button Clicked");

		// 2fa code
		// wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.baanx.baanx:id/login_2fa_input")));
		//		driver.findElementById("com.baanx.baanx:id/send_code_btn").click();
		//		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		Thread.sleep(1000);
		logger.log(LogStatus.PASS, "OK Button Clicked");

		driver.findElementById("com.baanx.baanx:id/code_input").sendKeys("1131");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "2FA Code entered");

		driver.findElementByXPath("//android.widget.Button[@text='Confirm']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Confirm Button Clicked");


		report.endTest(logger);
	}

}
