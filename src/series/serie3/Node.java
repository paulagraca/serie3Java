package series.serie3;

// Class Node
public class Node<E> {
    Node<E> left;
    Node<E> right;
    E value;

    public Node() { }
    public Node(E e) {
        this.value = e;
    }
}

