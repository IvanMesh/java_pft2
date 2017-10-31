package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTestsWithManualUserData extends TestBase{

  @Test (enabled = true)
  public void testContactCreation() {
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/photo.JPG");
    ContactData contact = new ContactData().withName("Ivan").withLastName("M").withAddress("Msk").withPhoto(photo)
            .inGroup(groups.iterator().next());
    app.goTO().homePage();
    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
