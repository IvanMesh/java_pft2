package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testArea() {
    Point p1 = new Point(3, 1);
    Point p2 = new Point(7, 4);
    Assert.assertEquals(p1.distance(p2), 5.0);
  }
  @Test
  public void testArea1() {
    Point p1 = new Point(3, 1);
    Point p2 = new Point(7, 4);
    Assert.assertEquals(p1.distance(p2),  7);
  }
  @Test
  public void testArea2() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(1, 1);
    Assert.assertEquals(p1.distance(p2), 0.0);
  }

}


