/**
 * 
 * @LintCode: 98. Sort List
 * @Description: Sort a linked list in O(n log n) time using constant space complexity.
 * @Difficulty: Medium
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Aug 28, 2017
 * @LastEditTime: Aug 28, 2017
 *
 */
package chapter6;

public class SortList {
    
    /*
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // Merge Sort Method
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode middleNode = findMiddle(head);
        
        ListNode right = sortList(middleNode.next);
        middleNode.next = null;
        ListNode left = sortList(head);
        
        return merge(left, right);
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode walker, runner;
        walker = head;
        runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        
        return walker;
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        
        return dummy.next;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode l1 = new ListNode(4);
        
        ListNode l2 = new ListNode(5);
        l1.next = l2;
        ListNode l3 = new ListNode(1);
        l2.next = l3;
        ListNode l4 = new ListNode(8);
        l3.next = l4; 
        ListNode l5 = new ListNode(3);
        l4.next = l5;
        
        
        
        SortList s = new SortList();
        
        ListNode head = s.sortList(l1);
        while (head != null) {
            System.out.print(head.val + ",");
            
            head = head.next;
        }
    }

}
