class HashNode {
    String key;      // employee ID (string)
    String value;    // department name (string)
    HashNode next;

    HashNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable3 {
    private HashNode[] table;
    private int size;

    public HashTable3(int size) {
        this.size = size;
        table = new HashNode[size];
    }

    // ===================== HASH FUNCTION =====================
    /*
        Compute index from key (employee ID string) using:

        - For each character in key:
              ascii = (int) key.charAt(i)
              position index = i + 1   (starting from 1)
              weighted = ascii * position index
        - Sum all weighted values.
        - index = sum % size
        - return index
    */
    private int hashFunction(String key) {
        // TODO: implement and return hash index
        // int sum = 0;
        // for (...) { ... }
        // int index = sum % size;
        // return index;
       int ascii=0;
        int posIndex=0;
        int sum=0;

        for(int i=0;i<key.length();i++){
         ascii=(int)key.charAt(i);
         posIndex=i+1;
         sum+=ascii*posIndex;
        }
        int index=sum%size;
        return index;  
    }

    // ===================== INSERT (FORWARD CHAINING) =====================
    /*
        Insert(key, value):

        1. Compute index = hashFunction(key).
        2. Let head = table[index].
        3. Traverse the chain:
              - if node.key equals key:
                    update node.value = value
                    return (do NOT add new node)
        4. If key not found:
              - if head == null:
                    table[index] = new HashNode(key, value);
              - else:
                    append new node at END of chain (forward chaining).
    */
    public void insert(String key, String value) {
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

    // ===================== DISPLAY (assumed implemented) =====================
    // You can adjust this to match your assignment’s exact format.
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            HashNode current = table[i];

            if (current == null) {
                System.out.println("None");
                continue;
            }

            while (current != null) {
                System.out.print("(" + current.key + ": " + current.value + ")");
                if (current.next != null) System.out.print(" -> ");
                current = current.next;
            }
            System.out.println(" -> None");
        }
    }
}
