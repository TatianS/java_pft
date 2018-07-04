package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    if (isElementPresented(By.id("maintable"))){
      return;
    }
    contactClick(By.linkText("home page"));
  }

  public void submitNewContractCreation() {
    contactClick(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillNewContractForm(NewContactData newContactData) {
    contactType(By.name("firstname"), newContactData.getFirstName());
    contactType(By.name("lastname"), newContactData.getLastName());
    contactType(By.name("home"), newContactData.getHomeTelephoneNumber());
    contactType(By.name("email"), newContactData.getEmail());

    if (isElementPresent(By.name("group"))) {
      new Select(wd.findElement(By.name("group"))).selectByVisibleText(newContactData.getGroup());
    }
  }

  public void initNewContactCreation() {
    contactClick(By.linkText("add new"));
  }

  public void initContactModification() {
    contactClick(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    contactClick(By.name("update"));
  }

  public void deleteSelectedContact() {
    contactClick(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void returnToHomePageAfterContactDeleted(){
    contactClick(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresented(By.name("selected[]"));
  }

  public void createContact (NewContactData contact) {
    initNewContactCreation();
    fillNewContractForm(new NewContactData("Test01", "Test02", "123", null, null));
    submitNewContractCreation();
    returnToHomePage();
  }

  public void deleteContact() {
    initContactModification();
    deleteSelectedContact();
    returnToHomePageAfterContactDeleted();
  }
}
