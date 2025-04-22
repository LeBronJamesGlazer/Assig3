import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<KeyValuePair<K, V>> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

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

    public void delete(K key) {
        root = delete(root, key);
    }

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

    public int getSize() {
        return size;
    }

    @Override
    public java.util.Iterator<KeyValuePair<K, V>> iterator() {
        List<KeyValuePair<K, V>> list = new ArrayList<>();
        inorder(root, list);
        return list.iterator();
    }

    // Iterative inorder traversal using a stack
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

class KeyValuePair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}