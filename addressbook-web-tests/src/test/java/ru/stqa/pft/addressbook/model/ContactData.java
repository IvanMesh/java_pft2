package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String address;

  public ContactData(String name, String lastname, String address) {
    this.name = name;
    this.lastname = lastname;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }
}
