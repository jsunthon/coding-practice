package com.james.io.sort;

import java.util.Objects;

/**
 * Problem 14.9 of EPI
 */
public class FastSortArraySolution {

    static class ListNode<T> {
        T data;
        ListNode<T> next;

        ListNode(T data) {
            this(data, null);
        }

        ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{ data: " + data + ", next: " + next + " }";
        }

        @Override
        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }

            return ((ListNode<?>) object).data.equals(data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }

    /**
     * O(n^2) time in the case of a reverse sorted list, O(1) space
     * @param head
     * @return  the head of the sorted list
     */
    public static ListNode<Integer> sort(ListNode<Integer> head) {
        ListNode<Integer> dummyHead = new ListNode<>(0, head);
        ListNode<Integer> current = head;
        ListNode<Integer> target;
        ListNode<Integer> pre;
        while (current != null && current.next != null) {
            if (current.data > current.next.data) {
                target = current.next;
                pre = dummyHead;
                while (pre.next.data < target.data) {
                    pre = pre.next;
                }
                ListNode<Integer> temp = pre.next;
                pre.next = target;
                current.next = target.next;
                target.next = temp;
            } else {
                current = current.next;
            }
        }

        return dummyHead.next;
    }
}
