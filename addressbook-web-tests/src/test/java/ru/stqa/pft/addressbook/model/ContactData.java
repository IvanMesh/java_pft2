package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastname;
  private final String address;
  private String nickname;
  private String homePhone;
  private String email;

  public ContactData(String name, String lastname, String address, String nickname) {
    this.name = name;
    this.lastname = lastname;
    this.address = address;
    this.nickname = nickname;
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

  public String getNickname() {
    return nickname;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail() {
    return email;
  }

}
