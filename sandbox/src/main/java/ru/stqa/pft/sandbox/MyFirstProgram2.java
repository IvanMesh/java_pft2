package ru.stqa.pft.sandbox;

public class MyFirstProgram2 {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Ivan");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Плащадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p1 = new Point(0, 0);
    Point p2 = new Point(7, 4);
    System.out.println("Расстояние между точками р1 и р2 = " + p1.distance(p2));

    Circle x = new Circle( 4);
    
    System.out.println("Площадь круга с радиусом " + x.r + " = " + x.circle());

    Triangle t = new Triangle(2, 4, 3);
    System.out.println("Площадь треугальника со стронами " + " a " + " b " + " c " + " = " + t.geron());
  }

  public static void hello(String somebody) {

    System.out.println("Hello, " + somebody + "!");
  }
}