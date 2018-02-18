
/**
 * A simple representation of a node in a Binary tree
 *
 * @author Neeraj Shah
 * @since 1986
 */
class Node {

    /**
     * Value holded by this node
     */
    int value;

    /**
     * Left child of this node
     */
    Node left;

    /**
     * Right child of this node
     */
    Node right;

    Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}