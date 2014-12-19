package the.internet.app;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NextStepMove extends TheInternateBase {

  private WebDriver driver;
  private String path = ".//*[@id='content']/ul";

  private By colunmA = By.id("column-a");
  private By colunmB = By.id("column-b");
  private By dropdown = By.id("dropdown");
  private By dynamicContentPath = By
      .xpath(".//*[@id='content']/div[@class='example']/div[@class='row']");
  private By exm1 = By.xpath(".//*[@id='content']/div/a[1]");
  private By exm2 = By.xpath(".//*[@id='content']/div/a[2]");
  private By startBtn = By.xpath(".//*[@id='start']/button");

  @BeforeSuite
  public void setTestSuite() {
    this.driver = super.getDriver();
  }

  private void landOnTestpage(int pageNo) {
    driver.findElement(By.xpath(path + "/li[" + pageNo + "]/a")).click();
  }

  @AfterMethod
  private void backTOmainpage() {
    driver.navigate().back();
  }

  @Test(priority = 4)
  private void changingDom() throws InterruptedException {
    landOnTestpage(5);
    System.out.println("changin dome");
    List<WebElement> cssEle = driver.findElements(By
        .cssSelector("input[type='checkbox']"));
    for (WebElement ele : cssEle) {
      if (!ele.isSelected()) {
        ele.click();
      } else
        ele.click();
    }
  }

  @Test(priority = 5)
  private void contextMenuSelection() {
    landOnTestpage(6);
    System.out.println("context menu selected");
    WebElement contextMenu = driver.findElement(By.id("hot-spot"));
    Actions action = new Actions(driver);
    action.contextClick(contextMenu).sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.RETURN).build().perform();
    // Get a handle to the open alert, prompt or confirmation
    Alert alert = driver.switchTo().alert();
    // Get the text of the alert or prompt
    System.out.println(alert.getText());
    // And acknowledge the alert (equivalent to clicking "OK")
    alert.accept();
  }

  @Test(priority = 6)
  private void dragNDrop() {
    landOnTestpage(8);
    System.out.println("drag n drop");
    Actions builder = new Actions(driver);

    builder.clickAndHold(driver.findElement(colunmA));
    builder.moveToElement(driver.findElement(colunmB));
    builder.perform();
    builder.release(driver.findElement(colunmB));
    builder.perform();
    builder.click();
    // (new Actions(driver)).dragAndDrop(driver.findElement(colunmA),
    // driver.findElement(colunmB)).perform();

    // Assert.assertEquals(driver.findElement(colunmA).getText(), "B");
    // Assert.assertEquals(driver.findElement(colunmB).getText(), "A");
  }

  @Test(priority = 7)
  private void dropDownOption() {
    landOnTestpage(9);
    System.out.println("drop down");
    org.openqa.selenium.support.ui.Select dropDown = new org.openqa.selenium.support.ui.Select(
        driver.findElement(dropdown));
    dropDown.selectByVisibleText("Option 1");
    dropDown.selectByVisibleText("Option 2");
  }

  @Test(priority = 8)
  private void dynamicContent() {
    landOnTestpage(10);
    List<WebElement> dynamicContent = driver.findElements(dynamicContentPath);
    for (WebElement webElement : dynamicContent) {
      System.out.println("\n" + webElement.getText() + "\n");
    }
  }

//  @Test(priority = 9,enabled=false)
//  private void dynamicContentLoad() {
//    landOnTestpage(11);
//    driver.findElement(exm1).click();
//    driver.findElement(startBtn).click();
//    WebElement wait1 = (new WebDriverWait(driver, 40).until(ExpectedConditions
//        .visibilityOf(driver.findElement(By.xpath(".//*[@id='finish']/h4")))));
//    System.out.println(wait1.getText());
//    driver.navigate().back();
//    driver.findElement(startBtn).click();
//    driver.findElement(exm2).click();
//    WebElement wait2 = (new WebDriverWait(driver, 30).until(ExpectedConditions
//        .visibilityOfElementLocated(By.xpath(".//*[@id='finish']/h4"))));
//    System.out.println(wait2.getText());
//  }
}
