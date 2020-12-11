public class TestHashTable {

    public static void main(String[] args) {
        HashTable ht = new HashTable();

        ht.insert(1, 50);
        ht.insert(2, 60);
        ht.insert(4, 5);
        ht.insert(1, 49);

        ht.displayHashTable();

        ht.delete(4, 5);

        System.out.println();
        System.out.println("After deleting (4, 5)");
        ht.displayHashTable();
        System.out.println();

        System.out.println("Search function, searching for key 2: " + ht.search(2));

    }

}
