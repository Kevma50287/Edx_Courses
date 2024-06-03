package Tree;

import java.util.List;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a Tree.BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> list = new LinkedList<>();
        preorderRecursiveAdd(root, list);
        return list;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a Tree.BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> list = new LinkedList<>();
        inorderRecursiveAdd(root, list);
        return list;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a Tree.BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> list = new LinkedList<>();
        postorderRecursiveAdd(root, list);
        return list;
    }

    private List<T> preorderRecursiveAdd(TreeNode<T> root, List<T> list) {
        if (root!= null) {
            list.add(root.getData());
            preorderRecursiveAdd(root.getLeft(), list);
            preorderRecursiveAdd(root.getRight(), list);
        }
        return list;
    }

    private List<T> inorderRecursiveAdd(TreeNode<T> root, List<T> list) {
        if (root!= null) {
            inorderRecursiveAdd(root.getLeft(), list);
            list.add(root.getData());
            inorderRecursiveAdd(root.getRight(), list);
        }
        return list;
    }

    private List<T> postorderRecursiveAdd(TreeNode<T> root, List<T> list) {
        if (root!= null) {
            postorderRecursiveAdd(root.getLeft(), list);
            postorderRecursiveAdd(root.getRight(), list);
            list.add(root.getData());
        }
        return list;
    }
}