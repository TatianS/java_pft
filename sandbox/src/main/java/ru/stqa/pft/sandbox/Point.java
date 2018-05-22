package ru.stqa.pft.sandbox;

public class Point {
  private double x;
  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point p1, Point p2) {
    double dx = p1.x - p2.x, dy = p1.y - p2.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public double distance (Point p) {
    double dx = p.x - x, dy = p.y - y;
    return Math.sqrt(dx * dx + dy * dy);
  }
}
