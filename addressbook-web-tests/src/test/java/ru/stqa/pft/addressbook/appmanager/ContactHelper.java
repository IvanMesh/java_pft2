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
    type(By.name("email"),contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
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
    wd.findElement(By.cssSelector("input[value='" + id + "']")).findElement(By.xpath("./../../td[8]/a/img")).click();
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
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String allMails = element.findElement(By.xpath(".//td[5]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCash.add(new ContactData().withId(id).withName(firstname).withLastName(lastname).withAddress(address));
    }
    return new Contacts(contactCash);
  }
}
