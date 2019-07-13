package com.james.io.binarytree.searchtree;

import static org.junit.Assert.assertEquals;

import com.james.io.binarytree.model.BinaryTreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class KLargestElementTest {

  private BinaryTreeNode ONE;
  private BinaryTreeNode TWO;
  private BinaryTreeNode THREE;
  private BinaryTreeNode FOUR;
  private BinaryTreeNode FIVE;

  private List<Integer> expectedResult;

  @Before
  public void setUp() {
    ONE = new BinaryTreeNode(1);
    TWO = new BinaryTreeNode(2);
    THREE = new BinaryTreeNode(3);
    FOUR = new BinaryTreeNode(4);
    FIVE = new BinaryTreeNode(5);

    TWO.left = ONE;
    TWO.right = FOUR;
    FOUR.left = THREE;
    FOUR.right = FIVE;

    expectedResult = Arrays.asList(5, 4, 3);
  }

  @Test
  public void getKLargestElements() {
    assertEquals(expectedResult, KLargestElement.getKLargestElements(TWO, 3));
  }

  @Test
  public void getKLargestElementsEpi() {
    assertEquals(expectedResult, KLargestElement.getKLargestElementsEpi(TWO, 3));
  }

  @Test
  public void getKLargestElementsEpiRecursive() {
    assertEquals(expectedResult, KLargestElement.getKLargestElementsEpiRecursive(TWO, 3));
  }
}