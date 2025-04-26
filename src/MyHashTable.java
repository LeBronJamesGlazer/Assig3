public class MyHashTable<K, V> {
    // Node class to store key-value pairs and handle collisions via chaining
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "{" + key + ": " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int size;
    private int M; // Number of chains (default to 11)

    public MyHashTable() {
        this.M = 11;
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    // Hash function to compute index for a given key
    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }
    // Adds a key-value pair to the hash table or updates it if the key exists
    public void put(K key, V value) {
        int hash = hash(key);
        HashNode<K, V> newnode = new HashNode<>(key, value);
        HashNode<K, V> head = chainArray[hash];

        for (HashNode<K, V> node = head; node != null; node = node.next) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        newnode.next = head;
        chainArray[hash] = newnode;
        size++;

    }
    // Retrieves the value associated with the given key
    public V get(K key) {
        int hash = hash(key);
        HashNode<K, V> head = chainArray[hash];
        for (HashNode<K, V> node = head; node != null; node = node.next) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }
    // Removes the key-value pair associated with the given key
    public V remove(K key) {
        int hash = hash(key);
        HashNode<K, V> head = chainArray[hash];
        HashNode<K, V> prev = null;

        for (HashNode<K, V> node = head; node != null; node = node.next) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    chainArray[hash] = node.next;

                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
        }
        return null;
    }
    // Returns the current number of key-value pairs in the hash table
    public int size() {
        return size;
    }
    // Checks if the hash table contains the specified value
    public boolean contains(V value) {
        return getKey(value) != null;
    }
    // Returns the key associated with a given value, or null if not found
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }
    // Prints the number of elements in each bucket (chain)
    public void printBuckets() {
        for (int i = 0; i < M; i++) {
            int count = 0;
            for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
                count++;
            }
            System.out.println("Bucket " + i + " has " + count + " elements.");
        }
    }
}
