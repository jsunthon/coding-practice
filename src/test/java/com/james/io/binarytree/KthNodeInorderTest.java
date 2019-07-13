package com.james.io.binarytree;

import static org.junit.Assert.assertEquals;

import com.james.io.binarytree.KthNodeInorder.TreeSizeAwareBinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

public class KthNodeInorderTest {

  private TreeSizeAwareBinaryTreeNode one;
  private TreeSizeAwareBinaryTreeNode two;
  private TreeSizeAwareBinaryTreeNode three;
  private TreeSizeAwareBinaryTreeNode four;
  private TreeSizeAwareBinaryTreeNode five;
  private TreeSizeAwareBinaryTreeNode eight;

  @Before
  public void setup() {
    one = new TreeSizeAwareBinaryTreeNode(1);

    two = new TreeSizeAwareBinaryTreeNode(2);

    three = new TreeSizeAwareBinaryTreeNode(3);
    eight = new TreeSizeAwareBinaryTreeNode(8);

    three.setRight(eight);

    four = new TreeSizeAwareBinaryTreeNode(4);
    five = new TreeSizeAwareBinaryTreeNode(5);

    two.setLeft(four);
    two.setRight(five);

    one.setLeft(two);
    one.setRight(three);
  }

  @Test
  public void getKthNodeInOrderBeg() {
    assertEquals(four, KthNodeInorder.getKthNodeInOrder(one, 1));
  }

  @Test
  public void getKthNodeInOrderMid() {
    assertEquals(five, KthNodeInorder.getKthNodeInOrder(one, 3));
  }

  @Test
  public void getKthNodeInOrderEnd() {
    assertEquals(eight, KthNodeInorder.getKthNodeInOrder(one, 6));
  }
}