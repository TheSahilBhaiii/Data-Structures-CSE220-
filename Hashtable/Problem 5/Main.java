public class Main {
    public static void main(String[] args) {
        HashTable5 ht = new HashTable5(10);

        ht.insert("PKG123", "In Transit");
        ht.insert("AB", "Delivered");
        ht.insert("PKG456", "Returned");

        System.out.println("\nHash table after insertions:");
        ht.display();

        ht.insert("PKG123", "Delivered");

        System.out.println("\nHash table after updates:");
        ht.display();
    }
}
