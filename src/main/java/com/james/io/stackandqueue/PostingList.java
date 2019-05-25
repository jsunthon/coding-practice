package com.james.io.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution to problem 9.5 of EPI
 */
public class PostingList {

    static class Posting {
        int order = -1;
        Posting next;
        Posting jump;

        Posting() {
            this(null, null);
        }

        Posting(Posting next, Posting jump) {
            this.next = next;
            this.jump = jump;
        }
    }

    public static void setOrder(Posting posting) {
        if (posting != null) {
            int order = 0; // the current order of the next posting
            final Deque<Posting> stack = new LinkedList<>();
            stack.addFirst(posting);
            Posting current;
            while (!stack.isEmpty()) {
                current = stack.removeFirst();
                if (current.order == -1) {
                    current.order = order++;
                    if (current.next != null && current.next.order == -1) {
                        stack.addFirst(current.next);
                    }
                    if (current.jump != null && current.jump.order == -1) {
                        stack.addFirst(current.jump);
                    }
                }
            }
        }
    }
}
