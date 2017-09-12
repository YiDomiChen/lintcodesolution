/**
 * 
 * @LintCode: 450. Reverse nodes in k-group
 * @Description: 
 * Given a linked list, reverse the nodes of a linked list k at a time and 
 * return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should 
 * remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed. 
 * Only constant memory is allowed.

 * @Difficulty: Hard 
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Aug 29, 2017
 * @LastEditTime: Aug 29, 2017
 *
 */
package chapter6;

public class ReverseNodesInKGroup {
    
    /*
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        head = dummy;
        while (true) {
            head = reverseK(head, k);
            if (head == null) {
                break;
            }
        }
        
        return dummy.next;
    }
    
    
    // head->n1->n2->n3->...->nk->nk+1 ==>>
    // head->nk->nk-1->...->n2->n1->nk+1
    // return n1
    public ListNode reverseK(ListNode head, int k) {
        //get kth and (k + 1)th node
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }
        if (nk == null) {
            return null;
        }
        
        ListNode nkplus = nk.next;
        ListNode n1 = head.next;
        
        //reverse the node
        ListNode prev = null;
        ListNode cur = n1;
        while (cur != nkplus) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        head.next = nk;
        n1.next = nkplus;
        
        return n1;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
