package com.yikids;

import com.yikids.util.PropertyLoader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Base class for all the TestNG-based test classes
 */
public class TestNgTestBase {

  //public static String baseUrl;
  protected WebDriver driver;
  protected String gridHubUrl;
  protected String baseUrl;

  @BeforeTest
  public void init() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

    Capabilities capabilities = PropertyLoader.loadCapabilities();

    driver = WebDriverFactory.getDriver(capabilities);
    //driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    if (driver != null) {
      WebDriverFactory.dismissDriver(driver);
      // driver.quit();
    }
  }
}
