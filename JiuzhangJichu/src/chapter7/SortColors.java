/**
 * 
 * @LintCode: 148. Sort Colors
 * @Description: 
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 *
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * 
 * @Difficulty: Medium 
 * @Category: Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: Sep 1, 2017
 * @LastEditTime: Sep 1, 2017
 *
 */

package chapter7;

public class SortColors {
    
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int pl = 0, pr = nums.length - 1;
        int i = pl;
        while (i <= pr) {
            if (nums[i] == 0) {
                swap(nums, pl, i);
                i++;
                pl++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, pr, i);
                pr--;
            }
        }
        
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SortColors sc = new SortColors();
        int[] nums = {2,0,0,1,2,0,2};
        sc.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

}
