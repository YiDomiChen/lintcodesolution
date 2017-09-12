/**
 * 
 * @LintCode: 521. Remove Duplicate Numbers in Array 
 * @Description: Given an array of integers, remove the duplicate numbers in it.
 * You should:
 * 1. Do it in place in the array.
 * 2. Move the unique numbers to the front of the array.
 * 3. Return the total number of the unique numbers.
 * @Difficulty: Easy
 * @Category: Sort, Hashtable
 * @Author: Yi Chen
 * @CreatedTime: Aug 29, 2017
 * @LastEditTime: Aug 29, 2017
 *
 */

package chapter7;

import java.util.Arrays;

public class RemoveDuplicateNumbersInArray {
    
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        
        return index + 1;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RemoveDuplicateNumbersInArray r = new RemoveDuplicateNumbersInArray();
        int[] arr = {1,3,1,4,4,2,5,7};
        int res = r.deduplication(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        System.out.print(res);
    }

}
