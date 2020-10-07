package ToolsQA.AppiumProject;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class activityOne {
	AppiumDriver<MobileElement> driver = null;
  @Test
  @BeforeTest
  public void beforeClass() throws MalformedURLException {
      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceId", "");
    //enter the deviceID and deviceName at the time of execution
      caps.setCapability("deviceName", "MI A3");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.chrome");
      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
  }
  @Test
  public void testSearchAppium() throws IOException {
      String timeStamp;
      File screenShotName;
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("https://www.training-support.net/");
      String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
      System.out.println("Title on Homepage: " + pageTitle);
      File scrFile = driver.getScreenshotAs(OutputType.FILE);
      screenShotName = new File("src/test/PageTitle.jpg");
      // This will copy the screenshot to the file created
      FileUtils.copyFile(scrFile, screenShotName);
      //Set filepath for image
      String filePath = "../"+screenShotName.toString();
      //Set image HTML in the report
      String path = "<img src='"+ filePath +"'/>";
      //Show image in report
      Reporter.log(path);
      MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@content-desc='About Us']");
      aboutButton.click();
      String newPageTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();
      System.out.println("Title on new page: " + newPageTitle);
      File scrFile1 = driver.getScreenshotAs(OutputType.FILE);
      screenShotName = new File("src/test/AboutUs.jpg");
      // This will copy the screenshot to the file created
      FileUtils.copyFile(scrFile1, screenShotName);
      //Set filepath for image
      String filePath1 = "../"+screenShotName.toString();
      //Set image HTML in the report
      String path1 = "<img src='"+ filePath1 +"'/>";
      //Show image in report
      Reporter.log(path1);
      // Assertions
      Assert.assertEquals(pageTitle, "Training Support");
      Assert.assertEquals(newPageTitle, "About Us");
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
