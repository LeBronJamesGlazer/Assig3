import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();

        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            String keyName = "Key" + rand.nextInt(10000);
            int keyId = rand.nextInt(10000);
            MyTestingClass key = new MyTestingClass(keyName, keyId);
            String value = "Value" + rand.nextInt(10000);

            table.put(key, value);
        }

        table.printBuckets();
    }
}