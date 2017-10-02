package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", null, null, "Slick", "test1"), true);
    }
    app.getContactHelper().selectModifiedContact(before - 1);
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "test3", "test4", null), false);
    app.getContactHelper().initContactModification();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }

}
