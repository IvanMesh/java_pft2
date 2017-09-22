package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ContactDelitionTests extends TestBase{
  protected FirefoxDriver wd;

  @Test
  public void testContactDelition() throws NullPointerException {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactDelition();
    app.getNavigationHelper().gotoHomePage();
  }
}
