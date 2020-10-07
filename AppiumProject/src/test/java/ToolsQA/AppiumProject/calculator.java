package ToolsQA.AppiumProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


@Test
public class calculator {
    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "");
      //enter the deviceID and deviceName at the time of execution
        caps.setCapability("deviceName", "MI A3");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void add() {
         System.out.println("Calculator is open");
         System.out.println("Calculate sum of two numbers");
        driver.findElement(By.id("com.google.android.calculator:id/arrow")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
 		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
 		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
 		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
 		// Get the result text
 		String addOfNumbers = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
 		System.out.println(addOfNumbers);	
 	    //verify the result
 		Assert.assertEquals("14", addOfNumbers);
		}
    public void substract() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		// Get the result text
		String subOfNumbers = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println(subOfNumbers);	
	    //verify the result
		Assert.assertEquals("5", subOfNumbers);
		}
    public void multiply() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		// Get the result text
		String mulOfNumbers = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println(mulOfNumbers);	
	    //verify the result
		Assert.assertEquals("500", mulOfNumbers);
		}
    public void divide() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		// Get the result text
		String divOfNumbers = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println(divOfNumbers);	
	    //verify the result
		Assert.assertEquals("25", divOfNumbers);
		}
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}