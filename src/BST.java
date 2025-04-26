// Binary Search Tree implementation with put, get, delete, and inorder traversal functionality
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<KeyValuePair<K, V>> {
    // Node class to store key-value pairs and left/right children
    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root;
    private int size;

    // Public method to insert a key-value pair into the BST
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    // Internal method to insert a key-value pair using iterative approach
    private Node put(Node node, K key, V val) {
        Node current = node;
        Node parent = null;

        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                current.val = val;
                return node; // Key already exists, update value
            }
        }

        // If node is null, create a new node and attach to parent
        Node newNode = new Node(key, val);
        if (parent == null) {
            return newNode; // Tree is empty, return the new node
        }

        int cmp = key.compareTo(parent.key);
        if (cmp < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        size++;
        return node;
    }

    // Searches for a key and returns the associated value if found
    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.val; // Key found
            }
        }
        return null; // Key not found
    }

    // Public method to delete a node by key
    public void delete(K key) {
        root = delete(root, key);
    }

    // Internal method to handle deletion with three standard BST cases
    private Node delete(Node node, K key) {
        Node current = node;
        Node parent = null;

        // Find the node to be deleted
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                parent = current;
                current = current.left;
            } else if (cmp > 0) {
                parent = current;
                current = current.right;
            } else {
                break; // Key found
            }
        }

        if (current == null) {
            return node; // Key not found
        }

        // Case 1
        if (current.left == null) {
            if (parent == null) {
                return current.right; // Node is root
            } else if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // Case 2
        else if (current.right == null) {
            if (parent == null) {
                return current.left; // Node is root
            } else if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        // Case 3
        else {
            Node successorParent = current;
            Node successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.key = successor.key;
            current.val = successor.val;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }

        size--;
        return node;
    }

    // Returns the number of nodes in the BST
    public int getSize() {
        return size;
    }

    // Returns an iterator to traverse the BST in inorder
    @Override
    public java.util.Iterator<KeyValuePair<K, V>> iterator() {
        List<KeyValuePair<K, V>> list = new ArrayList<>();
        inorder(root, list);
        return list.iterator();
    }

    // Iterative inorder traversal using a stack, populates a list of key-value pairs
    private void inorder(Node node, List<KeyValuePair<K, V>> list) {
        Stack<Node> stack = new Stack<>();
        Node current = node;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(new KeyValuePair<>(current.key, current.val));

            current = current.right;
        }
    }
}

// Helper class to store a key-value pair, used in traversal output
class KeyValuePair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Returns the key
    public K getKey() {
        return key;
    }

    // Returns the value
    public V getValue() {
        return value;
    }
}