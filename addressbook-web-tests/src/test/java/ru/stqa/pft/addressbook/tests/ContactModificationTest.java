package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new NewContactData ("Test01", "Test02", "123", null, null));
    }
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillNewContractForm(new NewContactData("Test01", "Test02", "123", "123@mail.com", null));
      app.getContactHelper().submitContactModification();
      app.getContactHelper().returnToHomePage();
    }
  }
