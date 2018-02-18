
interface TreeTraverser {

    /**
     * Traverses a tree with given head and calls visitor.visit method when each node is visited
     */
    void traverse(Node head, TreeVisitor visitor);
}