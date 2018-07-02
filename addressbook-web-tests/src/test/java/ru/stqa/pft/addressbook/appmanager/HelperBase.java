package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void Click(By locator) {
    wd.findElement(locator).click();
  }

  protected void Type(By locator, String text) {
    Click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void contactType(By contactLocator, String text) {
    contactClick(contactLocator);
    wd.findElement(contactLocator).clear();
    wd.findElement(contactLocator).sendKeys(text);
  }

  public void contactClick(By contactLocator) {
    wd.findElement(contactLocator).click();
  }
}
