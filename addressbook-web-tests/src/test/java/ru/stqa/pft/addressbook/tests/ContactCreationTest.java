package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().createContact(new NewContactData ("Test01", "Test02", "123", null, null));
  }
}