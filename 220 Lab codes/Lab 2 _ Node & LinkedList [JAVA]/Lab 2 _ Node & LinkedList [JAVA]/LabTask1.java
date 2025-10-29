// LabTask1: Assemble Conga Line
public class LabTask1 {
	
    // No need to submit this task
    public static Boolean assembleCongaLine(Node head){
        boolean flag=false;
        Node n=head;
        while(n.next!=null){
            if((int)n.next.elem>(int)n.elem){
                flag=true;
                n=n.next;
            }
            else {
                flag=false;
                break;
            }
        }
        return flag;
    }


    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT TOUCH THE DRIVER CODE BELOW
    public static void main(String[] args){

        System.out.println("==============Test Case 1=============");
        Node congaLine = LinkedList.createList(new Integer[]{10,15,34,41,56,72});
        System.out.print("Original Conga Line: ");
        LinkedList.printLL(congaLine);
        System.out.println("Expected output: true");
        System.out.println( "Your output: "+assembleCongaLine(congaLine) ); //This should print True
        System.out.println();
        System.out.println("==============Test Case 2=============");
        congaLine = LinkedList.createList(new Integer[]{10,15,44,41,56,72});
        System.out.print("Original Conga Line: ");
        LinkedList.printLL(congaLine);
        System.out.println("Expected output: false");
        System.out.println( "Your output: "+assembleCongaLine(congaLine) ); //This should print False
        System.out.println();
    }
}
