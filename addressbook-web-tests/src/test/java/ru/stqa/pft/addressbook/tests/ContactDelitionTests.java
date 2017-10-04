package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDelitionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTO().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("test1").withLastName("Slick").withAddress("Meow"), true);
    }
  }

  @Test
  public void testContactDelition() throws NullPointerException {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(after, before);
  }
}
