// ===================== NODE CLASS =====================
class HashNode {
    String name;   // student name (key)
    int id;        // student ID (value)
    HashNode next;

    HashNode(String name, int id) {
        this.name = name;
        this.id = id;
        this.next = null;
    }
}

// ===================== HASH TABLE CLASS =====================
class HashTable4 {
    private HashNode[] table;
    private int size;

    public HashTable4(int size) {
        this.size = size;
        table = new HashNode[size];
    }

    // ===================== HASH FUNCTION =====================
    /*
        Rules:

        1. Compute sum of ASCII values of all characters in name.
        2. If sum is ODD:
               index = sum % size
           If sum is EVEN:
               index = (sum / 2) % size
        3. Return index.
    */
    private int hashFunction(String name) {
        // TODO:
        // int sum = 0;
        // for (...) { sum += (int) name.charAt(i); }
        // if (sum % 2 == 0) index = (sum / 2) % size;
        // else              index = sum % size;
        // return index;
        int sum=0;
        int ascii=0;
        int index;
        
        for(int i=0;i<name.length();i++){
            ascii=(int)name.charAt(i);
            sum+=ascii;
        }
        if(sum%2==0){
            index=(sum/2)%size;
            return index;
        }
        else{
            index=sum%size;
            return index;
        }

    }

    // ===================== INSERT (you can reuse your old version) =====================
    // Not required by this question description, but needed so table has data.
    // You can copy the insert method you already implemented in Question 2.
    public void insert(String name, int id) {
        int index = hashFunction(name);
        HashNode head = table[index];

        if (head == null) {
            table[index] = new HashNode(name, id);
            return;
        }

        HashNode current = head;
        HashNode prev = null;

        while (current != null) {
            if (current.name.equals(name)) {
                // if they want to ignore duplicates, just return
                // or update value if specified
                current.id = id;   // optional: update
                return;
            }
            prev = current;
            current = current.next;
        }

        prev.next = new HashNode(name, id);
    }

    // ===================== SEARCH =====================
    /*
        search(name) -> student ID

        1. Compute index using hashFunction(name).
        2. Traverse chain at table[index]:
               - if name matches, return that node's id.
        3. If not found, return a "not found" indicator:
               e.g., -1 (since Python's None doesn't exist in Java).
    */
    public int search(String name) {
       int index=hashFunction(name);
       HashNode current=table[index];

       while(current!=null){
        if(current.name.equals(name)){
            return current.id;
        }
        current=current.next;
    }

            System.out.println("Not found");
            return -1;
        }
       

    // ===================== DELETE =====================
    /*
        delete(name):

        1. Compute index using hashFunction(name).
        2. Traverse the chain at table[index] with (prev, current):
               - if current.name matches:
                     * if prev == null  -> removing head:  table[index] = current.next;
                     * else             -> prev.next = current.next;
                     return (found and removed)
        3. If not found, do nothing (or you may return).
    */
    public void delete(String name) {
        int index=hashFunction(name);
        HashNode current=table[index];
        HashNode prev=null;

        while(current!=null){
            if(current.name.equals(name)){
                table[index]=current.next;
            }
            else{
                prev.next=current.next;
            }
            return;
        }
        prev=current;
        current=current.next;

    }

    // ===================== DISPLAY (given / helper) =====================
    // You can adjust this to match the exact format in the question.
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            HashNode current = table[i];

            if (current == null) {
                System.out.println("None");
                continue;
            }

            boolean first = true;
            while (current != null) {
                if (!first) System.out.print(" -> ");
                System.out.print("(\"" + current.name + "\", " + current.id + ")");
                first = false;
                current = current.next;
            }
            System.out.println();
        }
    }
}
