/* Java coding exercise 1: Construct a binary tree. Implement pre-order, in-order,and post-order tree traversal 
algorithms to traverse this binary tree. Print out these three traversal orders, compare them with your manual 
computations/calculations by hands and make sure that everything is correct.*/

class Node {
    int key;
    Node left, right;
 
    public Node(int item) {
        key = item;
        left = right = null;
    }//closes public Node function
}//closes Node class
 
class Binary_Tree {
    // Root of Binary Tree
    Node root;
 
    Binary_Tree() {
        root = null;
    }//closes Binary_Tree
 
    //print the nodes in Postorder tree traversal: visit children first and parent is last
    void printPostorder(Node node) {
        if (node == null)
        return;
 
        // first recur on left subtree
        printPostorder(node.left);
 
        // then recur on right subtree
        printPostorder(node.right);
 
        // now deal with the node
        System.out.print(node.key + " ");
    }//closes printPostorder
 
    //given a binary tree, print the nodes in inorder: left most node, parent, right node... repeat
    void printInorder(Node node) {
        if(node == null)
        return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.key + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }//closes printInorder
 
    //given a binary tree, print its nodes in preorder: start with root
    void printPreorder(Node node) {
        if (node == null)
        return;
 
        //print data of node
        System.out.print(node.key + " ");
 
        //then recursion on left sutree
        printPreorder(node.left);
 
        //now recursion on right subtree
        printPreorder(node.right);
    }//closes printPreorder
 
    //wrappers over above recursive functions
    void printPostorder() {printPostorder(root);}
    void printInorder() {printInorder(root);}
    void printPreorder() {printPreorder(root);}
 
    //driver method
    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Preorder traversal of binary tree is ");//print statement for preorder
        tree.printPreorder();
 
        System.out.println("\nInorder traversal of binary tree is ");//print statement for inorder
        tree.printInorder();
 
        System.out.println("\nPostorder traversal of binary tree is ");//print statement for postorder
        tree.printPostorder();
    }//closes main
}//closes main Binary_Tree class

