package com.browser.experiment;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.browser.experiment.util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected static String browser;
  protected static String version;
  protected static String platform;
  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static String driverPath;
  protected static String pageTitle;
  protected static DesiredCapabilities capabilities;

  protected WebDriver driver;

  @BeforeSuite
  public void initTestSuite() throws IOException {
	browser = PropertyLoader.loadProperty("browser");
    version = PropertyLoader.loadProperty("browser.version");
    platform = PropertyLoader.loadProperty("platform");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    baseUrl = PropertyLoader.loadProperty("base.url");
    pageTitle = PropertyLoader.loadProperty("page.title");


    System.out.println("browser = " + browser);
    System.out.println("browser.version = " + version);
    System.out.println("platform = " + platform);
    System.out.println("pageTitle = " + pageTitle);
    
    
    capabilities = new DesiredCapabilities(browser, version, Platform.fromString(platform));
    
    System.out.println("capabilities = " + capabilities.toString());
  }

  @BeforeMethod
  public void initWebDriver() {
	
	try {
		System.out.println("gridHubUrl = " + gridHubUrl);
		driver = new RemoteWebDriver(new URL(gridHubUrl),capabilities);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
  }
  
  

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
	  driver.quit();
  }
}
