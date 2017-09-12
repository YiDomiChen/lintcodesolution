/**
 * 
 * @LintCode: 433. Number of Islands
 * @Description: Given a boolean 2D matrix, 0 is represented as the sea, 
 * 1 is represented as the island. If two 1 is adjacent, we consider them in the same 
 * island. We only consider up/down/left/right adjacent.
 * Find the number of islands.
 * 
 * @Difficulty: Easy
 * @Category: BFS
 * @Author: Yi Chen
 * @CreatedTime: Aug 15, 2017
 * @LastEditTime: Aug 15, 2017
 *
 */
package chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public class Coordinate {
        public int x;
        public int y;
        public Coordinate(int x, int y) {
            // TODO Auto-generated constructor stub
            this.x = x;
            this.y = y;
        }
    }
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here        
        int islands = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return islands;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]) {
                    bfsSearch(grid, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void bfsSearch(boolean[][] grid, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        queue.offer(new Coordinate(x, y));
        
        while (!queue.isEmpty()) {
            Coordinate coord = queue.poll();
            grid[coord.x][coord.y] = false;
            for (int i = 0; i < 4; i++) {
                Coordinate neighborCoord = new Coordinate(coord.x + dx[i], coord.y + dy[i]);
                if(inBound(neighborCoord, grid) && grid[coord.x + dx[i]][coord.y + dy[i]]) {
                    grid[coord.x + dx[i]][coord.y + dy[i]] = false;
                    queue.offer(neighborCoord);
                }
            }
        }
        
    }
    
    private boolean inBound(Coordinate coord, boolean[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        return coord.x >= 0 && coord.x < m && coord.y >= 0 && coord.y < n;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
