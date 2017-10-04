package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDelitionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTO().homePage();
    if (! app.contact().isThereAContact()) {
      app.contact().create(new ContactData("test1", null, null, "Slick", "test1"), true);
    }
  }

  @Test
  public void testContactDelition() throws NullPointerException {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().select(index);
    app.contact().delete();
    app.goTO().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(after, before);
  }
}
