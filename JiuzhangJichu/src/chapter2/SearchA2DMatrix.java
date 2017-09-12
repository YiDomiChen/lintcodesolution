/**
 * 
 * @LintCode: 28. Search a 2D Matrix
 * @Description: Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.

 * @Difficulty: Easy
 * @Category: Binary Search
 * @Author: Yi Chen
 * @CreatedTime: Aug 9, 2017
 * @LastEditTime: Aug 9, 2017
 *
 */
package chapter2;

public class SearchA2DMatrix {
    
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null) {
            return false;
        }
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int startR = 0, endR = matrix.length - 1;
        while (startR + 1 < endR) {
            int mid = startR + (endR - startR) / 2;
            if (matrix[mid][0] < target) {
                startR = mid;
            } else {
                startR = mid - 1;
                break;
            }
        }
        if (startR + 1 == endR) {
            startR = endR;
        }
        
        int startC = 0, endC = matrix[0].length - 1;
        while (startC + 1 < endC) {
            int mid = startC + (endC - startC) / 2;
            if (matrix[startR][mid] == target) {
                startC = mid;
            } else if (matrix[startR][mid] < target) {
                startC = mid;
            } else {
                endC = mid;
            }
        }
        
        if (matrix[startR][startC] == target || 
            matrix[startR][endC] == target) {
                return true;
        } else {
            return false;
        }
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = {{1,2,8,10,16,21,23,30,31,37,39,43,44,46,53,59,66,68,71},
                {90,113,125,138,157,182,207,229,242,267,289,308,331,346,370,392,415,429,440},
                {460,478,494,506,527,549,561,586,609,629,649,665,683,704,729,747,763,786,796},
                {808,830,844,864,889,906,928,947,962,976,998,1016,1037,1058,1080,1093,1111,1136,1157},
                {1180,1204,1220,1235,1251,1272,1286,1298,1320,1338,1362,1378,1402,1416,1441,1456,1475,1488,1513},
                {1533,1548,1563,1586,1609,1634,1656,1667,1681,1706,1731,1746,1760,1778,1794,1815,1830,1846,1861}};
        
        SearchA2DMatrix s = new SearchA2DMatrix();
        System.out.println(s.searchMatrix(matrix, 1861));
        
        
        
    }

}
