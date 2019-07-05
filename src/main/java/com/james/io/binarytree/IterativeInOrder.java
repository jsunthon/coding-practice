package com.james.io.binarytree;

import com.james.io.binarytree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 10.7 of EPI
 */
public class IterativeInOrder {

    public static List<Integer> inorder(BinaryTreeNode root) {
        List<Integer> traversed = new ArrayList<>();
        Deque<BinaryTreeNode> deque = new LinkedList<>();
        BinaryTreeNode curr = root;

        while (!deque.isEmpty() || curr != null) {
            if (curr != null) {
                deque.addFirst(curr);
                curr = curr.left;
            } else {
                BinaryTreeNode top = deque.removeFirst();
                traversed.add(top.value);
                curr = top.right;
            }
        }

        return traversed;
    }
}
