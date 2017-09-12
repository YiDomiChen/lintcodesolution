/**
 * 
 * @LintCode: 41. Maximum Subarray
 * @Description: Given an array of integers, find a contiguous subarray which has the largest sum.
 * @Difficulty: Easy
 * @Category: Greedy, Array, Subarray
 * @Author: Yi Chen
 * @CreatedTime: Aug 25, 2017
 * @LastEditTime: Aug 25, 2017
 *
 */

package chapter6;

public class MaximumSubArray {
    
    /*
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // O(1) space complexity
        // O(n) time complexity
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            sum = Math.max(0, sum);
        }
        
        return result;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }

}
