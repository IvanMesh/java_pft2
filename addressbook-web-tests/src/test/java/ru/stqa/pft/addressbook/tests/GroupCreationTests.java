package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroopCreation() {

    app.goTO().GroupPage();
    Set<GroupData> before = app.group().all();
    app.group().initGroupCreation();
    GroupData group = new GroupData().withName("test1");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
  }

}
