Binary Search Tree (BST) Implementation in Java

This project provides an implementation of a Binary Search Tree (BST) in Java. A BST is a data structure that allows efficient insertion, deletion, and search operations. This particular implementation supports key-value pairs, where each node contains a key and an associated value.

Features

The BST in this project supports the following basic operations:
	•	Insert: Adds a key-value pair to the tree.
	•	Delete: Removes a key-value pair from the tree.
	•	Get: Retrieves the value associated with a given key.
	•	In-order Traversal: Iterates through the tree in ascending order of keys.
	•	Size: Provides the current number of nodes in the tree.

Usage

The main class is BST, which provides methods to add, retrieve, and delete key-value pairs. It also supports traversal using an in-order iterator to print the elements in ascending order.

Testing

The project includes a test class (BSTTest) that ensures the correctness of the BST class. It tests:
	•	Inserting key-value pairs into the tree.
	•	Retrieving values for given keys.
	•	Deleting nodes and ensuring the tree updates correctly.
	•	Performing an in-order traversal to visit nodes in ascending order.

Running the Tests

To verify the functionality of the BST implementation, you can run the BSTTest class. The tests will demonstrate how nodes are added, retrieved, and removed from the tree, as well as show the in-order traversal results.

Key Methods in the BST
	•	put(K key, V value): Adds a new key-value pair to the BST or updates the value if the key already exists.
	•	get(K key): Returns the value associated with a given key.
	•	delete(K key): Removes the node with the specified key.
	•	getSize(): Returns the current number of nodes in the tree.
	•	iterator(): Provides an iterator for in-order traversal.

Example Output

Running the tests will produce output showing:
	•	The size of the tree after insertions and deletions.
	•	The value associated with a given key.
	•	The result of in-order traversal, displaying the key-value pairs in ascending order.

Notes
	•	The delete method handles three possible cases:
	•	Node with no children (leaf node).
	•	Node with one child.
	•	Node with two children, where the node is replaced by its in-order successor.
	•	The tree is not self-balancing, so performance may degrade in cases where data is inserted in sorted or reverse order, potentially leading to a performance of O(n) in the worst case.
