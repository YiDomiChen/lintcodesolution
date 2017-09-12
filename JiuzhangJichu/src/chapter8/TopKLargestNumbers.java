/**
 * 
 * @LintCode: 544. Top k Largest Numbers
 * @Description: Given an integer array, find the top k largest numbers in it.
 * @Difficulty: Medium
 * @Category: Heap/Priority Queue
 * @Author: Yi Chen
 * @CreatedTime: Sep 2, 2017
 * @LastEditTime: Sep 2, 2017
 *
 */

package chapter8;

import java.util.*;

public class TopKLargestNumbers {
    
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        Comparator<Integer> cmp = new Comparator<Integer>() {            
            @Override
            public int compare(Integer x, Integer y) {
                // TODO Auto-generated method stub
                return x - y;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, cmp); 
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        
        return res;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TopKLargestNumbers t = new TopKLargestNumbers();
        int[] nums = {3,10,1000,-99,4,100};
        int[] res = t.topk(nums, 3);
        for (int num : res) {
            System.out.println(num + ",");
        }
    }

}
