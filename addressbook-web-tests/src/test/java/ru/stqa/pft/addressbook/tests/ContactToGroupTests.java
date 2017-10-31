package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroupTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTO().homePage();
    if (app.db().contacts().size() == 0) {
      app.contact().createWithOutPhoto(new ContactData().withName("test1").withLastName("Slick").withAddress("Meow"), true);
    }
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("test1").withHeader("test").withFooter("test"));
    }
  }

  @Test
  public void testContactToGroup() {

    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();

    GroupData group = groups.iterator().next();
    ContactData contact = contacts.iterator().next();

    app.goTO().homePage();
    app.contact().selectContactById(contact.getId());
    app.contact().addContactToGroup(group.getId());
    Contacts contactAfter = app.db().contacts();
    assertThat(contactAfter, equalTo(contacts.withAdded(contact.inGroup(group))));
  }
}
