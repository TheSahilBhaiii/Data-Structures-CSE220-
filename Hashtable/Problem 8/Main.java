public class Main {
    public static void main(String[] args) {

        HashTable8 ht = new HashTable8(10);

        ht.insert("P123", 19.99f);
        ht.insert("AB", 15.50f);
        ht.insert("P456", 25.75f);

        System.out.println("\nHash table after insertions:");
        ht.display();

        ht.insert("P123", 21.99f);

        System.out.println("\nHash table after update:");
        ht.display();
    }
}
