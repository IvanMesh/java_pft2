package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ContactPhoneTests extends TestBase{

  @Test
  public  void testContactPhones() {
    app.goTO().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHomePhone(), equalTo(cleaned(contactFromEditForm.getHomePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactFromEditForm.getWorkPhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaned(contactFromEditForm.getMobilePhone())));
  }
    public String cleaned (String allPhones) {
      return allPhones.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
