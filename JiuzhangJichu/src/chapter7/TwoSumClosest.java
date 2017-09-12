/**
 * 
 * @LintCode: 533. Two Sum - Closest to target
 * @Description: 
 * Given an array nums of n integers, find two integers in nums such that the sum is 
 * closest to a given number, target.
 * 
 * Return the difference between the sum of the two integers and the target.
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

public class TwoSumClosest {
    
    /*
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return Integer.MAX_VALUE;
        }
        
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while (start < end) {
            minDiff = Math.min(Math.abs(nums[start] + nums[end] - target),
                    minDiff);
            if (nums[start] + nums[end] == target) {
                return 0;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }            
        }
        
        return minDiff;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {-1,2,1,-4};
        int target = 4;
        TwoSumClosest tsc = new TwoSumClosest();
        System.out.println(tsc.twoSumClosest(nums, target));
    }

}
