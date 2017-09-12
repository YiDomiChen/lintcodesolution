/**
 * 
 * @LintCode: 587. Two Sum - Unique Pairs 
 * @Description: 
 * Given an array of integers, find how many unique pairs in the array 
 * such that their sum is equal to a specific target number. 
 * Please return the number of pairs.
 * 
 * @Difficulty: Medium 
 * @Category: Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: Aug 30, 2017
 * @LastEditTime: Aug 30, 2017
 *
 */
package chapter7;

import java.util.*;

public class TwoSumUniquePairs {
    
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        // Write your code here                
        Arrays.sort(nums);
        int count = 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                count++;
                start++;
                end--;
                while (start > 0 && start < end && nums[start] == nums[start - 1]) {    // remove the from 
                    start++;
                }
                while (end < nums.length - 1 && start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }            
        }
        
        return count;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1, 1, 2, 45, 46, 46};
        int target = 47;
        TwoSumUniquePairs tsup = new TwoSumUniquePairs();
        int count = tsup.twoSum6(nums, target);
        System.out.println(count);
        
        
    }

}
