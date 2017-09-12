/**
 * 
 * @LintCode: 104. Merge k Sorted List
 * @Description: 
 * Merge k sorted linked lists and return it as one sorted list.
 *
 * Analyze and describe its complexity.
 * 
 * @Difficulty: Medium
 * @Category: Divide and Conquer, Linked List, Priority Queue/Heap
 * @Author: Yi Chen
 * @CreatedTime: Sep 6, 2017
 * @LastEditTime: Sep 6, 2017
 *
 */

package chapter8;

import java.util.*;

public class MergeKSortedLists {
    
    private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {        
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };
    
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // Implemented by K Way Merge Algorithm       
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                lists.size(), listNodeComparator);
        for (int i = 0; i < lists.size(); i++) {    
            if (lists.get(i) != null) { // add the first node of each list to the heap
                heap.offer(lists.get(i));
            }
        }
        
        while (!heap.isEmpty()) {
            ListNode smallestNode = heap.poll();
            node.next = smallestNode;
            node = smallestNode;
            if (smallestNode.next != null) {
                heap.offer(smallestNode.next);  // add the smallest first node of k lists into the heap
            }            
        }
        
        return dummy.next;
    }
    
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists_DivideAndConquer(List<ListNode> lists) {
        // Implemented by Divide and Conquer
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        return mergehelper(lists, 0, lists.size() - 1);
    }
    
    public ListNode mergehelper(List<ListNode> lists, int start, int end) {
        if (start >= end) {
            return lists.get(start);
        }
        
        int mid = start + (end - start) / 2;
        
        ListNode left = mergehelper(lists, start, mid);
        ListNode right = mergehelper(lists, mid + 1, end);
        
        return mergeTwoLists(left, right);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        
        return dummy.next;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
