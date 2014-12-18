package the.internet.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.test.utils.Utility;

public class TheInternateBase {

  public static WebDriver driver;
  public static Utility utility;

  @BeforeSuite
  public void beforeSuite() {
    String BROWSER = System.getProperty("browser", "firefox");
    System.out.println("BROWSER >>>>>> " + System.getProperty("browser"));
    if (BROWSER.equals("firefox")) {
      driver = new FirefoxDriver();
    } else if (BROWSER.equals("chrome")) {
      String path = "lib/chromedriver";
      if (System.getProperty("os.name").contains("Windows")) {
        path = "lib/chromedriver.exe";
      }
      System.setProperty("webdriver.chrome.driver", path);
      driver = new ChromeDriver();
    } else if (BROWSER.equals("ie")) {
      DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
      capabilities
          .setCapability(
              InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
              true);
      String path = "lib/IEDriverServer.exe";
      System.setProperty("webdriver.ie.driver", path);
      driver = new InternetExplorerDriver();
    } else {
      throw new RuntimeException("Browser type unsupported");
    }
    driver.get("http://the-internet.herokuapp.com/");
    driver.manage().window().maximize();
    utility = new Utility(driver);
  }

  @AfterSuite
  public void afterSuite() {
    // close browser
    driver.quit();
  }

  protected static WebDriver getDriver() {
    return driver;
  }

  protected static Utility getUtility() {
    return utility;
  }
}
