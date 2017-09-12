/**
 * 
 * @LintCode: 57. 3Sum
 * @Description: Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * @Difficulty: Medium
 * @Category: Two Pointers
 * @Author: Yi Chen
 * @CreatedTime: Aug 30, 2017
 * @LastEditTime: Aug 30, 2017
 *
 */


package chapter7;

import java.util.*;

public class ThreeSum {
    
    /*
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            // skip duplicate number at left position
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int target = 0 - numbers[i];
            int left = i + 1, right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(numbers[i]);
                    triplet.add(numbers[left]);
                    triplet.add(right);
                    
                    res.add(triplet);
                    
                    left++;
                    right--;
                    // skip duplicate number at middle position
                    while (left < right && numbers[left] == numbers[left - 1]) {    
                        left++;
                    }
                    // skip duplicate number at right position
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right--;                        
                    }
                } else if (numbers[left] + numbers[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
            
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
