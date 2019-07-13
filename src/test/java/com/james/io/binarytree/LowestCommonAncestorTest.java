package com.james.io.binarytree;

import static org.junit.Assert.assertEquals;

import com.james.io.binarytree.model.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

public class LowestCommonAncestorTest {

  private BinaryTreeNode A;
  private BinaryTreeNode B;
  private BinaryTreeNode C;
  private BinaryTreeNode D;
  private BinaryTreeNode E;

  @Before
  public void setUp() {
    A = new BinaryTreeNode(0);
    B = new BinaryTreeNode(1);
    C = new BinaryTreeNode(2);
    D = new BinaryTreeNode(3);
    E = new BinaryTreeNode(4);
  }

  @Test
  public void getLca0() {
    A.left = D;
    A.right = E;

    assertEquals(A, LowestCommonAncestor.getLca(A, D, E));
  }

  @Test
  public void getLca1() {
    D.right = E;

    assertEquals(D, LowestCommonAncestor.getLca(D, D, E));
  }

  @Test
  public void getLca2() {
    A.left = B;
    A.right = C;

    B.left = D;
    B.right = E;

    assertEquals(B, LowestCommonAncestor.getLca(A, D, E));
  }

  @Test
  public void getLca3() {
    A.left = B;
    A.right = C;

    B.left = D;
    C.right = E;

    assertEquals(A, LowestCommonAncestor.getLca(A, D, E));
  }
}