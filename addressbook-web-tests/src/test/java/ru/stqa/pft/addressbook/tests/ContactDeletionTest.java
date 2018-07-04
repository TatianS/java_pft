package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().fillNewContractForm((new NewContactData("Test01", "Test02", "123", "123@mail.com", null)));
    }
      app.getContactHelper().deleteContact();
  }
}
