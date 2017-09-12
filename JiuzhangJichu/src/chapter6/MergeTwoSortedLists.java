/**
 * 
 * @LintCode: 165. Merge Two Sorted Lists
 * @Description: Merge two sorted (ascending) linked lists and return it as a new 
 * sorted list. The new sorted list should be made by splicing together the nodes of the 
 * two lists and sorted in ascending order.
 * @Difficulty: Easy
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Aug 26, 2017
 * @LastEditTime: Aug 26, 2017
 *
 */

package chapter6;

public class MergeTwoSortedLists {
    
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        
        ListNode cur = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2.next;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
        } 
        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            
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
