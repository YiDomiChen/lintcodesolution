/**
 * 
 * @LintCode: 611. Knight Shortest Path
 * @Description: Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as 
 * barrier) with a source position, find the shortest path to a destination position, 
 * return the length of the route.
 * Return -1 if knight can not reached.

 * @Difficulty: Medium 
 * @Category: BFS
 * @Author: Yi Chen
 * @CreatedTime: Aug 16, 2017
 * @LastEditTime: Aug 16, 2017
 *
 */
package chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPath {
    public class Point {
        public int x, y;
        public Point() { x = 0; y = 0; }
        public Point(int a, int b) { x = a; y = b; }
    }
    
    
    private int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    private int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    private int m, n;
    
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        m = grid.length;
        n = grid[0].length;
        
        int steps = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curLoc = queue.poll();
                if (curLoc.x == destination.x && curLoc.y == destination.y) {
                    return steps;
                }
                for (int j = 0; j < dx.length; j++) {
                    Point neiLoc = new Point(curLoc.x + dx[j], curLoc.y + dy[j]);
                    if (!inBound(neiLoc, grid)) {
                        continue;
                    }
                    queue.offer(neiLoc);
                    grid[neiLoc.x][neiLoc.y] = true;
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    private boolean inBound(Point point, boolean[][] grid) {
        if (point.x < 0 || point.x >= m) {
            return false;
        }
        if (point.y < 0 || point.y >= n) {
            return false;
        }
        
        return (grid[point.x][point.y] == false);
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KnightShortestPath k = new KnightShortestPath();
        boolean[][] grid = {{false,true,false},
                            {true,false,false},
                            {false,false,false}};
        Point source = k.new Point(2, 0);
        Point destination = k.new Point(2, 2);
        System.out.println(k.shortestPath(grid, source, destination));
        
    }

}
