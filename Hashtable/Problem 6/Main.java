public class Main {
    public static void main(String[] args) {
        HashTable6 ht = new HashTable6(7);

        ht.insert("S1", 85);
        ht.insert("A", 90);
        ht.insert("S2", 78);

        System.out.println("\nHash table after insertions:");
        ht.display();

        ht.insert("S1", 88);

        System.out.println("\nHash table after update:");
        ht.display();
    }
}
