package series.serie3;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static series.serie3.TreeUtils.removeGreaterThan;
import static series.serie3.TreeUtilsTest.*;

public class RemoveGreaterThanTest {
    @Test
    public void removeGreaterThan_empty_tree() {
        Node<Integer> tree = emptyBST();
        assertNull(removeGreaterThan(tree, 1, CMP_NATURAL_ORDER));
    }

    @Test
    public void removeGreaterThan_singleNodeBST() {
        Node<Integer> tree = singleNodeBST();
        assertNull(removeGreaterThan(tree, 0, CMP_NATURAL_ORDER));
        tree = removeGreaterThan(tree, 1, CMP_NATURAL_ORDER);
        assertTrue(search(tree, 1, CMP_NATURAL_ORDER) != null);
    }

    @Test
    public void removeGreaterThan_leftChildsBST() {
        Node<Integer> tree = leftChildsBST();
        tree = removeGreaterThan(tree, 5, CMP_NATURAL_ORDER);
        assertEquals(5, sizeTree(tree));
        assertNull(removeGreaterThan(tree, 0, CMP_NATURAL_ORDER));
    }

    @Test
    public void removeGreaterThan_rightChildsBST() {
        Node<Integer> tree = rightChildsBST();
        tree = removeGreaterThan(tree, 5, CMP_NATURAL_ORDER);
        assertEquals(5, sizeTree(tree));
        assertNull(removeGreaterThan(tree, 0, CMP_NATURAL_ORDER));
    }

    @Test
    public void removeGreaterThan_populatedBST() {
        Node<Integer> tree = populatedBST();
        tree = removeGreaterThan(tree, 5, CMP_NATURAL_ORDER);
        assertEquals(6, sizeTree(tree));
        for (int i = 0; i <= 5; i++)
            assertTrue(search(tree, i, CMP_NATURAL_ORDER) != null);
        tree = removeGreaterThan(tree, 0, CMP_NATURAL_ORDER);
        assertEquals(1, sizeTree(tree));
    }

    static final Comparator<Integer> CMP_REVERSE_ORDER = (i1, i2) -> i2.compareTo(i1);

    static final Comparator<Integer> CMP_NATURAL_ORDER = (i1, i2) -> i1.compareTo(i2);

}








