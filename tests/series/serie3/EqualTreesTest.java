package series.serie3;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static series.serie3.TreeUtils.equalTrees;
import static series.serie3.TreeUtilsTest.*;

public class EqualTreesTest {
    @Test
    public void equalTrees_empty_trees() {
        Node<Integer> tree = emptyBST();
        assertTrue(equalTrees(tree, tree));
    }

    @Test
    public void equalTrees_singleNodeBST() {
        Node<Integer> tree = singleNodeBST();
        Node<Integer> treeEmpty = emptyBST();
        assertTrue(equalTrees(tree, tree));
        assertFalse(equalTrees(tree, treeEmpty));
        assertFalse(equalTrees(treeEmpty, tree));
        Node<Integer> tree2 = insert(treeEmpty, 2, CMP_NATURAL_ORDER);
        assertFalse(equalTrees(tree, tree2));
    }

    @Test
    public void equalTrees_leftRightChildsBST() {
        Node<Integer> treeL = leftChildsBST();
        Node<Integer> treeR = rightChildsBST();
        assertTrue(equalTrees(treeL, treeL));
        assertTrue(equalTrees(treeR, treeR));
        assertFalse(equalTrees(treeL, treeR));
    }

    @Test
    public void equalTrees_differentValuesBST() {
        Node<Integer> tree1 = emptyBST();
        tree1 = insert(tree1,2, CMP_NATURAL_ORDER);
        tree1 = insert(tree1,1, CMP_NATURAL_ORDER);
        tree1 = insert(tree1,3, CMP_NATURAL_ORDER);
        Node<Integer> tree2 = emptyBST();
        tree2 = insert(tree2,5, CMP_NATURAL_ORDER);
        tree2 = insert(tree2,4, CMP_NATURAL_ORDER);
        tree2 = insert(tree2,6, CMP_NATURAL_ORDER);
        assertFalse(equalTrees(tree1, tree2));
    }

    @Test
    public void equalTrees_populatedBST() {
        Node<Integer> tree = populatedBST();
        Node<Integer> treeSub = subPopulatedBST();
        assertTrue(equalTrees(tree, tree));
        assertTrue(equalTrees(treeSub, treeSub));
        assertFalse(equalTrees(tree, treeSub));
        Node<Integer> tree2 = populatedBST();
        tree2 = remove(tree2, 7, CMP_NATURAL_ORDER);
        assertFalse(equalTrees(tree, tree2));
    }

    static final Comparator<Integer> CMP_REVERSE_ORDER = (i1, i2) -> i2.compareTo(i1);

    static final Comparator<Integer> CMP_NATURAL_ORDER = (i1, i2) -> i1.compareTo(i2);

}

















