/**
 * 
 * @LintCode: Two Sum - Input array is sorted
 * @Description: Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to 
 * the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * @Difficulty: Medium
 * @Category: Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: Aug 30, 2017
 * @LastEditTime: Aug 30, 2017
 *
 */
package chapter7;

public class TwoSumSortedInputArray {
    
    /*
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (nums[start] + nums[end] > target) {
                end--;
            }
            if (nums[start] + nums[end] == target) {
                break;
            }
            while (nums[start] + nums[end] < target) {
                start--;
            }
            if (nums[start] + nums[end] == target) {
                break;
            }
        }
        
        int[] res = new int[2];
        res[0] = start + 1;
        res[1] = end + 1;
        
        return res;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
