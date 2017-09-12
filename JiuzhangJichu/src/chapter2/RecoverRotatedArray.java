/**
 * 
 * @LintCode:
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Aug 1, 2017
 * @LastEditTime: Aug 1, 2017
 *
 */
package chapter2;
import java.util.*;
public class RecoverRotatedArray {
    
    
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        for(int i = 0; i < nums.size(); i++) {
            
        }
    }
    
    public void reverse(List<Integer> nums, int start, int end) {
        
        while(start < end) {
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            start++;
            end--;
        }
        
    }
    
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RecoverRotatedArray r = new RecoverRotatedArray();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        r.reverse(nums, 1, 3);
        for(int i : nums) {
            System.out.println(i);
        }
    }

}
