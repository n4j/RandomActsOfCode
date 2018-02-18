import java.util.Queue;
import java.util.ArrayDeque;

/**
 * Impl Depth first traver
 */
class DepthFirstTraverser 
    implements TreeTraverser {

    private final ArrayDeque<Node> queue;

    public DepthFirstTraverser() {
        queue = new ArrayDeque<>();
    }

    public void traverse(Node head, TreeVisitor visitor) {
        if(head == null || visitor == null) {
            return;
        }

        queue.add(head);

        while(queue.size() > 0) {

            Node node = queue.removeLast();

            visitor.visit(node);

            if(node.left != null)
                queue.add(node.left);

            if(node.right != null)
                queue.add(node.right);
        }
    }

}