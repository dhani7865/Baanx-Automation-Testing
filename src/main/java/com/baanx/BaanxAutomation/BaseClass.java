package com.baanx.BaanxAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	AndroidDriver<AndroidElement> driver;

	@SuppressWarnings("unchecked")
	public static AndroidDriver<AndroidElement> Capabilities(Object device) throws MalformedURLException {
		// Getting the file from the src folder
		File f = new File("Resources");
		File fs = new File(f, "bnx-prod.apk");

		DesiredCapabilities cap = new DesiredCapabilities();

		if (device.equals("emulator")) {
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "dhanyaal");
			// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung
			// SM-A105FN");

		} else if (device.equals("real")) {
			// Connected devices:
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		// Android Ui automator
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		cap.setCapability(MobileCapabilityType.VERSION, "9.0");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		// cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		return driver;

	}
}