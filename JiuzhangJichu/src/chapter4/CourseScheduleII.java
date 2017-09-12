/**
 * 
 * @LintCode: 616. Course Schedule II
 * @Description: 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first 
 * take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, 
 * return the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. 
 * If it is impossible to finish all courses, return an empty array.

 * @Difficulty: Medium
 * @Category: BFS
 * @Author: Yi Chen
 * @CreatedTime: Aug 17, 2017
 * @LastEditTime: Aug 17, 2017
 *
 */
package chapter4;

import java.util.*;

public class CourseScheduleII {

    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        
        int[] degrees = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            degrees[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] order = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[count] = course;
            count++;
            int size = edges[course].size();
            for (int i = 0; i < size; i++) {
                int pointerCourse = (int)edges[course].get(i);
                degrees[pointerCourse]--;
                if (degrees[pointerCourse] == 0) {
                    queue.offer(pointerCourse);
                }
            }
            
        }
        
        if (count == numCourses) {
            return order;
        }
        else {
            return new int[0];
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
