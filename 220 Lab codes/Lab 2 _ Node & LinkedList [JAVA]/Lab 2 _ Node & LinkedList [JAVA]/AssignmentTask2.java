// AssignmentTask2: Organize Books
import java.util.Arrays;
public class AssignmentTask2{
    
    // MUST SUBMIT this method
    public static Node organizeBooks(Node head, Integer[] popularity) {
<<<<<<< HEAD
       int N=popularity.length;
       
       for(int i=0;i<N-1;i++){
       Node current=head;
       Node previous=null;

        for(int j=0;j<N-1-i;j++){
            Node next=current.next;

            if(popularity[j]<popularity[j+1]){
                int temp=popularity[j];
                popularity[j]=popularity[j+1];
                popularity[j+1]=temp;

                    if(previous!=null){
                        previous.next=next;
                    }
                    else{
                        head=next;
                    }
                    current.next=next.next;
                    next.next=current;
                }
            
            previous=current;
            current=next;
        }
       }
       return head;
=======
        
        boolean flag=true;
        while(flag==true){
            flag=false;
            int idx=0;
            Node previous=null;
            Node current=head;

            while(current!=null && current.next!=null){
                if(popularity[idx]>popularity[idx+1]){
                    Node t=current.next;
                    if(previous==null){
                        head=t;
                    }
                    else{
                        previous.next=t;
                    }
                    current.next=t.next;
                    t.next=current;

                    int temp=popularity[idx];
                    popularity[idx]=popularity[idx+1];
                    popularity[idx+1]=temp;

                    flag=true;
                    previous=t;
                }
                else{
                    previous=current;
                    current=current.next;
                }
                idx++;
            }
        }

        Node prev=null;
        Node current=head;
        Node next=null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;

        return head; // Remove this when you're ready to return the new head
>>>>>>> ed5a2edb7578fbbbe55374c54883b3e164b50d14
    }

    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT MAKE ANY MODIFICATIONS IN THE TESTER CODE BELOW
    //DO NOT SUBMIT THE DRIVER CODE BELOW
    public static void main(String[] args) {
        System.out.println("=================Test Case 1=================");
        Node books = LinkedList.createList(new String[]{"Dune", "IT", "Coraline", "Inferno", "Twlight"});
        Integer[] arr = { 8, 10, 5, 10, 6 };

        System.out.println("Sample Given LinkedList and Popularity array:  ");
        LinkedList.printLL(books);
        System.out.println(Arrays.toString(arr));
        
        System.out.println("\nExpected Output");
        System.out.println("IT -> Inferno -> Dune -> Twilight -> Coraline");
        
        System.out.println("Your Output");
        books = organizeBooks( books, arr );
        LinkedList.printLL(books);

       
        System.out.println("=================Test Case 2=================");
        Node books2 = LinkedList.createList(new String[]{"Hamlet", "Persuasion", "It", "Dracula", "Beloved"});
        Integer[] arr2 = {7, 9, 9, 6, 7};

        System.out.println("Sample Given LinkedList and Popularity array:  ");
        LinkedList.printLL(books2);
        System.out.println(Arrays.toString(arr2));

        System.out.println("\nExpected Output");
        System.out.println("Persuasion -> It -> Hamlet -> Beloved -> Dracula");

        System.out.println("Your Output");
        books2 = organizeBooks(books2, arr2);
        LinkedList.printLL(books2);


        System.out.println("=================Test Case 3=================");
        Node books3 = LinkedList.createList(new String[]{"Matilda", "Franny", "Foundation", "Carrie", "Misery"});
        Integer[] arr3 = {5, 8, 8, 10, 6};

        System.out.println("Sample Given LinkedList and Popularity array:  ");
        LinkedList.printLL(books3);
        System.out.println(Arrays.toString(arr3));

        System.out.println("\nExpected Output");
        System.out.println("Carrie -> Franny -> Foundation -> Misery -> Matilda");

        System.out.println("Your Output");
        books3 = organizeBooks(books3, arr3);
        LinkedList.printLL(books3);

    }
}
