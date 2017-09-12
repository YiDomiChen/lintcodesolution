/**
 * 
 * @LintCode: 609. Two Sum - Less than or equal to target
 * @Description: Given an array of integers, find how many pairs in the array such that 
 * their sum is less than or equal to a specific target number. 
 * Please return the number of pairs.
 * @Difficulty: Medium
 * @Category: Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: Aug 30, 2017
 * @LastEditTime: Aug 30, 2017
 *
 */

package chapter7;

import java.util.*;

public class TwoSumLessOrEqualToTarget {
    
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here       
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int count = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target) {
                end--;
            } else {
                start++;
                count += end - start;
            }
        }
        
        return count;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
