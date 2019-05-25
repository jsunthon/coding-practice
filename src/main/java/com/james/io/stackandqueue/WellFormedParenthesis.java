package com.james.io.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution to problem 9.3 in EPI
 */
public class WellFormedParenthesis {

    private WellFormedParenthesis() {}

    private static final String ILLEGAL_CHAR_MSG = "Invalid char: %s";

    static boolean isWellFormed(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        Character potentialLeft;
        for (char c : s.toCharArray()) {
            if (isLeft(c)) {
                stack.addFirst(c);
            } else if (isRight(c)) {
                potentialLeft = stack.peekFirst();
                if (potentialLeft != null && isMatchForRight(c, potentialLeft)) {
                    stack.removeFirst();
                } else {
                    return false;
                }
            } else {
                throw new IllegalArgumentException(String.format(ILLEGAL_CHAR_MSG, c));
            }
        }

        return stack.isEmpty();
    }

    private static boolean isLeft(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    private static boolean isRight(char c) {
        return c == '}' || c == ']' || c == ')';
    }

    private static boolean isMatchForRight(char right, char potentialLeft) {
        char left;
        switch (right) {
            case ']':
                left = '[';
                break;
            case ')':
                left = '(';
                break;
            case '}':
                left = '{';
                break;
            default:
                throw new IllegalArgumentException(String.format(ILLEGAL_CHAR_MSG, right));
        }

        return potentialLeft == left;
    }
}
