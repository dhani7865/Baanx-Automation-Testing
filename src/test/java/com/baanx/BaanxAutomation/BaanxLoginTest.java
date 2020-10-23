package com.baanx.BaanxAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.istack.internal.logging.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import sun.launcher.LauncherHelper;

// Public class, which extends the base class using the extends keyword. 
public class BaanxLoginTest extends BaseClass {

	public static ExtentReports report;
	public static  ExtentTest logger;

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
			report = new ExtentReports("reports/BaanxLoginTestReport.html");
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
	public static void BaanxLoginTest() throws MalformedURLException, Throwable {

		logger = report.startTest("BaanxLoginTest");

		// Calling the capabilities method from the base class.
		AndroidDriver<AndroidElement> driver = Capabilities("emulator");
		// AndroidDriver<AndroidElement> driver = Capabilities("real");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.Button[@text='Login']").click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Login Button Clicked");

		driver.findElementById("com.baanx.baanx:id/email_address_input").sendKeys("dh11any@hotmail.com");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Email address entered");


		driver.findElementById("com.baanx.baanx:id/password_input").sendKeys("Password66!");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Password entered");

		driver.findElementById("com.baanx.baanx:id/login_btn").click();
		// wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.baanx.baanx:id/login_2fa_input")));
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "Login button clicked");

		driver.findElementById("com.baanx.baanx:id/send_code_btn").click();
		logger.log(LogStatus.PASS, "Send code button clicked");
		Thread.sleep(1000);


		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		Thread.sleep(5000);
		System.out.println("Waitng for user to enter 2FA code");
		logger.log(LogStatus.INFO, "Waitng for user to enter 2FA code");
		report.endTest(logger);
		System.out.println("Enter 2FA code in console: ");
		Scanner sc = new Scanner(System.in);

		String input2FA = sc.next();

		System.out.println("Entered value of 2FA is: " + input2FA);
		logger.log(LogStatus.INFO, "Entered value of 2FA is: " + input2FA);
		Thread.sleep(30000);

		driver.findElementById("com.baanx.baanx:id/login_2fa_input").sendKeys(input2FA);

		Thread.sleep(30000);
		System.out.println("Now user is clicking on continue button");
		logger.log(LogStatus.PASS, "Now user is clicking on continue button");

		driver.findElementById("com.baanx.baanx:id/continue_btn").click();

		System.out.println("Now user is on dashboard");
		Thread.sleep(30000);report.endTest(logger);
		System.out.println("Now user is clicking on continue button");
		Thread.sleep(30000);
		System.out.println("Now user is clicking on continue button");
		Thread.sleep(30000);
		System.out.println("Now user is clicking on continue button");



		report.endTest(logger);

	}

}
