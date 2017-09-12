/**
 * 
 * @LintCode: 17. Subsets 
 * @Description: Given a set of distinct integers, return all possible subsets.
 *  .Notice
    .. Elements in a subset must be in non-descending order.
    .. The solution set must not contain duplicate subsets.
 * 
 * @Difficulty: Medium
 * @Category: Recursion
 * @Author: Yi Chen
 * @CreatedTime: Aug 1, 2017
 * @LastEditTime: Aug 1, 2017
 *
 */
package chapter1;

import java.util.*;

public class Subsets {
    
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums == null) {
            return result;
        }
        if(nums.length == 0) {
            ArrayList<Integer> subset = new ArrayList<>();
            result.add(subset);
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        helper(nums, 0, result, subset);
        
        return result;
    }
    
    private void helper(int[] nums, int startIndex, ArrayList<ArrayList<Integer>> result, 
            ArrayList<Integer> subset) {
        result.add(new ArrayList<Integer>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i + 1, result, subset);
            subset.remove(subset.size() - 1);
        }
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = {1,2,3,4};
        Subsets subsets = new Subsets();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res = subsets.subsets(num);
        
        for(ArrayList<Integer> a : res) {
            for(int n : a) {
                System.out.print("" + n + ",");
            }
            System.out.println();
        }
        
    }

}
