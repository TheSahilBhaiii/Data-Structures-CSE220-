public class Main {
    public static void main(String[] args) {

        HashTable3 ht = new HashTable3(4);

        ht.insert("E123", "HR");
        ht.insert("BA", "Finance");
        ht.insert("XY", "Engineering");
        ht.insert("YX", "Marketing");

        System.out.println("\nHash table after insertions with collisions:");
        ht.display();

        ht.insert("E123", "Admin");

        System.out.println("\nHash table after update:");
        ht.display();
    }
}
