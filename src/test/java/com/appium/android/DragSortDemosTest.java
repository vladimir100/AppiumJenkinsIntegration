package com.appium.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragSortDemosTest
{
	private AndroidDriver driver = null;

	@Before
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", System.getProperty("automationName"));
		capabilities.setCapability("platformVersion", System.getProperty("platformVersion"));
		capabilities.setCapability("deviceName", "ee29d84f");
		capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");
		capabilities.setCapability("appActivity", ".Launcher");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void dragAndDrop()
	{
		WebElement basicUsage = (WebElement) driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title"))
				.get(0);
		basicUsage.click();
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement first = (WebElement) driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(0);
		WebElement sixth = (WebElement) driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(5);
		TouchAction action = new TouchAction(driver);
		action.longPress(first).moveTo(sixth).release().perform();
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
}
