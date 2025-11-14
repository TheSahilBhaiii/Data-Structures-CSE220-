/*You will have to complete the FruitNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and insert()
 the rest of the metods are already written
 DO NOT TOUCH any other methods or codes*/
public class HashTable {

    //ht[] :: is the HashTable array that stores the FruitNode objects
    private FruitNode[] ht;

    //Constructor that initializes the HashTable array
	//DO NOT change this Constructor
    public HashTable(int size){
        this.ht = new FruitNode[size];
    }
    
    //This method basically prints the HashTable
    //DO NOT change this method
    public void show(){
        for(int i=0; i<ht.length; i++){
            System.out.print( i+" " );
            FruitNode n = ht[i];
            while (n!=null){
                System.out.print("('"+n.fruit[0]+"', "+n.fruit[1]+") --> ");
                n = n.next;
            }
            System.out.println();
        }
    }

    //you need to COMPLETE this method
    private int hashFunction( String key ){
        int N=key.length();
        int sum=0;
        for(int i=0;i<N;i++){
        if(N%2==0){
            if(i%2==0){
                sum+=(int)key.charAt(i);
            }
            
        }
        if(N%2!=0){
            if(i%2!=0){
                sum+=(int)key.charAt(i);
            }
            
        }
    }
        sum=sum%ht.length;
        return sum; //remove this line
        }

    //you need to COMPLETE this method
    //The insert() method will create a FruitNode using name(Key) & price(value)
	//then inserts it in the proper hashed index
    //If collision occurs resolve using the steps explained in the question
    public void insert(String key, Integer value){
        int idx=hashFunction(key);
        FruitNode insertNode=new FruitNode(key,value);
        if(ht[idx]==null){
            ht[idx]=insertNode;
        }
        else{
            FruitNode head=ht[idx];
            
            if((int)insertNode.fruit[1]>(int)head.fruit[1]){
            insertNode.next=head;
            ht[idx]=insertNode;
            head=insertNode;
            }
            else{
                FruitNode prev=null;
                FruitNode current=head;

                while(current!=null){
                    if((int)insertNode.fruit[1]>(int)current.fruit[1]){
                        prev.next=insertNode;
                        insertNode.next=current;
                }
                prev=current;
                current=current.next;
            }
            if((int)insertNode.fruit[1]<(int)prev.fruit[1]){
                prev.next=insertNode;
            }
        }
        }
    
    }

}
