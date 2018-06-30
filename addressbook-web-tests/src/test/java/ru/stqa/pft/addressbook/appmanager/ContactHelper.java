package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    contactClick(By.xpath("//div/div[4]/div/i/a[2]"));
  }

  public void submitNewContractCreation() {
    contactClick(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContractForm(NewContactData newContactData) {
    contactType(By.name("firstname"), newContactData.getFirstName());
    contactType(By.name("lastname"), newContactData.getLastName());
    contactType(By.name("home"), newContactData.getHomeTelephoneNumber());
    contactType(By.name("email"), newContactData.getEmail());
  }

  public void initNewContactCreation() {
    contactClick(By.linkText("add new"));
  }

}
