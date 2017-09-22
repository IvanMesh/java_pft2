package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTests {

  @Test
  public void testTriangle () {

    Triangle t = new Triangle(3, 4, 5);
    Assert.assertEquals(t.geron(), (t.a * t.b) / 2);
  }
}
