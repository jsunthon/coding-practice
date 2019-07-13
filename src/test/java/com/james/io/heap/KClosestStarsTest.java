package com.james.io.heap;

import static org.junit.Assert.assertEquals;

import com.james.io.heap.KClosestStars.Point;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class KClosestStarsTest {

  @Test
  public void kClosest() {
    Point pt1 = new Point(3.0, 4.0, 5.0);
    Point pt2 = new Point(6.0, 8.0, 10.0);
    Point pt3 = new Point(12.0, 16.0, 20.0);
    Point pt4 = new Point(24.0, 32.0, 40.0);

    List<Point> unsorted = Arrays.asList(pt3, pt4, pt1, pt2);
    List<Point> sorted = Arrays.asList(pt1, pt2);
    assertEquals(sorted, KClosestStars.kClosest(unsorted, 2));
  }
}