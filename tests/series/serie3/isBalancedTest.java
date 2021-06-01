package series.serie3;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static series.serie3.TreeUtils.isBalanced;
import static series.serie3.TreeUtilsTest.*;

public class isBalancedTest {
    @Test
    public void isBalanced_empty_tree() {
        Node<Integer> tree = emptyBST();
        assertTrue(isBalanced(tree));
    }

    @Test
    public void isBalanced_singleNodeBST() {
        Node<Integer> tree = singleNodeBST();
        assertTrue(isBalanced(tree));
        tree = insert(tree, 0, CMP_NATURAL_ORDER);
        assertEquals(2, sizeTree(tree));
        assertTrue(isBalanced(tree));
        tree = insert(tree, 2, CMP_NATURAL_ORDER);
        assertEquals(3, sizeTree(tree));
        assertTrue(isBalanced(tree));
    }

    @Test
    public void isBalanced_populatedBST() {
        Node<Integer> tree = populatedBST();
        assertFalse(isBalanced(tree));
        tree = remove(tree, 3, CMP_NATURAL_ORDER);
        tree = remove(tree, 6, CMP_NATURAL_ORDER);
        tree = remove(tree, 7, CMP_NATURAL_ORDER);
        assertEquals(10, sizeTree(tree));
        assertTrue(isBalanced(tree));
    }

    @Test
    public void isBalanced_completeBST() {
        Node<Integer> tree = completeBST();
        assertTrue(isBalanced(tree));
        tree = remove(tree, 1, CMP_NATURAL_ORDER);
        tree = remove(tree, 5, CMP_NATURAL_ORDER);
        tree = remove(tree, 9, CMP_NATURAL_ORDER);
        tree = remove(tree, 13, CMP_NATURAL_ORDER);
        assertEquals(11, sizeTree(tree));
        assertTrue(isBalanced(tree));
        tree = remove(tree, 3, CMP_NATURAL_ORDER);
        tree = remove(tree, 7, CMP_NATURAL_ORDER);
        assertEquals(9, sizeTree(tree));
        assertTrue(isBalanced(tree));
        tree = remove(tree, 6, CMP_NATURAL_ORDER);
        tree = remove(tree, 2, CMP_NATURAL_ORDER);
        assertEquals(7, sizeTree(tree));
        assertFalse(isBalanced(tree));
    }

    static final Comparator<Integer> CMP_REVERSE_ORDER = (i1, i2) -> i2.compareTo(i1);

    static final Comparator<Integer> CMP_NATURAL_ORDER = (i1, i2) -> i1.compareTo(i2);

}






