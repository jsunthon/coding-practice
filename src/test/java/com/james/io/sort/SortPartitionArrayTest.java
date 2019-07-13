package com.james.io.sort;

import static org.junit.Assert.assertEquals;

import com.james.io.sort.SortPartitionArray.Student;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class SortPartitionArrayTest {

  private static final Student GREG = new Student(14, "Greg");
  private static final Student JOHN = new Student(12, "John");
  private static final Student ANDY = new Student(11, "Andy");
  private static final Student JIM = new Student(13, "Jim");
  private static final Student PHIL = new Student(12, "Phil");
  private static final Student BOB = new Student(13, "Bob");
  private static final Student CHIP = new Student(13, "Chip");
  private static final Student TIM = new Student(14, "Tim");

  private static final List<Student> list1 = Arrays.asList(GREG, JOHN, ANDY,
      JIM, PHIL, BOB, CHIP, TIM);

  @Test
  public void testSort() {
    final List<Student> expectedList = Arrays.asList(GREG, TIM, JOHN, PHIL, ANDY, JIM, BOB, CHIP);
    assertEquals(expectedList, SortPartitionArray.sort(list1));
  }

  @Test
  public void testSortEmpty() {
    assertEquals(Collections.emptyList(), SortPartitionArray.sort(Collections.emptyList()));
  }

  @Test
  public void testSortInPlace() {
    final List<Student> students = Arrays.asList(GREG, JOHN, PHIL, TIM);
    final List<Student> expectedStudents = Arrays.asList(PHIL, JOHN, GREG, TIM);
    SortPartitionArray.sortInPlace(students);
    assertEquals(expectedStudents, students);
  }

  @Test
  public void testSortInPlaceEmpty() {
    final List<Student> students = Collections.emptyList();
    SortPartitionArray.sortInPlace(students);
    assertEquals(Collections.emptyList(), students);
  }
}
