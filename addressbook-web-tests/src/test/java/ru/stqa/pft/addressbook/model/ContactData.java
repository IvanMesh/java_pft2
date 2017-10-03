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

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            ", address='" + address + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (!lastname.equals(that.lastname)) return false;
    if (!address.equals(that.address)) return false;
    return group.equals(that.group);
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + lastname.hashCode();
    result = 31 * result + address.hashCode();
    result = 31 * result + group.hashCode();
    return result;
  }
}
