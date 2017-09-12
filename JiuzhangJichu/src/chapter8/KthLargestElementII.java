/**
 * 
 * @LintCode: 606. Kth Largest Element II
 * @Description: Find K-th largest element in an array. and N is much larger than k.
 * @Difficulty: Medium
 * @Category: Heap/Priority Queue
 * @Author: Yi Chen
 * @CreatedTime: Sep 2, 2017
 * @LastEditTime: Sep 2, 2017
 *
 */

package chapter8;

import java.util.*;

public class KthLargestElementII {
    
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        
        return queue.peek();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        KthLargestElementII k = new KthLargestElementII();
        int[] nums = {1,2,3,4,5,6,7};
        System.out.print(k.kthLargestElement2(nums, 3));
    }
}
