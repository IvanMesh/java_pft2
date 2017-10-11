package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTestsWithPhoto extends TestBase{

  @Test (enabled = false)
  public void testContactCreation() {

    app.goTO().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/photo.JPG");
    ContactData contact = new ContactData().withName("Ivan").withLastName("M").withAddress("Msk").withGroup("test1").withPhoto(photo);
    app.contact().create(contact, true);
    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
