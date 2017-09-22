package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoAddNewContact();
    app.getContactHelper().createContact(new ContactData("Ivan", "M", "Msk", "Slick", "test1"), true);
  }
}
