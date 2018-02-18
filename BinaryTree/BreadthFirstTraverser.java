import java.util.Queue;
import java.util.ArrayDeque;

/**
 * Implementation of a level order traverser of TreeTraverser
 *
 * @author Neeraj Shah
 */
class BreadthFirstTraverser 
    implements TreeTraverser {

    private final Queue<Node> queue;

    public BreadthFirstTraverser() {
        queue = new ArrayDeque<>();
    }

    public void traverse(Node head, TreeVisitor visitor) {
        if(head == null) {
            return;
        }

        queue.add(head);

        while(queue.size() > 0) {

            Node node = queue.remove();

            visitor.visit(node);

            if(node.left != null)
                queue.add(node.left);

            if(node.right != null)
                queue.add(node.right);
        }
    }

}