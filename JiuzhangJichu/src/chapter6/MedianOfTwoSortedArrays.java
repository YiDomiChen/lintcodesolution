/**
 * 
 * @LintCode: 65. Median of Two Sorted Arrays
 * @Description: There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays.
 * @Difficulty: Hard
 * @Category: Array
 * @Author: Yi Chen
 * @CreatedTime: Aug 28, 2017
 * @LastEditTime: Aug 28, 2017
 * 
 */

package chapter6;

public class MedianOfTwoSortedArrays {

    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int length = (A.length + B.length) / 2;
        double res;
        if (length % 2 == 1) {
            res = findKth(A, 0, B, 0, length / 2);
        } else {
            res = (findKth(A, 0, B, 0, length / 2) + findKth(A, 0, B, 0, length / 2 + 1)) / 2.0;
        }
        
        return res;
    }
    
    public int findKth(int[] A, int a_start_index, int[] B, int b_start_index, int k) {
        if (a_start_index >= A.length) {
            return B[b_start_index + k - 1];
        }
        if (b_start_index >= B.length) {
            return A[a_start_index + k - 1];
        }
        if (k == 1) {
            return Math.min(A[a_start_index], B[b_start_index]);
        }
        
        int a_key = a_start_index + k / 2 - 1 < A.length ?
                A[a_start_index + k / 2 - 1] : Integer.MAX_VALUE;
        int b_key = b_start_index + k / 2 - 1 < B.length ? 
                B[b_start_index + k / 2 - 1] : Integer.MAX_VALUE;
        if (a_key < b_key) {
            return findKth(A, a_start_index + k / 2, B, b_start_index, k - k / 2);
        } else {
            return findKth(A, a_start_index, B, b_start_index + k / 2, k - k / 2);
        }        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
