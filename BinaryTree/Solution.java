import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        try(Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNext()) {
                binaryTree.insert(scanner.nextInt());
            }
        }
        
        System.out.println("Depth First Traversal");
        binaryTree.printTreeDepthFirst();

        System.out.println("Breadth First Traversal");
        binaryTree.printTreeBreadthFirst();

        System.out.println("Leaf nodes");
        binaryTree.printNodes();
    }
}