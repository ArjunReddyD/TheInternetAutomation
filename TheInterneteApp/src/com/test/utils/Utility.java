package com.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
  WebDriver driver;

  public Utility(WebDriver driver) {
    this.driver = driver;
  }
  
/**
 * 
 * @param by
 * @param waitTime
 * @return
 */
  public WebElement isElementPresent(By by, int waitTime) {
    return (new WebDriverWait(driver, waitTime).until(ExpectedConditions
        .presenceOfElementLocated(by)));
  }
}
