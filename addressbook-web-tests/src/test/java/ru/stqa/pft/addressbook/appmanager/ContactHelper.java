package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.List;

@SuppressWarnings("WeakerAccess")
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

  public void initNewContactCreation(int id) {
    contactClick(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
  }

  public void initContactModification(int index) {
    wd.findElement(By.xpath("//a[@href='edit.php?id="+ index +"']/img[@title='Edit']")).click();
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

  public void create(NewContactData contact) {
    initNewContactCreation(contact.getId());
    fillNewContractForm(contact);
    submitNewContractCreation();
    returnToHomePage();
  }

  public void modify(NewContactData contact) {
    initContactModification(contact.getId());
    fillNewContractForm(contact);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(NewContactData contact) {
    selectContactById(contact.getId());
    initContactModification(contact.getId());
    deleteSelectedContact();
    returnToHomePageAfterContactDeleted();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String firstname = element.findElement((By.xpath(".//td[3]"))).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      NewContactData contact = new NewContactData().withId(id).withFirstName(firstname).withLastName(lastname);
      contacts.add(contact);
    }
    return contacts;
  }
}