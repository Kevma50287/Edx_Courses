import java.util.NoSuchElementException;

/**
 * LinkedList
 */
public class LinkedList<T> implements List<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size = 0;

  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

  public Node<T> getHead() {
    return head;
  }

  public Node<T> getTail() {
    return tail;
  }

  /**
   * Adds the passed in data to the specified index.
   * @param data  the data to add to the List
   * @param index the index to add at
   */
  @Override
  public void addAtIndex(T data, int index) {
    if (index < 0 || index > this.size) {
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }

    if (data == null) {
      throw new IllegalArgumentException("You cannot add null data to the list");
    }

    Node<T> newNode = new Node<T>(data);
    
    // If at index 0, then we adjust for the head
    if (index == 0) {
      newNode.setNext(this.head);
      this.head = newNode;

      // Edge case where the new node at index 0, is also the first node in the linkedlist
      // This node is now the head and the tail
      if (size == 0) {
        this.tail = newNode;
      }
    } else {
      Node<T> previous = this.head;
      for (int i = 1; i < index; i++) {
        previous = previous.getNext();
      }
      newNode.setNext(previous.getNext());
      previous.setNext(newNode);
      if (newNode.getNext() == null) {
        this.tail = newNode;
      }
    }
    this.size++;
  }

  /**
   * Retrieves the data of the node that's specified.
   * @param index the index of the node whose data we are retrieving
   */
  @Override
  public T getAtIndex(int index) {
    if (index < 0 || index >= this.size) {
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }

    Node<T> current = this.head;
    int count = 0;
    while (count < index) {
      current = current.getNext();
      count++;
    }
    return current.getData();
  }

  /**
   * Removes the data at the specified index and returns the data that was removed.
   * @param index removes the Node at this index
   */
  @Override
  public T removeAtIndex(int index) {
    if (index < 0 || index > this.size - 1) {
      throw new IllegalArgumentException("Your index is out of bounds");
    }

    Node<T> previous = null;
    Node<T> current = this.head;
    int count = 0;
    if (index == 0) {
      this.head = this.head.getNext();
      if (this.size == 1) {
        this.tail = null;
      }
    } else {
      while (count < index) {
        previous = current;
        current = previous.getNext();
        count ++;
      }
  
      // Perform switch
      previous.setNext(current.getNext());
    }
    
    this.size--;

    return current.getData();
  }

  /**
   * Removes the Node with the data passed in if a Node containing the data exists.
   * @param data the data to remove from the List
   */
  @Override
  public T remove(T data) {
    if (data == null) {
      throw new IllegalArgumentException("You cannot add null data to the list");
    }
    Node<T> current = this.head;
    boolean found = false;
    int index = 0;
    for (int i = 0; i < this.size; i++) {
      if (current.getData() == data) {
        found = true;
        break;
      } else {
        current = current.getNext();
        index++;
      }
    }

    if (found) {
      return removeAtIndex(index);
    } else {
      throw new NoSuchElementException("The data is not present in the list");
    }
  }

  @Override
  public void clear() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public int size() {
    return this.size;
  }
  
}