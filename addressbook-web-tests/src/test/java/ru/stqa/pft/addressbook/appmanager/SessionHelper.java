package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase{

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    Type(By.name("user"), username);
    Type(By.name("pass"), password);
    Click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
