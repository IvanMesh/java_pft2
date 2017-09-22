package ru.stqa.pft.addressbook.model;

public class ContactData {
  private String name;
  private String lastname;
  private String address;
  private String nickname;
  private String group;
  private String homePhone;
  private String email;

  public ContactData(String name, String lastname, String address, String nickname, String group) {
    this.name = name;
    this.lastname = lastname;
    this.address = address;
    this.nickname = nickname;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getGroup() {
    return group;
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
