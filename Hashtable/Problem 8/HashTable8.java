/*
Question 8: Product Price Hash Table

You are asked to implement a HashTable class that stores key-value pairs, 
where the key is a string (representing a product ID) and the value is a float 
(representing the product's price).

The class should include a hash_function that computes the hash index based on 
the sum of the ASCII values of the first three characters of the key. 
If the key is shorter than three characters, it should add the ASCII value of 
'0' (48) to make the key length three.

The insert() method should insert a new key-value pair into the hash table. 
If a collision occurs, the method will use forward chaining (linked lists) to store 
multiple entries at the same index. If the key already exists, it should update 
the value by adding the new price to the previous price.

You are not allowed to use any built-in functions except len(). 
Assume the display method is already implemented.
*/

class HashNode {
    String key;
    float value;
    HashNode next;

    HashNode(String key, float value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable8 {
    private HashNode[] table;
    private int size;

    public HashTable8(int size) {
        this.size = size;
        table = new HashNode[size];
    }

    // ===================== HASH FUNCTION =====================
    private int hashFunction(String key) {
        int sum=0;
        int ascii=0;
        int index;

        if(key.length()>=3){
            for(int i=0;i<3;i++){
                ascii=(int)key.charAt(i);
                sum+=ascii;
            }
            index=sum%size;
        }
        else{
            for(int i=0;i<key.length();i++){
                ascii=(int)key.charAt(i);
                sum+=ascii;
            }
            for(int i=key.length();i<3;i++){
                sum+=(int)'0';
            }
            index=sum%size;
        }
        return index; 
    }

    // ===================== INSERT =====================
    public void insert(String key, float value) {
       int index=hashFunction(key);
       HashNode head=table[index];

       if(head==null){
        table[index]=new HashNode(key,value);
        return;
       }
       else{
        HashNode current=head;
        HashNode prev=null;

        while(current!=null){
            if(current.key.equals(key)){
                current.value+=value;
                return;
            }
            prev=current;
            current=current.next;
        }
        prev.next=new HashNode(key,value);
       }
    }

    // ===================== DISPLAY (given) =====================
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            HashNode current = table[i];
            if (current == null) {
                System.out.println();
                continue;
            }
            while (current != null) {
                System.out.print(current.key + " (" + current.value + ")");
                if (current.next != null) System.out.print("  ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

