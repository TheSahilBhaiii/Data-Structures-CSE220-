public class AssignmentTask6 {

    //SUBMIT ONLY THIS METHOD
    public static void pairJoin(DNode dh1, DNode dh2) {
        DNode h1=dh1.next;
        DNode h2=dh2.next;

        DNode dummy=new DNode(0);
        DNode current=dummy;

        while(h1!=null && h2!=null){
            current.next=h1;
            h1.prev=current;
            current=current.next;
            h1=h1.next;
            
            current.next=h2;
            h2.prev=current;
            current=current.next;
            h2=h2.next;
        }
        while(h1!=null){
            current.next=h1;
            h1.prev=current;
            current=current.next;
            h1=h1.next;
        }
        while(h2!=null){
            current.next=h2;
            h2.prev=current;
            current=current.next;
            h2=h2.next;
        }
            if(dummy.next!=null){
                DNode firstNode=dummy.next;
                DNode lastNode=current;
                firstNode.prev=lastNode;
                lastNode.next=firstNode;
            }
            dh1.next=dummy.next;
            if(dummy.next!=null){
                dummy.next.prev=dh1;
            }
        }
    

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] list1 = {"A", "B", "C", "D"};
        Object[] list2 = {"E", "F", "G", "H"};

        DNode dh1 = LinkedListHelpers.createDummyHeadedDoublyLL(list1, false);
        DNode dh2 = LinkedListHelpers.createDummyHeadedDoublyLL(list2, false);

        System.out.println("Given Linked List 1:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh1);

        System.out.println("Given Linked List 2:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh2);

        System.out.println("\nExpected Output:");
        Object[] expected = {"A", "E", "B", "F", "C", "G", "D", "H"};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);

        //Running the Pair Join
        pairJoin(dh1, dh2);
        //Printing after Pair Join
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh1);
    }
}
