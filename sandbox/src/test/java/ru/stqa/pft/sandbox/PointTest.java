package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void testDistance0() {
    Point p = new Point(1.2, 3.4);
    double d = p.distance(p);
    Assert.assertEquals(d, 0.0);
  }

  @Test
  public void testDistance0s() {
    Point p = new Point(1.2, 3.4);
    double d = Point.distance(p, p);
    Assert.assertEquals(d, 0.0);
  }

  @Test
  public void testDistance1() {
    Point p = new Point(0, 0);
    double d = p.distance(new Point(0, 1));
    Assert.assertEquals(d, 1.0);
  }

  @Test
  public void testDistance1s() {
    double d = Point.distance(new Point(0, 0), new Point(0, 1));
    Assert.assertEquals(d, 1.0);
  }

  @Test
  public void testDistance5() {
    Point p = new Point(0, 0);
    double d = p.distance(new Point(0, 5));
    Assert.assertEquals(d, 5.0);

  }

  @Test
  public void testDistance5s() {
    Point p0 = new Point(0, 0);
    Point p = new Point(4, 3);
    double d = Point.distance(p0, p);
    Assert.assertEquals(d, 5.0);

  }
}
