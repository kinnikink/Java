//Java coding exercise 2:Construct a binary search tree. Print out the above tree in in-order tree traversal
//to check whether the results are sorted or not.

class Node {
    int data;
    Node left, right;
 
    public Node(int item) {
        data = item;
        left = right = null;
    }//closes Node function
}//closes Node class
 
public class Binary_Search_Tree {
    //root of the Binary Tree
    Node root;
 
    //gives min and max value according to your code
    //returns true if given search tree is binary search tree
    void printInorder(Node node) {
        if(node == null)
        return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.data + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }//closes printInorder
    boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }//closes isBST
 
    //returns true if the given tree is a BST and its values are >= min and <= max
    boolean isBSTUtil(Node node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
        return true;
 
        //false if this node violates the min/max constraints
        if (node.data < min || node.data > max)
            return false;
 
        //otherwise check the subtrees recursively tightening the min/max constraints 
        //allows only distinct values
        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }//closes isBSTUtil
    
    void printInorder() {printInorder(root);}
 
    //driver program to test above functions
    public static void main(String args[]) {
        Binary_Search_Tree tree = new Binary_Search_Tree();
        tree.root = new Node(4);//4 is a value in the tree
        tree.root.left = new Node(2);//2 is a value in the tree
        tree.root.right = new Node(5);//5 is a value in the tree
        tree.root.left.left = new Node(1);//1 is a value in the tree
        tree.root.left.right = new Node(3);//3 is a value in the tree
        
        System.out.println("\nin-order traversal of binary tree is ");//print statement
        tree.printInorder();
 
        if (tree.isBST())//if BST
        System.out.println("\nIS A BST");//print statement if it is not a Binary Search Tree(BST)
        else// is not BST
        System.out.println("\nIS NOT A BST");//print statement if it is a Binary Search Tree(BST)
    }//closes main
}//closes Binary_Search_Tree
