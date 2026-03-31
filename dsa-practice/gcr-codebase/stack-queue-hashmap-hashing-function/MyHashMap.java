public class MyHashMap {

    // Node class
    private static class Node {
        int key;     
        int value;     
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Fixed size for the hash table
    private final int size = 1000;
    private Node[] table = new Node[size];

    // Hash function to map a key to an index
    private int hash(int key) {
        return key % size;
    }

    // Insert or update key-value pair
    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];

        // If no node exists, create new node
        if (head == null) {
            table[index] = new Node(key, value);
            return;
        }

        // Traverse the linked list at this index
        Node current = head;
        while (current != null) {
            // If key already exists, update value
            if (current.key == key) {
                current.value = value;
                return;
            }
            // Move to next node
            if (current.next == null) break;
            current = current.next;
        }

        // If key not found, add new node at the end
        current.next = new Node(key, value);
    }

    // Retrieve value for a given key
    public int get(int key) {
        int index = hash(key);
        Node current = table[index];

        // Traverse linked list at this index
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    // Remove key-value pair
    public void remove(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                // If node to delete is the first node
                if (prev == null) {
                    table[index] = current.next;
                } 
                else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Main method to test the HashMap
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        // Adding key-value pairs
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);

        // Retrieving values
        System.out.println("Value for key 1: " + map.get(1));       
        System.out.println("Value for key 2: " + map.get(2));      
        System.out.println("Value for key 3: " + map.get(3));
        System.out.println("Value for key 4: " + map.get(4));   

        // Removing a key
        map.remove(1);
        System.out.println("Value for key 1 after removal: " + map.get(1));
    }
}
