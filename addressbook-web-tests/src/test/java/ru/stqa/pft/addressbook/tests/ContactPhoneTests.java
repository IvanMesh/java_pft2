package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

//Перед тестом включить в контактхелпере нужный код метода publick Contact

public class ContactPhoneTests extends TestBase{

  @Test (enabled = true)
  public  void testContactPhones() {
    app.goTO().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactFromEditForm)));

  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()).stream()
            .filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned (String allPhones) {
      return allPhones.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
