/**
 * 
 * @LintCode:
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Aug 31, 2017
 * @LastEditTime: Aug 31, 2017
 *
 */
package chapter7;

public class KthSmallestNumbersInUnsortedArray {
    
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return quickSelect(k, 0, nums.length - 1, nums);
    }
    
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int quickSelect(int k, int start, int end, int[] nums) {
        // write your code here
        if (start == end) {
            return nums[start];
        }
        
        int left = start, right = end;
        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                
                left++;
                right--;
            }
        }
        
        // 3 cases
        if (start + k - 1 <= right) {    // the kth smallest num is at left
            return quickSelect(k, start, right, nums);
        } else if (start + k - 1 >= left) {    // the kth smallest num is at right
            return quickSelect(k - (left - start), left, end, nums);
        }
        
        return nums[right + 1];    // the kth num is at the loc where loop ends.
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {3,4,1,2,5};
        int target = 3;
        KthSmallestNumbersInUnsortedArray k = new KthSmallestNumbersInUnsortedArray();
        System.out.println(k.kthSmallest(target, nums));
    }

}
