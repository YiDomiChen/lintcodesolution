/**
 * 
 * @LintCode: 134. LRU Cache
 * @Description: 
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key 
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used 
 * item before inserting a new item.
 * 
 * @Difficulty: Hard
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Sep 7, 2017
 * @LastEditTime: Sep 7, 2017
 *
 */

package chapter8;

import java.util.*;

public class LRUCache {
    
    private class Node {
        Node next;
        Node prev;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    
    private int capacity;
    private HashMap<Integer, Node> hash = new HashMap<>();
    private Node tail = new Node(-1, -1);
    private Node head = new Node(-1, -1);
    
    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!hash.containsKey(key)) {
            return -1;
        }
        
        Node cur = hash.get(key);
        // remove current node from the list
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        
        moveToTail(cur);
        
        return hash.get(key).value;
    }
    
    public void set(int key, int value) {
        // this internal `get` method will update the key's position in the linked list.
        if (get(key) != -1) {
            hash.get(key).value = value;
            
            return;
        }
        
        if (hash.size() == capacity) {
            hash.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        // insert new key into cache
        Node insert = new Node(key, value);
        hash.put(key, insert);
        moveToTail(insert);
    }
    
    private void moveToTail(Node cur) {
        // move current node to the tail
        cur.prev = tail.prev;
        tail.prev = cur;
        cur.prev.next = cur;
        cur.next = tail;
    }
    
    // @param key, an integer
    // @param value, an integer
    // @return nothing    
    public void printLRUList() {
        
        Node n = head.next;
        while (n != null) {
            System.out.print(n.key + "->");
            n = n.next;
        }
        
        System.out.println("null");        
        System.out.println("List printed");
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LRUCache lru = new LRUCache(3);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.set(4, 4);        
        System.out.println(lru.get(4));
        lru.set(3, 5);
        lru.printLRUList();
    }

}
