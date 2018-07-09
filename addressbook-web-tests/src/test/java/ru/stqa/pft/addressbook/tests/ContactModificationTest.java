package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.Set;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new NewContactData().withFirstName("Test01"));
    }
  }

  @Test
  public void testContactModification() {
      Set<NewContactData> before = app.contact().all();
      NewContactData modifiedContact = before.iterator().next();
      NewContactData contact = new NewContactData()
              .withId(modifiedContact.getId()).withFirstName("Test01").withLastName("Test02");
      app.contact().modify(contact);
      Set<NewContactData> after = app.contact().all();
      Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before,after);
    }
}
