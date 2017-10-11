package ru.stqa.pft.addressbook.Generators;

import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getName(), contact.getLastname(), contact.getHomePhone()
      , contact.getMobilePhone(), contact.getWorkPhone(), contact.getEmail(), contact.getEmail2(), contact.getEmail3()
      ,contact.getAddress()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts (int count) {
    List<ContactData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withName(String.format("name %s", i)).withLastName(String.format("lastname %s", i))
              .withHomePhone(String.format("111 %s", i)).withMobilePhone(String.format("222 %s", i))
      .withWorkPhone(String.format("333 %s", i)).withEmail(String.format("email@%s.ru", i)).withEmail2(String.format("email2@%s.com", i))
      .withEmail3(String.format("email3@%s.ru", i)).withAddress(String.format("address %s", i)));
    }
    return contacts;
  }
}
