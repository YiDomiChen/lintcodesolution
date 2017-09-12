/**
 * 
 * @LintCode: 15. Permutations
 * @Description: Given a list of numbers, return all possible permutations.
 * @Difficulty: Medium
 * @Category: Recursion
 * @Author: Yi Chen
 * @CreatedTime: Aug 19, 2017
 * @LastEditTime: Aug 19, 2017
 *
 */
package chapter5;

import java.util.*;

public class Permutation {
    
    
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        List<Integer> permutation = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>(permutation));
        }
        
        helper(result, permutation, nums);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> permutation, 
                       int[] nums) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            
            permutation.add(nums[i]);
            helper(result, permutation, nums);
            permutation.remove(permutation.size() - 1);
        }
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Permutation p = new Permutation();
        int[] nums = {1,2,3};
        List<List<Integer>> result = p.permute(nums);
        for (List<Integer> permutation : result) {
            for (int num : permutation) {
                System.out.print(num + ",");
            }
            System.out.println();
        }        
    }

}
