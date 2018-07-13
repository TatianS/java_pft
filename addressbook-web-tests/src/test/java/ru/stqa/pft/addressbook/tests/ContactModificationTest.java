package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;

import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new NewContactData().withFirstName("Test01"));
    }
  }

  @Test
  public void testContactModification() {
      Contacts before = app.contact().all();
      NewContactData modifiedContact = before.iterator().next();
      NewContactData contact = new NewContactData()
              .withId(modifiedContact.getId()).withFirstName("Test01").withLastName("Test02");
      app.contact().modify(contact);
      Contacts after = app.contact().all();
      assertEquals(after.size(), before.size());

    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
