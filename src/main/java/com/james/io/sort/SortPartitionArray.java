package com.james.io.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Solution to 14.7:
 * <p>
 * Given an array with many repeated students, sort the array so that
 * students of the same age are adjacent to each other.
 */
public class SortPartitionArray {

    private SortPartitionArray() {
    }

    static final class Student {
        final int age;
        final String name;

        Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }

            if (!(other instanceof Student)) {
                return false;
            }

            Student otherStudent = (Student) other;

            return this.age == otherStudent.age && this.name.equals(otherStudent.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        @Override
        public String toString() {
            return "{ age: " + age + ", name: " + name + " }";
        }
    }

    public static void sortInPlace(List<Student> students) {
        throw new AssertionError();
    }

    /**
     * O(n) time, O(n) space
     * @param students the students to sort
     * @return  the list of students sorted
     */
    public static List<Student> sort(List<Student> students) {
        if (students.isEmpty()) {
            return Collections.emptyList();
        }

        final Map<Integer, List<Student>> ageStudentMap = new LinkedHashMap<>();

        List<Student> currentStudents;
        for (Student student : students) {
            currentStudents = ageStudentMap.get(student.age);

            if (currentStudents == null) {
                currentStudents = new ArrayList<>();
                ageStudentMap.put(student.age, currentStudents);
            }

            currentStudents.add(student);
        }

        return ageStudentMap.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
