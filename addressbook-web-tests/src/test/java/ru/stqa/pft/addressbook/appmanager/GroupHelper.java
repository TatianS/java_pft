package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    Click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    Click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    Type(By.name("group_name"), groupData.getName());
    Type(By.name("group_header"), groupData.getHeader());

    if (isElementPresent(By.name("group_footer"))) {
      Type(By.name("group_footer"), groupData.getFooter());
    }
  }

  public void initGroupCreation() {
    Click(By.name("new"));
  }

  public void deleteSelectedGroup() {
    Click(By.name("delete"));
  }

  public void selectGroup() {
    Click(By.name("selected[]"));
  }

  public void initGroupModification() {
    Click(By.name("edit")); }

  public void submitGroupModification() {
    Click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresented(By.name("selected[]"));
  }

  public void deleteGroup() {
    selectGroup();
    deleteSelectedGroup();
    returnToGroupPage();
  }
}
