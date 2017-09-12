/**
 * 
 * @LintCode: 56. Two Sum
 * @Description: Given an array of integers, find two numbers such that 
 * they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to 
 * the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are NOT zero-based.
 * 
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Aug 29, 2017
 * @LastEditTime: Aug 29, 2017
 *
 */


package chapter7;

import java.util.*;

public class TwoSum {
    
    /*
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here                
        int[] number_sorted = new int[numbers.length];
        System.arraycopy(numbers, 0, number_sorted, 0, number_sorted.length);
        Arrays.sort(number_sorted);
        
        int start = 0, end = number_sorted.length - 1;
        while (start < end) {
            while (number_sorted[start] + number_sorted[end] > target) {
                end--;
            }
            if (number_sorted[start] + number_sorted[end] == target) {
                break;
            }
            while (number_sorted[start] + number_sorted[end] < target) {
                start++;
            }
            if (number_sorted[start] + number_sorted[end] == target) {
                break;
            }
        }
        
        int[] res = new int[2];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number_sorted[start] || 
                    numbers[i] == number_sorted[end]) {
                res[index++] = i + 1;
            }
        }
        
        Arrays.sort(res);
        return res;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TwoSum t = new TwoSum();
        int[] arr = {0,4,3,0};
        int[] res = t.twoSum(arr, 0);
        System.out.print(res[0] + "," + res[1]);
        
    }

}
