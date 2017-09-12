/**
 * 
 * @LintCode: 615. Course Schedule
 * @Description: There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first 
 * take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, 
 * is it possible for you to finish all courses?
 * @Difficulty: Medium
 * @Category: BFS
 * @Author: Yi Chen
 * @CreatedTime: Aug 16, 2017
 * @LastEditTime: Aug 16, 2017
 *
 */
package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            int size = edges[course].size();
            for (int i = 0; i < size; i++) {
                int tar = (int)edges[course].get(i);
                indegree[tar]--;
                if (indegree[tar] == 0) {
                    queue.offer(tar);
                }
            }
            
        }
        
        return count == numCourses;
    }
    
    
    
}
