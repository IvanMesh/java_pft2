package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDelitionTests extends TestBase{
  protected FirefoxDriver wd;

  @Test
  public void testContactDelition() throws NullPointerException {

    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null, null, "Slick", "test1"), true);
    }
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactDelition();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}
