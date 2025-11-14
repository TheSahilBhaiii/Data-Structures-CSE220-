public class Main {
    public static void main(String[] args) {

        HashTable2 ht = new HashTable2(5);   // choose any size you want

        // Insert test cases
        ht.insert("Alice", 101);
        ht.insert("Bob", 202);
        ht.insert("Charlie", 303);
        ht.insert("David", 404);

        // Duplicate insert (should show message)
        ht.insert("Alice", 555);

        System.out.println("\n--- Hash Table After Insertions ---");
        ht.display();

        // Search tests
        System.out.println("\n--- Search Results ---");
        System.out.println("Search Alice   -> " + ht.search("Alice"));
        System.out.println("Search Bob     -> " + ht.search("Bob"));
        System.out.println("Search Eve     -> " + ht.search("Eve"));  // not found

    }
}
