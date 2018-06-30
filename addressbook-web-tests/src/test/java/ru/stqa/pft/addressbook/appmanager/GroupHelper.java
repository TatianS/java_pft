package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver wd) {
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
    Type(By.name("group_footer"), groupData.getFooter());
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
}
