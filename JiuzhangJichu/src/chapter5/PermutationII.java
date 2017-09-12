/**
 * 
 * @LintCode: 16. Permutation II
 * @Description: Given a list of numbers with duplicate number in it. 
 * Find all unique permutations.
 * @Difficulty: Medium
 * @Category: DFS
 * @Author: Yi Chen
 * @CreatedTime: Aug 20, 2017
 * @LastEditTime: Aug 20, 2017
 *
 */
package chapter5;

import java.util.*;

public class PermutationII {

    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        List<Integer> permutation = new ArrayList<>();
        if (nums.length == 0) {
            result.add(permutation);
        }
        
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        helper(result, permutation, visited, nums);
        
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> permutation, 
                       int[] visited, int[] nums) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            
            visited[i] = 1;
            permutation.add(nums[i]);
            helper(result, permutation, visited, nums);
            permutation.remove(permutation.size() - 1);
            visited[i] = 0;
        }
    }    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
