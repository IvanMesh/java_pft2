package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String name;
  private final String lastname;
  private final String address;
  private final String nickname;
  private final String group;
  private String homePhone;
  private String email;

  public ContactData(String name, String lastname, String address, String nickname, String group) {
    this.id = 0;
    this.name = name;
    this.lastname = lastname;
    this.address = address;
    this.nickname = nickname;
    this.group = group;
  }

  public ContactData(int id, String name, String lastname, String address, String nickname, String group) {
    this.id = id;
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

  public int getId() {
    return id;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getEmail() {
    return email;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return address != null ? address.equals(that.address) : that.address == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    return result;
  }
}
