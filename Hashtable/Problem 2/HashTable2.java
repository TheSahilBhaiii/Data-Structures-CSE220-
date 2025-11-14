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

class HashTable2 {
    private HashNode[] table;
    private int size;

    public HashTable2(int size) {
        this.size = size;
        table = new HashNode[size];
    }

    // ===================== HASH FUNCTION =====================
    private int hashFunction(String name) {
        int sum = 0;
        int index;

        for (int i = 0; i < name.length(); i++) {
            int ascii = (int) name.charAt(i);
            sum += ascii;
        }

        if (sum % 2 == 0) {
            index = (sum / 2) % size;
        } else {
            index = sum % size;
        }

        return index;
    }

    // ===================== INSERT =====================
    public void insert(String name, int id) {
        int index = hashFunction(name);
        HashNode head = table[index];

        if (head == null) {
            table[index] = new HashNode(name, id);
            return;
        } else {
            HashNode current = head;
            HashNode prev = null;

            while (current != null) {
                if (current.name.equals(name)) {
                    System.out.println("Student already exists");
                    return;                 // discard insertion
                }
                prev = current;
                current = current.next;
            }

            prev.next = new HashNode(name, id);   // append at end
        }
    }

    // ===================== SEARCH =====================
    public int search(String name) {
        int index = hashFunction(name);
        HashNode current = table[index];

        while (current != null) {
            if (current.name.equals(name)) {
                return current.id;
            }
            current = current.next;
        }
        return -1;     // not found (we won't hit this for David in your test)
    }

    // ===================== DISPLAY =====================
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
                if (first) {
                    System.out.print("(\"" + current.name + "\", " + current.id + ")");
                    first = false;
                } else {
                    System.out.print(" -> (\"" + current.name + "\", " + current.id + ")");
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
