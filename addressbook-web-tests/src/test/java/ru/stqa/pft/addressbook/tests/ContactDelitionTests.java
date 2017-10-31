package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactDelitionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTO().homePage();
    if (app.db().contacts().size() == 0) {
      app.contact().createWithOutPhoto(new ContactData().withName("test1").withLastName("Slick").withAddress("Meow"), true);
    }
  }

  @Test
  public void testContactDelition() throws NullPointerException {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertEquals(app.contact().count(), before.size() - 1);
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUi();
  }
}
