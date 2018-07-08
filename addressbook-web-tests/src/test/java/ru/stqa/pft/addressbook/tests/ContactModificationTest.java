package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new NewContactData ("Test01", "Test02", null, null, null));
    }
      List<NewContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size() - 1);
      app.getContactHelper().initContactModification();
      NewContactData contact = new NewContactData(before.get(before.size() - 1).getId(),"Test01", "Test02", null, null, null);
      app.getContactHelper().fillNewContractForm(contact);
      app.getContactHelper().submitContactModification();
      app.getContactHelper().returnToHomePage();
      List<NewContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());

      before.remove(before.size() - 1);
      before.add(contact);
      Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }
  }
