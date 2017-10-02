package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getNavigationHelper().gotoAddNewContact();
    app.getContactHelper().createContact(new ContactData("Ivan", "M", "Msk", "Slick", "test1"), true);
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}
