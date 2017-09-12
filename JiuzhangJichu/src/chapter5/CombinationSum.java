/**
 * 
 * @LintCode: 135. Combination Sum
 * @Description: Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Aug 18, 2017
 * @LastEditTime: Aug 18, 2017
 *
 */
package chapter5;

import java.util.*;
public class CombinationSum {
    
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, combination, result);
        
        return result;
    }
    
    public void helper(int[] candidates, int index,
                       int target, List<Integer> combination,
                       List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            combination.add(candidates[i]);
            helper(candidates, i, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
