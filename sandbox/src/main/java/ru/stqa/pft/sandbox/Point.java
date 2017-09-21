package ru.stqa.pft.sandbox;

public class Point {

  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }


  public double distance(Point p2) {
    double qx = this.x - p2.x;
    double qy = this.y - p2.y;
    return Math.sqrt(qx * qx + qy * qy);
  }
}
