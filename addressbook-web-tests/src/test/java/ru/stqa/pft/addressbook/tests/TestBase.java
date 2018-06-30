package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
    public void tearDown() {
    app.stop();
  }

  public class ApplicationManager extends ru.stqa.pft.addressbook.appmanager.ApplicationManager {
  }
}
