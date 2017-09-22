package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDelitionTests extends TestBase{
  protected FirefoxDriver wd;

  @Test
  public void testContactDelition() throws NullPointerException {

    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null, null, "Slick", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDelition();
    app.getNavigationHelper().gotoHomePage();
  }
}
