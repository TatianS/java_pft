package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initNewContactCreation();
    app.getContactHelper().fillNewContractForm(new NewContactData("Test01", "Test02", "123", "123@mail.com"));
    app.getContactHelper().submitNewContractCreation();
    app.getContactHelper().returnToHomePage();
  }
}