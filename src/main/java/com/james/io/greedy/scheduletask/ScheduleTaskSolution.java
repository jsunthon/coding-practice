package com.james.io.greedy.scheduletask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution for problem 18.1 of EPI
 */
public class ScheduleTaskSolution {
    public static class Assignment {
        public Integer task1;
        public Integer task2;

        public Assignment(Integer task1, Integer task2) {
            this.task1 = task1;
            this.task2 = task2;
        }

        @Override
        public String toString() {
            return "{" + " task1: " + task1 + ", task2: " + task2 + " }";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (!(o instanceof Assignment)) {
                return false;
            }

            Assignment other = (Assignment) o;

            return task1.equals(other.task1) && task2.equals(other.task2);
        }
    }

    public static List<Assignment> getSchedule(List<Integer> tasks) {
        List<Assignment> schedule = new ArrayList<>(tasks.size() / 2); // O(n/2) = O(n) space
        Collections.sort(tasks); // O(n log n) time, O(lg n) space
        int i = 0;
        int j = tasks.size() - 1;
        // O(n/2) -> O(n) time
        while (i < j) {
            schedule.add(new Assignment(tasks.get(i), tasks.get(j)));
            i++;
            j--;
        }
        return schedule;
    }
}
