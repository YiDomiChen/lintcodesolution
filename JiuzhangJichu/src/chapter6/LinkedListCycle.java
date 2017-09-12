/**
 * 
 * @LintCode: 102. Linked List Cycle
 * @Description: Given a linked list, determine if it has a cycle in it.
 * @Difficulty: Medium
 * @Category: Linked List, Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: Aug 25, 2017
 * @LastEditTime: Aug 25, 2017
 *
 */
package chapter6;

public class LinkedListCycle {
    
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        ListNode walker = head, runner = head;
        while (runner != null && runner.next != null) {
            if (walker == runner) {
                return true;
            }
            
            walker = walker.next;
            runner = runner.next.next;
        }
        
        return false;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
