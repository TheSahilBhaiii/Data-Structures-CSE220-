/*
Question 6: Student Grade Hash Table (Version 1)

You are asked to implement a HashTable class that stores key-value pairs, 
where the key is a string (representing a student ID) and the value is an 
integer (representing the student's grade).

The class should include a hash_function that calculates the hash index by 
summing the ASCII values of the first two characters of the key. 
If the key is only one character, the ASCII value of 'Y' (89) should be added 
as the second character.

The insert() method should add a new key-value pair or update the value if the 
key already exists. Use forward chaining to handle collisions.

You are not allowed to use any built-in functions except len(). 
Assume the display() method is already implemented to show the hash table.
*/

class HashNode {
    String key;
    int value;
    HashNode next;

    HashNode(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable6 {
    private HashNode[] table;
    private int size;

    public HashTable6(int size) {
        this.size = size;
        table = new HashNode[size];
    }

    // ===================== HASH FUNCTION =====================
    private int hashFunction(String key) {
        int sum=0;
        int index;
        
        if(key.length()>=2){
            sum+=(int)key.charAt(0);
            sum+=(int)key.charAt(1);
            index=sum%size;
        }
        else{
            sum+=(int)key.charAt(0);
            sum+=(int)'Y';
            index=sum%size;
        }
        return index;
    }

    // ===================== INSERT =====================
    public void insert(String key, int value) {
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
                current.value=value;
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
                System.out.println("None");
                continue;
            }
            while (current != null) {
                System.out.print(current.key + " (" + current.value + ")");
                if (current.next != null) System.out.print(" -> ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

