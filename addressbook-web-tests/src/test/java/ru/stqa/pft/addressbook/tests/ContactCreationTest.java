package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    List<NewContactData> before = app.getContactHelper().getContactList();
    NewContactData contact = new NewContactData ("Test01", "Test02", "123", null, null);
    app.getContactHelper().createContact(contact);
    List<NewContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }
}