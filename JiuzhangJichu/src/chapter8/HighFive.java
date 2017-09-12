/**
 * 
 * @LintCode: 613. High Five
 * @Description: 
 * There are two properties in the node student id and scores, 
 * to ensure that each student will have at least 5 points, 
 * find the average of 5 highest scores for each person.
 * @Difficulty: Medium
 * @Category: Heap
 * @Author: Yi Chen
 * @CreatedTime: Sep 2, 2017
 * @LastEditTime: Sep 2, 2017
 *
 */
package chapter8;

import java.util.*;
public class HighFive {
    
    class Record {
        public int id, score;
        public Record(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
    
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> hash = new HashMap<>();
        
        for (Record r : results) {
            if (!hash.containsKey(r.id)) {
                hash.put(r.id, new PriorityQueue<Integer>());
            }
            
            if (hash.get(r.id).size() < 5) {
                hash.get(r.id).add(r.score);
            } else {
                if (r.score > hash.get(r.id).peek()) {
                    hash.get(r.id).poll();
                    hash.get(r.id).add(r.score);
                }
            }
        }
        
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hash.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> p = entry.getValue();
            double avg = 0.0;
            for (int i = 0; i < 5; i++) {
                avg += p.poll();
            }
            avg /= 5;
            res.put(id, avg);
        }
        
        return res;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
