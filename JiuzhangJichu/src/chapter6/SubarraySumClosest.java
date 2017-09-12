/**
 * 
 * @LintCode: 139. Subarray Sum Closet
 * @Description: Given an integer array, find a subarray with sum closest to zero. 
 * Return the indexes of the first number and last number.
 * @Difficulty: Medium
 * @Category: Sort, Subarray
 * @Author: Yi Chen
 * @CreatedTime: Aug 26, 2017
 * @LastEditTime: Aug 26, 2017
 *
 */

package chapter6;

import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumClosest {
    
    public class Pair {
        int sum;
        int index;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    
    
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        if (len == 1) {
            res[0] = 0;
            res[1] = 0;
            
            return res;
        }
        
        Pair[] sums = new Pair[len + 1];
        sums[0] = new Pair(0, 0);
        int prev = 0;
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }
        
        Arrays.sort(sums, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {                
                return a.sum - b.sum;
            }
        });
        
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            if (ans > sums[i].sum - sums[i - 1].sum) {
                ans = sums[i].sum - sums[i - 1].sum;
                res[0] = Math.min(sums[i].index, sums[i - 1].index);
                res[1] = Math.max(sums[i].index, sums[i - 1].index) - 1;
            }
        }
        Character.isLetter('d');
        return res;
    }
        
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {-3, 1, 1, -3, 5};
        SubarraySumClosest s = new SubarraySumClosest();
        int[] res = s.subarraySumClosest(nums);
        System.out.print(res[0] + ", " + res[1]);
    }

}
