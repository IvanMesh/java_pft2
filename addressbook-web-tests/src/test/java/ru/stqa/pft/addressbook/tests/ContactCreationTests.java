package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContactsFromCsv() throws IOException {
    File photo = new File("src/test/resources/photo.JPG");
    List<Object[]> list = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))) {
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[]{new ContactData().withName(split[0]).withLastName(split[1]).withHomePhone(split[2])
              .withMobilePhone(split[3]).withWorkPhone(split[4]).withEmail(split[5]).withEmail2(split[6]).withEmail3(split[7])
              .withAddress(split[8]).withPhoto(photo)});
      line = reader.readLine();
    }
    return list.iterator();
  }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {

    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {

        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test (dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) {

    app.goTO().homePage();
    Contacts before = app.db().contacts();
    app.contact().create(contact, true);
    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    verifyContactListInUi();
  }
}
