/**
 * 
 * @LintCode: 18. Subsets II
 * @Description: Given a list of numbers that may has duplicate numbers, 
 * return all possible subsets
 * @Difficulty: Medium
 * @Category: Recursion
 * @Author: Yi Chen
 * @CreatedTime: Aug 1, 2017
 * @LastEditTime: Aug 1, 2017
 *
 */
package chapter1;
import java.util.*;

public class SubsetII {
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        if(nums == null) {
            return result;
        }
        if(nums.length == 0) {
            result.add(subset);
            return result;
        }
        Arrays.sort(nums);
        helper(nums, 0, result, subset);
        
        return result;
    }
    
    private void helper(int[] nums, int startIndex, ArrayList<ArrayList<Integer>> result, 
            ArrayList<Integer> subset) {
        result.add(new ArrayList<>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }
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
        SubsetII subsetII = new SubsetII();
        int[] nums = {2,2,3};
        
        ArrayList<ArrayList<Integer>> result = subsetII.subsetsWithDup(nums);
        for(ArrayList<Integer> subset : result) {
            for(int elem : subset) {
                System.out.print(String.valueOf(elem) + " ");
            }
            System.out.println();
        }
    }

}
