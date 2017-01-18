package com.browser.experiment;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.browser.experiment.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
  	System.out.println("baseURL = " + baseUrl);
    driver.get(baseUrl);
    Assert.assertTrue("Google".equals(homepage.getTitle()));
    System.out.println("homepage.getTitle() = " + homepage.getTitle());
  }
}
