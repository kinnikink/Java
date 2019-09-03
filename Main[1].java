/*
 * Lab 3: Page 223: Problem C-5.25: Assume SinglyLinkedList.java is available to you. Implement java code 
to reverse a singly linked list L, so that the ordering of the nodes becomes opposite of what is was before 
using non-recursive and recursive ways.
*/
 
public class Main {
    
    static Node head;
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }//closes Node method
    }//closes Node class
 
    //a simple and tail recursive function to reverse a linked list
    //previous is initially passed as NULL
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    
    //Recursive Algorithm that takes the reversed list and reverses it(getting back the original list)
    Node recursive(Node curr, Node prev) {

        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;
            return null;
        }

        /* Save curr->next node for recursive call */
        Node next1 = curr.next;

        /* and update next ..*/
        curr.next = prev;

        recursive(next1, curr);
        return head;
    }
 
    //prints content of singly linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }//closes while loop on line 60
    }//closes printList method
 
    //adds nodes(values) to the linked list
    public static void main(String[] args) {
        Main list = new Main();
        list.head = new Node(2);
        list.head.next = new Node(7);
        list.head.next.next = new Node(10);
        list.head.next.next.next = new Node(1);
        list.head.next.next.next.next = new Node(13);
        list.head.next.next.next.next.next = new Node(40);
        list.head.next.next.next.next.next.next = new Node(100);
        list.head.next.next.next.next.next.next.next = new Node(5);
        
        System.out.println("Original Linked List: ");//print statement for the original list
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("");
        System.out.println("Non-Recursive Reversed Linked List: ");//print statement for the reverse of the original list
        list.printList(head);
        
        
        Node res1 = list.recursive(head, null);
        System.out.println("\n\nRecursive Reversed Linked List:");//print statement for the reversed reverse(gets original list)
        list.printList(res1);
    }//closes Main method
}// closes Main class