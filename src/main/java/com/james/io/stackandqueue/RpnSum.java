package com.james.io.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution to problem 9.2 of EPI
 */
public class RpnSum {

    private final Deque<Integer> stack;

    public RpnSum() {
        stack = new LinkedList<>();
    }

    public int sum(String expr) {
        if (expr.isEmpty()) {
            return -1;
        }
        final String[] tokens = expr.split(",");
        Integer x;
        Integer y;
        for (String token : tokens) {
            if (!(isOperator(token))) {
                stack.addFirst(Integer.parseInt(token));
            } else {
                y = stack.removeFirst();
                x = stack.removeFirst();
                stack.addFirst(sum(x, y, token));
            }
        }

        return stack.removeFirst();
    }

    private boolean isOperator(String op) {
        return op.equals("x")
                || op.equals("/")
                || op.equals("+")
                || op.equals("-");
    }

    private int sum(Integer x, Integer y, String op) {
        int res;

        switch(op) {
            case "x":
                res = x * y;
                break;
            case "/":
                res = x / y;
                break;
            case "+":
                res = x + y;
                break;
            case "-":
                res = x - y;
                break;
            default:
                throw new IllegalArgumentException("Malformed RPN: " + op);
        }

        return res;
    }
}
