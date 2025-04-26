import java.util.Random;

// Demonstrates usage of MyHashTable with randomly generated key-value pairs
public class Main {
    // Entry point: populates the hash table with random entries and prints bucket distribution
    public static void main(String[] args) {
        // Create a hash table with MyTestingClass as key and String as value
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        Random rand = new Random();
        // Insert 1000 random key-value pairs into the hash table
        for (int i = 0; i < 1000; i++) {
            String keyName = "Key" + rand.nextInt(10000);
            int keyId = rand.nextInt(10000);
            MyTestingClass key = new MyTestingClass(keyName, keyId);
            String value = "Value" + rand.nextInt(10000);

            table.put(key, value);
        }

        // Print the number of elements in each bucket to observe hash distribution
        table.printBuckets();
    }
}