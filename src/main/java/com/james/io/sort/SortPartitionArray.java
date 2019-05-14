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

    /**
     * O(n) time, O(# of unique ages) space, but this space should be less
     * than O(n) since the # of unique ages is a lot less than the number of students
     * @param students  the students to student
     */
    public static void sortInPlace(List<Student> students) {
        if (!students.isEmpty()) {
            Map<Integer, Integer> ageToCount = getAgeToCount(students);
            Map<Integer, Integer> ageToOffset = getAgeToOffset(ageToCount);

            while (!ageToOffset.entrySet().isEmpty()) {
                Map.Entry<Integer, Integer> current = ageToOffset.entrySet().iterator().next();
                int toAge = students.get(current.getValue()).age;
                int toValue = ageToOffset.get(toAge);
                Collections.swap(students, toValue, current.getValue());

                Integer count = ageToCount.get(toAge) - 1;

                if (count > 0) {
                    ageToCount.put(toAge, count);
                    ageToOffset.put(toAge, ageToOffset.get(toAge) + 1);
                } else {
                    ageToOffset.remove(toAge);
                }
            }
        }
    }

    private static Map<Integer, Integer> getAgeToCount(List<Student> students) {
        Map<Integer, Integer> ageToCount = new HashMap<>();

        for (Student student: students) {
            if (ageToCount.containsKey(student.age)) {
                int count = ageToCount.get(student.age);
                ageToCount.put(student.age, count + 1);
            } else {
                ageToCount.put(student.age, 1);
            }
        }

        return ageToCount;
    }

    private static Map<Integer, Integer> getAgeToOffset(Map<Integer, Integer> ageToCount) {
        int offset = 0;
        final Map<Integer, Integer> ageToOffset = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : ageToCount.entrySet()) {
            ageToOffset.put(entry.getKey(), offset);
            offset += entry.getValue();
        }

        return ageToOffset;
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
