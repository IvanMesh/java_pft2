package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  protected void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"),contactData.getEmail());
    type(By.name("email2"),contactData.getEmail2());
    type(By.name("email3"),contactData.getEmail3());
    attach(By.name("photo"), contactData.getPhoto());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByValue("[none]");
    }else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void delete(ContactData contact) {
    gotoHomePage();
    selectContactById(contact.getId());
    delete();
    contactCash = null;
    gotoHomePage();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void delete() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void selectModifiedContact() {
    wd.findElement(By.name("selected[]")).findElement(By.xpath("./../../td[8]/a/img")).click();
  }

  public void initContactModificationById(int id) {
    //wd.findElement(By.cssSelector("input[value='" + id + "']")).findElement(By.xpath("./../../td[8]/a/img")).click();
    //WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s'", id)));
    //WebElement row = checkbox.findElement(By.xpath("./../.."));
    //List<WebElement> cells = row.findElements(By.tagName("td"));
    //cells.get(7).findElement(By.tagName("a")).click();
    //wd.findElement(By.xpath(String.format("//input[@value='s']/../../td[8]/a", id))).click();
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value='s']]/td[8]/a", id))).click();
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void initContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean b) {
    gotoAddNewContact();
    fillContactForm(contact, b);
    submitContactCreation();
    contactCash = null;
    gotoHomePage();
  }

  public void modifyContactById(ContactData contact) {
    gotoHomePage();
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    initContactModification();
    contactCash = null;
    gotoHomePage();
  }

  public void gotoHomePage()  {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }

  public void gotoAddNewContact() {
    if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")) {
      return;
    }
    click(By.linkText("add new"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  private Contacts contactCash = null;

  public Contacts all() {
    if (contactCash != null) {
      return new Contacts(contactCash);
    }
    contactCash = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      String allMails = element.findElement(By.xpath(".//td[5]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();

      contactCash.add(new ContactData().withId(id).withName(firstname).withLastName(lastname).withAddress(address)
              .withAllPhones(allPhones));

    }
    return new Contacts(contactCash);
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    return new ContactData().withId(contact.getId()).withName(firstname).withLastName(lastname).withHomePhone(home).
            withMobilePhone(mobile).withWorkPhone(work);
  }
}
