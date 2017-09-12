/**
 * 
 * @LintCode: 129. Rehashing 
 * @Description: For details, see http://www.lintcode.com/en/problem/rehashing/ 
 * @Difficulty: Medium
 * @Category: HashTable
 * @Author: Yi Chen
 * @CreatedTime: Sep 4, 2017
 * @LastEditTime: Sep 4, 2017
 *
 */
package chapter8;



public class Rehashing {
    
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length <= 0) {
            return hashTable;
        }
        
        ListNode[] res = new ListNode[hashTable.length * 2];
        
        for (ListNode node : hashTable) {
            while (node != null) {
                int newPos = (node.val % res.length + res.length) % res.length;    // considering the case of negative nums
                if (res[newPos] == null) {
                    ListNode newNode = new ListNode(node.val);
                    res[newPos] = newNode;
                } else {
                    ListNode prev = res[newPos];
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    ListNode newNode = new ListNode(node.val);
                    prev.next = newNode;
                }
                
                node = node.next;
            }
        }
        
        return res;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int k = -18 % 8;
        System.out.println(k);
    }

}
