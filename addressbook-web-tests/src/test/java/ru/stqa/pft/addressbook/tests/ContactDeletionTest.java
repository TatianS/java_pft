package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.Set;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new NewContactData().withFirstName("Test01"));
    }
  }

  @Test
  public void testContactDeletion() {
    Set<NewContactData> before = app.contact().all();
    NewContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<NewContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}
