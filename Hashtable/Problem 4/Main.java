public class Main {
    public static void main(String[] args) {

        HashTable4 ht = new HashTable4(5);

        // Insert sample records (as if many inserts happened earlier)
        ht.insert("Bob", 135927);
        ht.insert("Charlie", 348247);
        ht.insert("Alice", 123456);
        ht.insert("David", 124382);

        System.out.println("Hash table after insertions:\n");
        ht.display();

        // Search operation
        int davidID = ht.search("David");
        if (davidID != -1)
            System.out.println("\nID of David is " + davidID);
        else
            System.out.println("\nDavid not found");

        // Delete Alice
        ht.delete("Alice");

        System.out.println("\nHash table after deletions:\n");
        ht.display();
    }
}
