// File: DCDLPractice.java
// Dummy-Headed Doubly Circular Linked List Practice (LeetCode-style)

public class DCDLPractice {

    // ===========================
    // Basic Node + Helper Methods
    // ===========================

    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int v) {
            this.val = v;
        }
    }

    // Create a dummy-headed doubly circular list from an int array
    // dummy.next = first node or dummy if empty
    // dummy.prev = last node or dummy if empty
    static Node buildList(int[] arr) {
        Node dummy = new Node(-1); // dummy value ignored
        dummy.next = dummy;
        dummy.prev = dummy;

        Node tail = dummy;
        for (int x : arr) {
            Node node = new Node(x);
            // Insert at end before dummy
            node.prev = tail;
            node.next = dummy;
            tail.next = node;
            dummy.prev = node;
            tail = node;
        }
        return dummy;
    }

    // Print list in one line starting after dummy, going forward once
    static void printList(Node dummy) {
        Node cur = dummy.next;
        System.out.print("dummy");
        while (cur != dummy) {
            System.out.print(" <-> " + cur.val);
            cur = cur.next;
        }
        System.out.println(" <-> dummy (circular)");
    }

    // Get length (number of real nodes, excluding dummy)
    static int length(Node dummy) {
        int n = 0;
        Node cur = dummy.next;
        while (cur != dummy) {
            n++;
            cur = cur.next;
        }
        return n;
    }

    // ============================================
    // Problem 1: Move Last k Nodes to Front (Right Rotate)
    // ============================================
    /*
        LeetCode-style statement:

        Given a dummy-headed doubly circular linked list and an integer k,
        move the last k nodes to the front of the list while keeping their
        internal relative order. Return the dummy head.

        Constraints:
        - 0 <= k
        - Use O(1) extra space and O(n) time.
        - If k is 0 or a multiple of the list length, the list should stay unchanged.

        Example:
        Input:  dummy <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> dummy, k = 2
        Output: dummy <-> 4 <-> 5 <-> 1 <-> 2 <-> 3 <-> dummy
    */
    static Node moveLastKToFront(Node dummy, int k) {
        int len=0;
        Node tail=dummy.next;
        while(tail.next!=dummy){
            tail=tail.next;
            len++;
        }
        if(k%len==0) return dummy;

        k=k%len;
        Node nt=dummy.next;
        for(int i=0;i<(len-k);i++){
            nt=nt.next;
        }
        Node head=dummy.next;
        Node nh=nt.next;
        nt.next=dummy;
        nh.prev=dummy;
        dummy.next=nh;
        tail.next=head;
        head.prev=tail;
        return dummy;
    }

    static void testProblem1() {
        int[] arr = {1, 2, 3, 4, 5};
        Node dummy = buildList(arr);
        System.out.println("Problem 1 - Before:");
        printList(dummy);

        dummy = moveLastKToFront(dummy, 2);

        System.out.println("Problem 1 - After (expected: 4 5 1 2 3):");
        printList(dummy);
    }

    // ============================================
    // Problem 2: Rotate Left by k (Move First k Nodes to End)
    // ============================================
    /*
        Given a dummy-headed doubly circular linked list and an integer k,
        move the first k nodes to the end of the list, preserving their order.

        Example:
        Input:  dummy <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> dummy, k = 2
        Output: dummy <-> 3 <-> 4 <-> 5 <-> 1 <-> 2 <-> dummy

        Requirements:
        - O(1) extra space, O(n) time.
        - 0 <= k; if k == 0 or k % n == 0 then list unchanged.
    */
    static Node rotateLeftByK(Node dummy, int k) {
        int len=0;
        Node tail=dummy.next;

        while(tail.next!=dummy){
            tail=tail.next;
            len++;
        }
        if(k%len==0) return dummy;

        Node nt=dummy;
        for(int i=0;i<k;i++){
            nt=nt.next;
        }
        Node head=dummy.next;
        Node nh=nt.next;

        nt.next=dummy;
        dummy.prev=nt;
        nh.prev=dummy;
        dummy.next=nh;
        tail.next=head;
        head.prev=tail;

        return dummy;
    }

    static void testProblem2() {
        int[] arr = {1, 2, 3, 4, 5};
        Node dummy = buildList(arr);
        System.out.println("Problem 2 - Before:");
        printList(dummy);

        dummy = rotateLeftByK(dummy, 2);

        System.out.println("Problem 2 - After (expected: 3 4 5 1 2):");
        printList(dummy);
    }

    // ============================================
    // Problem 3: Remove All Nodes with a Given Value
    // ============================================
    /*
        Given a dummy-headed doubly circular linked list and an integer target,
        remove ALL nodes whose value equals target and return the number of
        nodes removed.

        Requirements:
        - O(1) extra space, O(n) time.
        - The dummy node must remain and the list must stay circular.

        Example:
        Input:  dummy <-> 1 <-> 2 <-> 3 <-> 2 <-> 4 <-> dummy, target = 2
        Output: count = 2,
                list becomes dummy <-> 1 <-> 3 <-> 4 <-> dummy
    */
    static int removeAll(Node dummy, int target) {
        Node temp=dummy.next;
        int counter=0;

        while(temp!=dummy){
            if(target==temp.val){
              Node current=temp;
              Node before=current.prev;
              Node after=current.next;
              Node nextNode=after;

              before.next=after;
              after.prev=before;

              current.prev=null;
              current.next=null;

              temp=nextNode;
              counter++;
            }
            else{
                temp=temp.next;
            }
        }
        return counter;
    }

    static void testProblem3() {
        int[] arr = {1, 2, 3, 2, 4};
        Node dummy = buildList(arr);
        System.out.println("Problem 3 - Before:");
        printList(dummy);

        int removed = removeAll(dummy, 2);
        System.out.println("Removed count (expected 2): " + removed);
        System.out.println("Problem 3 - After (expected: 1 3 4):");
        printList(dummy);
    }

    // ============================================
    // Problem 4: Check if the List is a Palindrome
    // ============================================
    /*
        Given a dummy-headed doubly circular linked list, determine whether
        the sequence of node values (ignoring dummy) is a palindrome.

        Requirements:
        - O(1) extra space, O(n) time.
        - You may use two pointers from both ends (head+tail) since it's doubly linked.

        Example:
        dummy <-> 1 <-> 2 <-> 2 <-> 1 <-> dummy   -> true
        dummy <-> 1 <-> 2 <-> 3 <-> dummy        -> false
    */
    static boolean isPalindrome(Node dummy) {
        Node head=dummy.next;
        Node tail=dummy.next;
        int len=0;

        while(tail.next!=dummy){
            tail=tail.next;
            len++;
        }

        if(len%2==0){
            while(head.next!=tail && tail.prev!=head){
                if(head.val!=tail.val){
                    return false;
                }
                else{
                    head=head.next;
                    tail=tail.prev;
                }
            }
            return true;
        }
        else{
            while(head!=tail){
                if(head.val!=tail.val){
                    return false;
                }
                else{
                    head=head.next;
                    tail=tail.prev;
                }
            }
            return true;
            }
        }

    static void testProblem4() {
        int[] arr1 = {1, 2, 2, 1};
        Node d1 = buildList(arr1);
        System.out.println("Problem 4 - List 1:");
        printList(d1);
        System.out.println("Is palindrome? (expected true): " + isPalindrome(d1));

        int[] arr2 = {1, 2, 3};
        Node d2 = buildList(arr2);
        System.out.println("Problem 4 - List 2:");
        printList(d2);
        System.out.println("Is palindrome? (expected false): " + isPalindrome(d2));
    }

    // ============================================
    // Problem 5: Insert into a Sorted List
    // ============================================
    /*
        Given a dummy-headed doubly circular linked list sorted in
        non-decreasing order and an integer value x, insert a new node with
        value x so that the list remains sorted.

        Requirements:
        - O(1) extra space, O(n) time.
        - You must maintain the dummy node and circular structure.

        Example:
        Input:  dummy <-> 1 <-> 3 <-> 5 <-> dummy, x = 4
        Output: dummy <-> 1 <-> 3 <-> 4 <-> 5 <-> dummy
    */
    static Node insertSorted(Node dummy, int x) {
        Node newNode=new Node(x);
        Node temp=dummy.next;

        while(temp.next!=dummy){
            if(temp.prev.val<x && temp.next.val>x){
                Node n=temp.next;
                temp.next=newNode;
                newNode.prev=temp;
                n.prev=newNode;
                newNode.next=n;
                break;
            }
            else{
                temp=temp.next;
            }
        }
        return dummy;
    }

    static void testProblem5() {
        int[] arr = {1, 3, 5};
        Node dummy = buildList(arr);
        System.out.println("Problem 5 - Before:");
        printList(dummy);

        dummy = insertSorted(dummy, 4);

        System.out.println("Problem 5 - After (expected: 1 3 4 5):");
        printList(dummy);
    }

    // ===========================
    // main: Uncomment one test at a time
    // ===========================
    public static void main(String[] args) {
        // UNCOMMENT EXACTLY ONE OF THESE TO RUN A SPECIFIC PROBLEM:

          //testProblem1();
          //testProblem2();
          //testProblem3();
          //testProblem4();
          //testProblem5();
    }
}
