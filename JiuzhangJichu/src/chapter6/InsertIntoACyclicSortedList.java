/**
 * 
 * @LintCode: 599. Insert Into a Cyclic Sorted List 
 * @Description: Given a node from a cyclic linked list which has been sorted, 
 * write a function to insert a value into the list such that it remains a cyclic 
 * sorted list. The given node can be any single node in the list. 
 * Return the inserted new node.
 * 
 * @Difficulty: Easy 
 * @Category: Linked List
 * @Author: Yi Chen
 * @CreatedTime: Aug 26, 2017
 * @LastEditTime: Aug 26, 2017
 *
 */

package chapter6;

public class InsertIntoACyclicSortedList {

    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            ListNode singleNode = new ListNode(x);
            singleNode.next = singleNode;
            
            return singleNode;
        }
        
        ListNode p = node;
        do {
            if (x >= p.val && x <= p.next.val) {
                break;
            }
            if (p.val > p.next.val && 
                    (x < p.next.val || x > p.val)) {
                break;
            }           
            
            p = p.next;
        } while (p != node);    // end the loop when it goes through all the nodes
        
        ListNode insNode = new ListNode(x);
        insNode.next = p.next;
        p.next = insNode;
        
        return insNode;
    }
<<<<<<< HEAD
    
    
=======
	
	
>>>>>>> 37ed36ebc8b09923cf6486f86f524482ff1a967d
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
