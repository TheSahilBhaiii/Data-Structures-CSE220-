class HashNode {
    String key;
    String value;
    HashNode next;

    HashNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable5 {
    private HashNode[] table;
    private int size;

    public HashTable5(int size) {
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
                sum+=(int)'X';
            }
            
            index=sum%size;
        }
    
        return index; 
    }

    // ===================== INSERT =====================
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

    // ===================== DISPLAY (already implemented in task) =====================
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
