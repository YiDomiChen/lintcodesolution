/**
 * 
 * @LintCode: 573. Build Post Office II
 * @Description: Given a 2D grid, each cell is either a wall 2, 
 * an house 1 or empty 0 (the number zero, one, two), find a place to build a post office 
 * so that the sum of the distance from the post office to all the houses is smallest.
 * Return the smallest sum of distance. Return -1 if it is not possible.
 * @Difficulty: Hard
 * @Category: BFS
 * @Author: Yi Chen
 * @CreatedTime: Aug 17, 2017
 * @LastEditTime: Aug 17, 2017
 *
 */
package chapter4;

import java.util.*;

public class BuildPostOfficeII {    
    public class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int EMPTY = 0;
    public int HOUSE = 1;
    public int WALL = 2;
    
    private int[][] grid;
    private int m, n;
    private int[] dx = {1, 0, 0, -1}; 
    private int[] dy = {0, 1, -1, 0};
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        
        // 1. initialize the coordinates of all houses
        List<Coordinate> houses = getCoordinates(HOUSE);
        int[][][] distance = new int[n][m][houses.size()];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < houses.size(); k++) {
                    distance[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        // 2. use bfs to calculate the distance between each empty land and each house
        for (int i = 0; i < houses.size(); i++) {
            Coordinate house = houses.get(i);
            bfs(house, i, distance);
        }
        
        // 3. get each land's total travel distance
        int result = Integer.MAX_VALUE;        
        List<Coordinate> emptyPlaces = getCoordinates(EMPTY);    // extract all empty lands        
        for (Coordinate emptyPlace : emptyPlaces){
            int sumDistance = 0;
            boolean canBuild = true;
            for (int i = 0; i < houses.size(); i++) {
                // if the empty land is inaccessible to the house.
                if (distance[emptyPlace.x][emptyPlace.y][i] == Integer.MAX_VALUE) {
                    canBuild = false;
                    break;
                }
                sumDistance += distance[emptyPlace.x][emptyPlace.y][i];
            }
            if (canBuild) {
                result = Math.min(result, sumDistance);
            }
        } 
        
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        
        return result;
    }
    
    private List<Coordinate> getCoordinates(int type) {
        ArrayList<Coordinate> coordsList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == type) {
                    coordsList.add(new Coordinate(i, j));
                }
            }
        }
        
        return coordsList;
    }
    
    private boolean inBound(Coordinate coord) {
        if (coord.x < 0 || coord.x >= n) {
            return false;
        }
        if (coord.y < 0 || coord.y >= m) {
            return false;
        }
        
        return grid[coord.x][coord.y] == EMPTY;
    }
    
    private void bfs(Coordinate house, int houseIndex, int[][][] distance) {
        boolean[][] visited = new boolean[n][m];
        Queue<Coordinate> queue = new LinkedList<>();
        int step = 0;
        queue.offer(house);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate coord = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    Coordinate neighCoord = new Coordinate(coord.x + dx[j], coord.y + dy[j]);
                    if (inBound(neighCoord) && !visited[neighCoord.x][neighCoord.y]) {
                        distance[neighCoord.x][neighCoord.y][houseIndex] = step;                        
                        queue.offer(neighCoord);
                        visited[neighCoord.x][neighCoord.y] = true;
                    }
                }
            }
        }
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] grid = {{0,1,0,0,0},{1,0,0,2,1},{0,1,0,0,0}};
        BuildPostOfficeII b = new BuildPostOfficeII();
        System.out.println(b.shortestDistance(grid));
    }

}
