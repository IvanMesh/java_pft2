package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {

    app.getNavigationHelper().gotoAddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Иван", "Мещеряков", "МО, Такой то город, такой то дом.", "Nick", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }
}