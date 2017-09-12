/**
 * 
 * @LintCode: 607. Two Sum - Data Structure Design
 * @Description: 
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * 
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.

 * @Difficulty: Easy
 * @Category: HashTable
 * @Author: Yi Chen
 * @CreatedTime: Aug 29, 2017
 * @LastEditTime: Aug 29, 2017
 *
 */
package chapter7;

import java.util.*;

public class TwoSumDesign {
    
    private HashMap<Integer, Integer> map = new HashMap<>();
    
    // Add the number to an internal data structure.
    public void add(int number) {
        // Time Complexity: O(1)
        // Write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        // Time Complexity: O(n)
        for (int num : map.keySet()) {
            if (map.containsKey(value - num)) {
                if (num == value - num) {
                    if (map.get(num) > 1) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TwoSumDesign tsd = new TwoSumDesign();
        tsd.add(2);
        tsd.add(3);
        System.out.println(tsd.find(4));
        System.out.println(tsd.find(5));
        System.out.println(tsd.find(6));
        tsd.add(3);
        System.out.println(tsd.find(6));
        
    }

}
