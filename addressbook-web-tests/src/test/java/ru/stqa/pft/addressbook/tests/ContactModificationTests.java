package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectModifiedContact();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "test3", "test4", null), false);
    app.getContactHelper().initContactModification();
    app.getNavigationHelper().gotoHomePage();
  }

}
