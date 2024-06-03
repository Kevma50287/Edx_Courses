package Tree;

import java.util.NoSuchElementException;

/**
 * Your implementation of a Tree.BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        root = recursiveAdd(root, data);
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        BSTNode<T> dummy = new BSTNode<>(null);
        root = recursiveRemove(root, data, dummy);
        return dummy.getData();
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    private BSTNode<T> recursiveAdd(BSTNode<T> currentNode, T data) {
        if (currentNode == null) {
            size++;
            return new BSTNode<>(data);
        } else if (data.compareTo(currentNode.getData()) < 0) {
            // Traverse by temporarily changing the currentNode pointer
            currentNode.setLeft(recursiveAdd(currentNode.getLeft(), data));
        } else if (data.compareTo(currentNode.getData()) > 0) {
            currentNode.setRight(recursiveAdd(currentNode.getRight(), data));
        }
        // Returns the currentNode to reconstruct the tree to original state
        return currentNode;
    }

    private BSTNode<T> recursiveRemove(BSTNode<T> currentNode, T data, BSTNode<T> dummy) {
        // If null throw an exception
        if (currentNode == null) {
            throw new NoSuchElementException();
        } else if (data.compareTo(currentNode.getData()) < 0) {
            currentNode.setLeft(recursiveRemove(currentNode.getLeft(), data, dummy));
            // if greater than the data in the current node, we recursively call remove on the right child
        } else if (data.compareTo(currentNode.getData()) > 0) {
            currentNode.setRight(recursiveRemove(currentNode.getRight(), data, dummy));
        } else {
            // Return null for leaf nodes
            size--;
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                dummy.setData(currentNode.getData());
                return null;
                // For one child on either left or right, return that child
            } else if (currentNode.getLeft() == null || currentNode.getRight() == null) {
                dummy.setData(currentNode.getData());
                return currentNode.getLeft() == null ? currentNode.getRight() : currentNode.getLeft();
                // For 2 children, return the successor
                // Take have the successor's left pointer pointing to current node left child
            } else {
                BSTNode<T> temp = new BSTNode<>(null);
                currentNode.setRight(removeSuccessor(currentNode.getRight(), temp));
                dummy.setData(currentNode.getData());
                currentNode.setData(temp.getData());
            }
        }
        // Returns the currentNode to reconstruct the original tree
        return currentNode;
    }

    private BSTNode<T> removeSuccessor(BSTNode<T> currentNode, BSTNode<T> temp) {
        if (currentNode.getLeft() == null) {
            temp.setData(currentNode.getData());
            return currentNode.getRight();
        } else {
            currentNode.setLeft(removeSuccessor(currentNode.getLeft(), temp));
        }
        return currentNode;
    }
}