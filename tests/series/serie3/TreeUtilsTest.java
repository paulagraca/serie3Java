package series.serie3;

import java.util.Comparator;

public class TreeUtilsTest {

    public static <E> int sizeTree(Node<E> root) {
        if (root == null) return 0;
        else return 1 + sizeTree(root.left) + sizeTree(root.right);
    }

    public static <E> void preorder(Node<E> root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static <E> void inorder(Node<E> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    public static <E> void postorder(Node<E> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static <E> Node<E> minimum(Node<E> root) {
        if (root.left == null) return root;
        else return minimum(root.left);
    }

    public static <E> Node<E> maximum(Node<E> root) {
        if (root.right == null) return root;
        else return maximum(root.right);
    }

    public static <E> Node<E> search(Node<E> root, E key, Comparator<E> cmp) {
        if (root == null || cmp.compare(key, root.value) == 0) return root;
        else if (cmp.compare(key, root.value) < 0)
            return search(root.left, key, cmp);
        else return search(root.right, key, cmp);
    }

    public static <E> Node<E> insert(Node<E> root, E e, Comparator<E> cmp) {
        if (root == null) { // not found, insert
            root = new Node<E>();
            root.value = e;
        }
        else if (cmp.compare(e, root.value) < 0)
            root.left = insert(root.left, e, cmp);
        else root.right = insert(root.right, e, cmp);
        return root;
    }

    public static <E> Node<E> remove(Node<E> root, E e, Comparator<E> cmp) {
        if (root == null) return root;
        else {
            if (cmp.compare(e, root.value) < 0)
                root.left = remove(root.left, e, cmp);
            else if (cmp.compare(e, root.value) > 0)
                root.right = remove(root.right, e, cmp);
            else { // found, delete it
                if (root.left == null) root = root.right;
                else if (root.right == null) root = root.left;
                else {
                    Node<E> y = minimum(root.right);
                    root.value = y.value;
                    root.right = remove(root.right, y.value, cmp);
                }
            }
            return root;
        }
    }

    /*
    Create BSTs using Ints
     */

    private static class NodeComparator implements Comparator<Integer>{
        public int compare(Integer o1, Integer o2) {
            if (o1 != null && o2 != null) return o1 - o2;
            else return 0;
        }
    }

    public static Node<Integer> emptyBST() {
        Node<Integer> tree = null;
        return tree;
    }

    public static Node<Integer> singleNodeBST() {
        int[] nodes = {1};
        Node<Integer> tree = null;
        for (int i = 0; i < nodes.length; i++)
            tree = insert(tree, nodes[i], new NodeComparator());
        return tree;
    }

    public static Node<Integer> leftChildsBST() {
        int[] nodes = {5, 4, 3, 2, 1};
        Node<Integer> tree = null;
        for (int i = 0; i < nodes.length; i++)
            tree = insert(tree, nodes[i], new NodeComparator());
        return tree;
    }

    public static Node<Integer> rightChildsBST() {
        int[] nodes = {1, 2, 3, 4, 5};
        Node<Integer> tree = null;
        for (int i = 0; i < nodes.length; i++)
            tree = insert(tree, nodes[i], new NodeComparator());
        return tree;
    }

    public static Node<Integer> populatedBST() {
        int[] nodes = {10, 4, 1, 8, 5, 6, 7, 0, 2, 3, 9, 12, 11};
        Node<Integer> tree = null;
        for (int i = 0; i < nodes.length; i++)
            tree = insert(tree, nodes[i], new NodeComparator());
        return tree;
    }

    public static Node<Integer> subPopulatedBST() {
        int[] nodes = {10, 4, 1, 8, 12, 11};
        Node<Integer> tree = null;
        for (int i = 0; i < nodes.length; i++)
            tree = insert(tree, nodes[i], new NodeComparator());
        return tree;
    }

    public static Node<Integer> completeBST() {
        int[] nodes = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        Node<Integer> tree = null;
        for (int i = 0; i < nodes.length; i++)
            tree = insert(tree, nodes[i], new NodeComparator());
        return tree;
    }
}

















