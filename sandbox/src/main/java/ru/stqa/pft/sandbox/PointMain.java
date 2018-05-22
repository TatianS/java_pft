package ru.stqa.pft.sandbox;

public class PointMain {
  public static void main(String[] args) {
    double d1 = Point.distance(new Point(0, 0), new Point(0, 1));
    double d2 = Point.distance(new Point(1, 1), new Point(-1, -1));
    double d3 = new Point(0,3).distance(new Point(4,0));
    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d3);
  }
}
