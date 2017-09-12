/**
 * 
 * @LintCode: 138. Subarray Sum
 * @Description: Given an integer array, find a subarray where the sum of numbers is zero. 
 * Your code should return the index of the first number and the index of the last number.
 * @Difficulty: Easy
 * @Category: HashTable Subarray
 * @Author: Yi Chen
 * @CreatedTime: Aug 25, 2017
 * @LastEditTime: Aug 25, 2017
 *
 */

package chapter6;

import java.util.*;

public class SubarraySum {
    
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(-1);
            res.add(-1);
            
            return res;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res.add(map.get(sum) + 1);
                res.add(i);
                
                return res;
            }
            
            map.put(sum, i);
        }
        
        return res;        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
