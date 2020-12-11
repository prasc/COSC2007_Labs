public class HashTable {

    private class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    Node[] hashTable;
    int sizeOfTable = 50;
    int currentSize = 0;

    public HashTable() {
        hashTable = new Node[sizeOfTable];
    }

    public int hashCode(int key) {
        return key % sizeOfTable;
    }

    public Node search(int key) {
        // take the key, get the index where the value should be
        // based on that key

        int hashIndex = hashCode(key);

        // while value at the index where the value from the key should be is not null
        while(hashTable[hashIndex] != null) {

            // check if the key at this index is a match with the key, the user inputted
            if (hashTable[hashIndex].key == key) {
                // if it is, we've found the index for the item
                return hashTable[hashIndex];
            }

            // if the key was not a match, increment index
            hashIndex++;

            hashIndex = hashCode(hashIndex);
        }
        return null;
    }

    public void insert(int key, int value) {
        Node newNode = new Node(key, value);

        int hashIndex = hashCode(key);

        while (hashTable[hashIndex] != null && hashTable[hashIndex].key != -1) {
            hashIndex++;

            hashIndex = hashCode(hashIndex);
        }
        hashTable[hashIndex] = newNode;
        currentSize++;

    }

    public Node delete(int key, int value) {

        int hashIndex = hashCode(key);

        while (hashTable[hashIndex] != null) {
            if (hashTable[hashIndex].key == key && hashTable[hashIndex].value == value) {
                Node temp = hashTable[hashIndex];

                hashTable[hashIndex] = null;
                currentSize--;
                return temp;
            }

            hashIndex++;
            hashIndex = hashCode(hashIndex);

        }
        return null;
    }

    public void displayHashTable() {


        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                System.out.print("Key: " + hashTable[i].getKey() + " ");
                System.out.print("Value: " + hashTable[i].getValue());
                System.out.println();
            }
        }

    }
}
