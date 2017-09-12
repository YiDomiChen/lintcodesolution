/**
 * 
 * @LintCode: 612. K Closest Points
 * @Description: 
 * Given some points and a point origin in two dimensional space, 
 * find k points out of the some points which are nearest to origin.
 * 
 * Return these points sorted by distance, if they are same with distance, 
 * sorted by x-axis, otherwise sorted by y-axis.
 * 
 * @Difficulty: Medium 
 * @Category: Heap/Priority Queue
 * @Author: Yi Chen
 * @CreatedTime: Sep 2, 2017
 * @LastEditTime: Sep 2, 2017
 *
 */

package chapter8;

import java.util.*;

import chapter8.KClosestPoints.Point;

public class KClosestPoints {
    
    public class Point {
        int x, y;
        Point() {
            this.x = 0;
            this.y = 0;
        }
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        Comparator<Point> cmp = new Comparator<Point>() {            
            @Override
            public int compare(Point p1, Point p2) {
                double res = getDistance(origin, p2) - getDistance(origin, p1);
                if (res == 0) {
                    res = p2.x - p1.x;
                }
                if (res == 0) {
                    res = p2.y - p2.y;
                }
                
                if (res > 0) {
                    return 1;
                } else if (res < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        
        PriorityQueue<Point> queue = new PriorityQueue<>(k, cmp);
        for (Point point : points) {
            if (queue.size() < k) {
                queue.add(point);
            } else {
                if (getDistance(origin, point) < getDistance(origin, queue.peek())) {
                    queue.poll();
                    queue.add(point);
                }             
            }            
        }
        
        Point[] res = new Point[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        
        return res;
    }
    
    
    private double getDistance(Point source, Point target) {
        return Math.sqrt((source.x - target.x) * (source.x - target.x) + 
                  (source.y - target.y) * (source.y - target.y));
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KClosestPoints kcpnt = new KClosestPoints();
        Point origin = kcpnt.new Point(0,0);
        Point[] points = new Point[3];
        points[0] = kcpnt.new Point(-1, -1);
        points[1] = kcpnt.new Point(1, 1);
        points[2] = kcpnt.new Point(100, 100);
        
        Point[] res = kcpnt.kClosest(points, origin, 2);
        for (Point point : res) {
            System.out.println(point.x + "," + point.y);
        }
        
        
    }

}
