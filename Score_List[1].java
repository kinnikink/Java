public class Score_List {//this class creates the list of the game scores

    private class Node {
        String name;
        int score;
        Node next;

        Node(String val1, int val2, Node n) {
            name = val1;
            score = val2;
            next = n;
        }//closes line 8

        Node(String val1, int val2) {
            this(val1, val2, null);
        }//closes line 14
    }//closes the private class Node
    //these two can be used only by subclasses and this class
    private Node head;
    private Node tail;

    /**
     * Constructor.
     */

    public Score_List() {
        head = null;
        tail = null;
    }//closes public Score_List()

    //checks to see if the list is empty
    //returns true if empty, false if there is stuff in the list
    public boolean isEmpty() {
        return head == null;
    }//closes isEmpty()

    //gives the size of the list
    public int size() {
        int count = 0;
        Node p = head;

        //this while loop checks to see if the list has a value in it,
        //if it does it adds it to the count
        while(p != null) {
            count++;
            p = p.next;
        }//closes while loop on line 43
        return count;
    }//closes size()

    //allows insertion into the list
    public void insert(String name, int score) {
        Node node = new Node(name, score);
        //if empty returns nothing
        if(isEmpty()) {
            head = node;
            tail = node;
        }//closes if-statement

        //starts the sorting method
        else if(head.score <= node.score) {
            node.next = head;
            head = node;
        }//closes else if statement on line 61

        //this is the sorting part of the program
        else {
            Node frontPtr = head.next;
            Node backPtr = head;

            while(frontPtr.score > node.score && frontPtr.next != null) {
                backPtr = backPtr.next;
                frontPtr = frontPtr.next;
            }//closes while loop on line 71
            if(frontPtr != null && frontPtr.score <= node.score) {
                backPtr.next = node;
                node.next = frontPtr;
            }//closes if statement on line 75
            else {
                frontPtr.next = node;
                tail = node;
            }//closes else statement on line 79
        }//closes else statement on line 67

        //takes just takes the top ten scores
        if(size() > 10) {
            Node currentPtr = head;
            while(currentPtr.next != tail) {
                currentPtr = currentPtr.next;
            }//closes while loop on line 88
            tail = currentPtr;
            currentPtr.next = null;
        }//closes if on line 86
    }//closes insert()

    //this prints out the list that is sorted
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.name + " " + temp.score + " ");
            System.out.println("");
            temp = temp.next;
        }//closes while loop on line 99
    }//closes printList
}//closes Score_List
