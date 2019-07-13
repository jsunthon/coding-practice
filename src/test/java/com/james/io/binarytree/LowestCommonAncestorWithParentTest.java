package com.james.io.binarytree;

import static org.junit.Assert.assertEquals;

import com.james.io.binarytree.LowestCommonAncestorWithParent.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

public class LowestCommonAncestorWithParentTest {

  private BinaryTreeNode A;
  private BinaryTreeNode B;
  private BinaryTreeNode C;
  private BinaryTreeNode D;

  @Before
  public void setUp() {
    A = new BinaryTreeNode('A');
    B = new BinaryTreeNode('B');
    C = new BinaryTreeNode('C');
    D = new BinaryTreeNode('D');
  }


  @Test
  public void getLcaOfTwoRoot() {
    assertEquals(A, LowestCommonAncestorWithParent.getLca(A, A));
  }

  @Test
  public void getLcaOfSkewedTree() {
    B.parent = A;
    C.parent = B;
    assertEquals(A, LowestCommonAncestorWithParent.getLca(A, C));
  }

  @Test
  public void getLcaOfSkewedTreeLowerNodes() {
    B.parent = A;
    C.parent = B;
    assertEquals(B, LowestCommonAncestorWithParent.getLca(B, C));
  }

  @Test
  public void getLcaOfNormalTree() {
    B.parent = A;
    C.parent = A;
    assertEquals(A, LowestCommonAncestorWithParent.getLca(B, C));
  }

  @Test
  public void getLcaOfNormalTreeLowerNodes() {
    B.parent = A;
    C.parent = A;
    D.parent = C;
    assertEquals(A, LowestCommonAncestorWithParent.getLca(B, D));
  }
}