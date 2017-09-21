package ru.stqa.pft.sandbox;

public class Circle {
  int r;

  public Circle (int r) {
  this.r = r;
  }

  public double circle() {
    return 3.14 * (r * r);
  }
}
