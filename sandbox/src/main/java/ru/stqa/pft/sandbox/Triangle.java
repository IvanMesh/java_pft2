package ru.stqa.pft.sandbox;

public class Triangle {
  //Вычислить по формуле Герона :
  //S=√​p⋅(p−a)⋅(p−b)⋅(p−c)​​​
  //p=(a+b+c) / 2 - полупериметр треугольника; a,b,c - стороны треугольника.
  double a;
  double b;
  double c;
  double s;
  double p;
  public Triangle(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public double geron() {
    p = (a + b + c) / 2;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
  }
}
