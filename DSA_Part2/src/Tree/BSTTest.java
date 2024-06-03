package Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class BSTTest {

    @Test
    void add_WhenDataIsNull_ShouldThrowIllegalArgumentException() {
        BST<Integer> bst = new BST<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> bst.add(null));
    }

    @Test
    void add_WhenDataIsAddedToAnEmptyTree_ShouldAddTheDataAsALeafNode() {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        Assertions.assertEquals(1, bst.size());
        Assertions.assertEquals(5, bst.getRoot().getData());
    }

    @Test
    void remove_WhenDataIsNull_ShouldThrowIllegalArgumentException() {
        BST<Integer> bst = new BST<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> bst.remove(null));
    }

    @Test
    void remove_WhenDataDoesNotExistInTree_ShouldThrowNoSuchElementException() {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        Assertions.assertThrows(NoSuchElementException.class, () -> bst.remove(10));
    }

    @Test
    void remove_WhenDataExistsInATreeWithOneNode_ShouldRemoveTheNodeAndReturnTheData() {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        Integer data = bst.remove(5);
        Assertions.assertEquals(0, bst.size());
        Assertions.assertEquals(5, data);
    }

    @Test
    void remove_WhenDataExistsInATreeWithTwoNodes_ShouldRemoveTheNodeAndReturnTheData() {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(10);
        Integer data = bst.remove(10);
        Assertions.assertEquals(1, bst.size());
        Assertions.assertEquals(5, bst.getRoot().getData());
        Assertions.assertEquals(10, data);
    }

    @Test
    void remove_WhenDataExistsInATreeWithTwoNodes_ShouldReplaceTheNodeWithItsSuccessor() {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(10);
        bst.remove(10);
        Assertions.assertEquals(1, bst.size());
        Assertions.assertEquals(5, bst.getRoot().getData());
    }

    @Test
    void remove_WhenDataExistsInATreeWithThreeNodes_ShouldReplaceTheNodeWithItsSuccessor() {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(10);
        bst.add(15);
        bst.remove(10);
        Assertions.assertEquals(2, bst.size());
        Assertions.assertEquals(5, bst.getRoot().getData());
        Assertions.assertEquals(15, bst.getRoot().getRight().getData());
    }
}