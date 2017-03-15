/**
 * Created by GozdeDogan, 7 Mart 2017, 19:05
 */
import java.util.ArrayList;

/**
 * SingleLinkedList is a class that provides some of the
 * capabilities required by the List interface using
 * a single linked list data structure.
 * Only the following methods are provided:
 * get, set, add, remove, size, toString
 * @author Koffman and Wolfgang
 *
 * remove method and deletedToString method 
 * are imlemented AND removeFirst method, removeAfter method, 
 * addFirst method, addAfter method and search method 
 * re-writed by GozdeDogan, 7 Mart 2017, 19:05
 *
 */
public class SLL<E> {

    // Nested Class
    /*<listing chapter="2" number="1">*/
    /** A Node is the building block for the SingleLinkedList */
    private static class Node<E> {

        /** The data value. */
        private E data;
        /** The link */
        private Node<E> next = null;

        /**
         * Construct a node with the given data value and link
         * @param data - The data value
         * @param next - The link
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Construct a node with the given data value
         * @param data - The data value
         */
        public Node(E data) {
            this(data, null);
        }
    }
    /*</listing>*/
    // Data fields
    /** A reference to the head of the list */
    private Node<E> head = null;
    /** The size of the list */
    private int size = 0;

    private ArrayList<Node<E>> deletedNodes = new ArrayList<Node<E>>();
    private int deletedSize = 0;

    // Helper Methods
    /** 
	 * Insert an item as the first item of the list.
     * @param item The item to be inserted
	 * Eklenmeye calisan eleman eger daha once silinmis bir elemansa
	 * bu eleman deletedNodes'un nextlerinde vardir.
	 * Bu sebeple de yeni node olusturmak yerine buradaki node'a point edilir.
     */
    private void addFirst(E item) {
        Node<E> temp = search(item);
        if(temp == null){
            head = new Node<E>(item, head);
            size++;
        }
        else {
            head = temp;
            size++;
        }
    }

    /**
     * Add a node after a given node
     * @param node The node which the new item is inserted after
     * @param item The item to insert
	 * Eklenmeye calisan eleman eger daha once silinmis bir elemansa
	 * bu eleman deletedNodes'un nextlerinde vardir.
	 * Bu sebeple de yeni node olusturmak yerine buradaki node'a point edilir.
     */
    private void addAfter(Node<E> node, E item) {
        Node<E> temp = search(item);
        if(temp == null){
            node.next = new Node<E>(item, node.next);
            size++;
        }
        else {
            node.next = temp;
            size++;
        }
    }

    /**
     * Remove the first node from the list
     * @returns The removed node's data or null if the list is empty
	 * Silinen eleman deletedNodes'a eklendi.
     */
    private E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            deletedNodes.add(new Node<E>(head.data, null));
            deletedSize++;
            head = head.next;
        }
        if (temp != null) {
            size--;
            return temp.data;
        } else {
            return null;
        }
    }

    /**
     * Remove the node after a given node
     * @param node The node before the one to be removed
     * @returns The data from the removed node, or null
     *          if there is no node to remove
	 * Silinen eleman deletedNodes'a eklendi.
     */
    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            deletedNodes.add(new Node<E>(node.next.data, null));
            deletedSize++;
            node.next = temp.next;
            size--;
            return temp.data;
        } else {
            return null;
        }
    }


	/**
	 * remove metodu mainde kullanilmak istendigi icin public olan bu metodu yazdim.
	 * Son elemanin remove etmesi saglaniyor.
	 * size'in 2 eksigine kadar gitmek gerekiyor, cunku son elemani point eden bir önceki!
	 */
    public E remove(){
        Node<E> temp = head;
        for(int i=0; i+1<size()-1; i++)
            temp=temp.next;
        return removeAfter(temp);
    }


    /**
     * Find the node at a specified index
     * @param index The index of the node sought
     * @returns The node at index or null if it does not exist
     */
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    // Public Methods
    /**
     * Get the data value at index
     * @param index The index of the element to return
     * @returns The data at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     * Set the data value at index
     * @param index The index of the item to change
     * @param newValue The new value
     * @returns The data value priviously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    /**
     * Insert the specified item at the specified position in the list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indicies)
     * @param index Index at which the specified item is to be inserted
     * @param item The item to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    /**
     * Append the specified item to the end of the list
     * @param item The item to be appended
     * @returns true (as specified by the Collection interface)
     */
    public boolean add(E item) {
        add(size, item);
        return true;
    }

// Insert solution to programming exercise 1, section 5, chapter 2 here

    /**
     * Query the size of the list
     * @return The number of objects in the list
     */
    int size() {
        return size;
    }

	/**
	 * Eklenmek istenen eleman deletedNodes listesinde varmi diye bakar
	 * varsa node return edilir, yoksa null return edilir.
	 */
    private Node<E> search(E item){
        for(int i=0; i<deletedSize; i++){
            if(deletedNodes.get(i).data.equals(item))
                return deletedNodes.get(i);
        }
        return null;
    }


    /**
     * Obtain a string representation of the list
     * @return A String representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }


	/**
	 * deletedNodes listesini string'e cevirir.
	 */
    public String deletedToString(){
        StringBuilder sb = new StringBuilder("deletedNodes -> [");
        for(int i=0; i<deletedSize; i++) {
            sb.append(deletedNodes.get(i).data.toString());
            if(i<deletedSize-1)
                sb.append(" ==> ");
        }
        sb.append("]");
        return sb.toString();
    }
}
