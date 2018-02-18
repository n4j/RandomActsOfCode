/**
 * Implementation of a BinaryTree, an element which is less than head go to the left side and gretate than head
 * goes to right hand side. This class also exposes Visitor pattern based methods to print tree in In-Order
 * and in Level Order
 *
 * @author Neeraj Shah
 * @since 1986
 */
class BinaryTree {

    private Node head;

    private int numNodes = 0;

    BinaryTree() { }

    private Node createNode(int value, Node left, Node right) {
        return new Node(value, left, right);
    }

    private void insert(int value, Node node) {
        if(value <= node.value) {
            if(node.left != null) {
                insert(value, node.left);
            } else {
                node.left = createNode(value, null, null);
            }
        } else {
            if(node.right != null) {
                insert(value, node.right);
            } else {
                node.right = createNode(value, null, null);
            }
        }
    }

    public void insert(int value) {
        ++numNodes;
        if(head == null) {
            head = createNode(value, null, null);
            return;
        }
        insert(value, head);
    }

    public void printTreeDepthFirst() {
        new DepthFirstTraverser()
            .traverse(head,
                (node)->{ System.out.println(node.value); }
            );
    }

    public void printTreeBreadthFirst() {
        new BreadthFirstTraverser()
            .traverse(head,
                (node)->{ System.out.println(node.value); }
            );
    }

    public void printNodes() {
        new BreadthFirstTraverser()
            .traverse(head,
                (node)->{ 
                    if(node!=null && node.left == null && node.right == null)
                        System.out.println(node.value);
                }
            );
    }

}