package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {

    app.goTO().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withName("Ivan").withLastName("M").withAddress("Msk").withGroup("test1");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
  }
}
