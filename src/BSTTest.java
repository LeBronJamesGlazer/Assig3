public class BSTTest {
    public static void main(String[] args) {
        // Create a new BST
        BST<Integer, String> tree = new BST<>();

        // Test adding nodes
        tree.put(1, "One");
        tree.put(2, "Two");
        tree.put(3, "Three");

        // Test size
        System.out.println("Size of tree: " + tree.getSize()); // Should print 3

        // Test getting values
        System.out.println("Value for key 2: " + tree.get(2)); // Should print "Two"

        // Test deleting a node
        tree.delete(2);
        System.out.println("Size of tree after deletion: " + tree.getSize()); // Should print 2
        System.out.println("Value for key 2 after deletion: " + tree.get(2)); // Should print null

        // Test iteration (in-order traversal)
        System.out.println("In-order traversal:");
        for (KeyValuePair<Integer, String> elem : tree) { // Ensure the type is KeyValuePair
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}