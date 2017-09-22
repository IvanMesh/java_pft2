package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTests {

  @Test
  public static void testRectangle() {

    Rectangle r = new Rectangle(4, 6);
    Assert.assertEquals(r.area(), 24.0);
  }

}
