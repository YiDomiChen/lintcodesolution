/**
 * 
 * @LintCode: 38. Search a 2D Matrix II
 * @Description: Write an efficient algorithm that searches for a value in an m x n matrix,
 *  return the occurrence of it.
 *  
 *  This matrix has the following properties:
 *  
    ..Integers in each row are sorted from left to right.
    ..Integers in each column are sorted from up to bottom.
    ..No duplicate integers in each row or column.
 *  
 *  
 * @Difficulty: Medium
 * @Category: Sorted Matrix
 * @Author: Yi Chen
 * @CreatedTime: Aug 1, 2017
 * @LastEditTime: Aug 1, 2017
 *
 */
package chapter2;

public class Search2DMatrixII {
    
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int x = m - 1;
        int y = 0;
        int count = 0;
        
        while(x >= 0 && y <= n - 1) {
            if(matrix[x][y] == target) {
                count++;
                x--;
                y++;
            }
            else if(matrix[x][y] > target) {
                x--;
            }
            else {
                y++;
            }
        }
        
        return count;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int[][] nums = {{1, 3, 5, 7}, {2, 4, 7, 8}, {3, 5, 9, 10}};
        int[][] nums = {{3, 4}};
        Search2DMatrixII search = new Search2DMatrixII();
        System.out.println(search.searchMatrix(nums, 3));
    }

}
