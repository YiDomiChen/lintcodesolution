/**
 * 
 * @LintCode:
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Aug 16, 2017
 * @LastEditTime: Aug 16, 2017
 *
 */
package chapter4;

import java.util.*;

public class ZambieInMatrix {
    public class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int PEOPLE = 0;
    public int ZAMBIE = 1;
    public int WALL = 2;
    
    public int[] dx = {1, 0, 0, -1};
    public int[] dy = {0, 1, -1, 0};

    
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int peopleNum = 0;
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == PEOPLE) {
                    peopleNum++;
                } else if (grid[i][j] == ZAMBIE) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }
        
        if (peopleNum == 0) {
            return 0;
        }
        
        int days = 0;
        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate zambieCoord = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    Coordinate neighborCoord = 
                        new Coordinate(zambieCoord.x + dx[j], zambieCoord.y + dy[j]);
                    if (!canInfect(neighborCoord, grid)) {
                        continue;
                    }
                    peopleNum--;
                    grid[neighborCoord.x][neighborCoord.y] = ZAMBIE;
                    if (peopleNum == 0) {
                        return days;
                    }
                    queue.offer(neighborCoord);
                }
            }
        }
        
        if (peopleNum != 0) {
            return -1;
        } else {
            return days;
        }
    }
    
    public boolean canInfect(Coordinate coord, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (coord.x < 0 || coord.x >= m) {
            return false;
        }
        if (coord.y < 0 || coord.y >= n) {
            return false;
        }
        
        return (grid[coord.x][coord.y] == PEOPLE);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ZambieInMatrix z = new ZambieInMatrix();
        int[][] grid = {{0,1,2,0,0},{1,0,0,2,1},{0,1,0,0,0}};
        System.out.println(z.zombie(grid));
    }

}
