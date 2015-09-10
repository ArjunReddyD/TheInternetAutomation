package the.internet.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.test.utils.Utility;

public class TheInternetTests extends TheInternateBase {

  private WebDriver driver;
  private Utility utility;

  private By by = By.id("a");
  private java.lang.String path = ".//*[@id='content']/ul";

  @BeforeSuite
  public void setTestSuite() {
    this.driver = super.getDriver();
    this.utility = super.getUtility();
  }

  /*
   * Start Writing test cases here.
   */
  @Test(priority = 1, description = "Checking for login")
  public void AbTest() { 
    // ((JavascriptExecutor) driver).executeScript("window.focus();");
    // for (String handle : driver.getWindowHandles()) {
    // driver.switchTo().window(handle);
    // }
    
    // List<WebElement> elements = driver.findElements(By
    // .xpath(".//*[@id='content']/ul"));
    utility.isElementPresent(by, 120);
    List<WebElement> topElement = driver.findElements(By.xpath(path));
    topElement.get(0).findElement(By.xpath(".//li[1]/a")).click();
    WebElement AbEle = (new WebDriverWait(driver, 10).until(ExpectedConditions
        .presenceOfElementLocated(By.xpath(".//*[@id='content']/div/h3"))));
    // Assert.assertEquals(AbEle.getText(), "A/B Test Control");
    driver.navigate().back();
  }

  @Test(enabled = false, priority = 2, description = "After loging land on Page")
  public void BasicAuth() {
    driver.findElement(By.xpath(path + "/li[2]/a")).click();
    // try {
    // Robot robot = new Robot();
    // robot.keyPress(KeyEvent.VK_ESCAPE);
    // } catch (AWTException e) {
    // e.printStackTrace();
    // }

    WebElement nextPageEle = (new WebDriverWait(driver, 10)
    .until(ExpectedConditions.presenceOfElementLocated(By
        .xpath("html/body"))));
    // Assert.assertEquals(nextPageEle.getText(), "Not authorized");
    driver.navigate().back();
  }

  @Test(priority = 3, description = "Select Setting")
  public void brokenImage() throws InterruptedException {
    driver.findElement(By.xpath(path + "/li[3]/a")).click();
    WebElement brokenImage = (new WebDriverWait(driver, 10)
    .until(ExpectedConditions.presenceOfElementLocated(By
        .xpath(".//*[@id='content']/div/img[3]"))));
    driver.navigate().back();
  }
/**
 * 
 * @throws InterruptedException
 */
  @Test(priority = 4)
  private void changingDom() throws InterruptedException {
    driver.findElement(By.xpath(path + "/li[4]/a")).click();
    // WebElement fooBtn = (new WebDriverWait(driver, 10)
    // .until(ExpectedConditions.presenceOfElementLocated(By
    // .id(".//*[@id='content']/div/img[3]"))));
    driver.navigate().back();
  }
}
