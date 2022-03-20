/*@Purpose : Ability to find frequency of words in a large paragraph phrase “Paranoids are not
 * paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations”
 * - Use hashcode to find index of the words in the para
 * - Create LinkedList for each index and store the words and its frequency
 * - Use LinkedList to do the Hash Table Operation
 * - To do this create MyMapNode with Key Value Pair and create LinkedList of MyMapNode
 * @File : Data Structure Using Hash Table
 * @Author : Lokesh BS
 */
package com.bridgelabz;

public class HashTableImplementation<K, V> {
    Node head;
    Node tail;

    public void add(K key, V value) {
        Node<K, V> myNode = searchNode(key);
        if (myNode == null) {
            myNode = new Node<K, V>(key, value);
            this.append(myNode);
        } else {
            myNode.setValue(value);
        }
    }

    // Append the value in the linked list
    public void append(Node<K, V> myNode) {
        if (this.head == null)
            this.head = myNode;
        if (this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    // Searching for the word in the linked list
    public Node<K, V> searchNode(K data) {
        Node<K, V> currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            if (currentNode.getKey().equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    // Searching for the word and get the value from the linked list
    public V get(K word) {
        Node<K, V> myMapNode = searchNode(word);
        if (myMapNode == null) {
            return null;
        } else {
            return myMapNode.getValue();
        }

    }

    // Print the linked list
    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head + "} ";
    }
}
