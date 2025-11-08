// LinkedListPractice.java
// One-stop file to practice all key Linked List problems
// Uncomment the section you want to test!


class Node {
    int data;
    Node next;
    Node(int data) { 
        this.data = data; }
}

public class LinkedListPractice {

    //🧩 1. Print Linked List
    static void printList(Node head) {
       Node h1=head;
       while(h1!=null){
        System.out.println(h1.data);
        h1=h1.next;
       }
    }

    // ⚙️ 2. Insert Operations
    static Node insertAtBeginning(Node head, int data) {
        Node newHead=new Node(data);
        newHead.next=head;
        return newHead;
    }

    static Node insertAtEnd(Node head, int data) {
        Node newTail=new Node(data);
        Node h1=head;
        while(h1.next!=null){
            h1=h1.next;
        }
        h1.next=newTail;
        newTail.next=null;
        return head;
    }

    static Node insertAtPosition(Node head, int data, int pos) {
        int counter=1;
        Node insert=new Node(data);
        Node h1=head;
        while(counter<pos-1 && h1!=null){
          h1=h1.next;
          counter++;
        }
        if(h1!=null){
        insert.next=h1.next;
        h1.next=insert;
        }
        return head;
    }

    // ❌ 3. Delete Node by Value
    static Node deleteByValue(Node head, int value) {
        Node h1=head;

        while(h1!=null){
            if(h1.next!=null){
            if(h1.next.data==value){
               Node n=h1.next;
               h1.next=h1.next.next;
               n.next=null;
            }
                h1=h1.next;
            
        }
        else{
            h1=null;
        }
    }
        return head;
}

    // 🔁 4. Reverse Linked List
    static Node reverse(Node head) {
        Node prev=null;
        Node current=head;
        Node next=null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    // 🔍 5. Find Middle Node
    static Node findMiddle(Node head) {
       Node h1=head;
       int counter=0;
       while(h1!=null){
        h1=h1.next;
        counter++;
       }
       counter=counter/2;
       int c=0;
       h1=head;
       while(c!=counter){
         h1=h1.next;
         c++;
       }
         
        return h1;
    }

    // 🌀 6. Detect Cycle
    static boolean hasCycle(Node head) {
       Node slow=head;
       Node fast=head;

       while(fast.next!=null && fast.next.next!=null){      //Floyd's tortoise and hare algorithom(Slow fast pointer)
        slow=slow.next;
        fast=fast.next.next;                               

        if(slow==fast){
            return true;
        }
       }
       return false;
    }

    // 📍 7. Nth Node from End
    static Node nthFromEnd(Node head, int n) {
        Node prev=null;
        Node current=head;
        Node next=null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        Node h1=prev;
        int c=1;
        while(c!=n){
            h1=h1.next;
            c++;
        }
        return h1;
    }

     // ⚡ 8. Merge Two Sorted Lists
    static Node merge(Node l1, Node l2) {
        Node dummy=new Node(0);            //new list dummy headed
        Node current=dummy;
        while(l1!=null && l2!=null){            //checking which list element is bigger then adding that to the new list
            if(l1.data<l2.data){
            current.next=l1;
            l1=l1.next;
            }
            else{
            current.next=l2;
            l2=l2.next;
            }
            current=current.next;
        }
        if(l1!=null){                          //adding the last element
            current.next=l1;
        }
       else if(l2!=null){
        current.next=l2;
       }
      
       return dummy.next; 
    }

    // 🔢 9. Add Two Numbers (LL)
    static Node addLists(Node l1, Node l2) {
        Node dummy=new Node(0);
        Node current=dummy;

        while(l1!=null && l2!=null){
            current.next=new Node(l1.data+l2.data);        //creating new node each time with the summed value
            current=current.next;                          //connecting nodes
            l1=l1.next;
            l2=l2.next;
        }
        return dummy.next;
    }

    // 🔄 10. Check Palindrome
    static boolean isPalindrome(Node head) {
        Node slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.data != slow.data) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }


    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        // Uncomment the section you want to test 👇
        
        // ---------------- Problem 1: Print ----------------
        
        // Node head = new Node(10);
        // head.next = new Node(20);
        // head.next.next = new Node(30);
        // printList(head);
        

        // ---------------- Problem 2: Insert ----------------
        
        // Node head = null;
        // head = insertAtBeginning(head, 30);
        // head = insertAtEnd(head, 40);
        // head = insertAtPosition(head, 35, 2);
        // printList(head);
        

        // ---------------- Problem 3: Delete ----------------
        
        // Node head = new Node(10);
        // head.next = new Node(20);
        // head.next.next = new Node(30);
        // head = deleteByValue(head, 20);
        // printList(head);
        

        // ---------------- Problem 4: Reverse ----------------
        
        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head = reverse(head);
        // printList(head);
        

        // ---------------- Problem 5: Find Middle ----------------
        
        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = new Node(6);
        // head.next.next.next.next.next.next = new Node(7);
        // Node mid = findMiddle(head);
        // System.out.println("Middle: " + (mid != null ? mid.data : "null"));
        

        // ---------------- Problem 6: Detect Cycle ----------------
        
        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = head.next; // create cycle
        // System.out.println("Has cycle: " + hasCycle(head));
        

        // ---------------- Problem 7: Nth Node from End ----------------
        
        // Node head = new Node(10);
        // head.next = new Node(20);
        // head.next.next = new Node(30);
        // head.next.next.next = new Node(40);
        //  head.next.next.next.next = new Node(50);

        // Node nth = nthFromEnd(head, 2);
        // System.out.println("Nth from end: " + (nth != null ? nth.data : "null"));
        

        // ---------------- Problem 8: Merge Sorted Lists ----------------
        
        // Node l1 = new Node(1);
        // l1.next = new Node(3);
        // l1.next.next = new Node(5);

        // Node l2 = new Node(2);
        // l2.next = new Node(4);
        // l2.next.next = new Node(6);

        // Node merged = merge(l1, l2);
        // printList(merged);
        

        // ---------------- Problem 9: Add Two Numbers ----------------
        
        // Node l1 = new Node(2);
        // l1.next = new Node(4);
        // l1.next.next = new Node(3);

        // Node l2 = new Node(5);
        // l2.next = new Node(6);
        // l2.next.next = new Node(4);

        // Node sum = addLists(l1, l2);
        // printList(sum);
        

        // ---------------- Problem 10: Palindrome Check ----------------
        
        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(2);
        // head.next.next.next = new Node(1);
        // System.out.println("Is palindrome: " + isPalindrome(head));
        
    }
}