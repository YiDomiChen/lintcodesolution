/**
 * 
 * @LintCode: 4. Ugly Number II
 * @Description: 
 * Ugly number is a number that only have factors 2, 3 and 5.
 * 
 * Design an algorithm to find the nth ugly number. 
 * The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * 
 * @Difficulty: Medium 
 * @Category: Priority Queue
 * @Author: Yi Chen
 * @CreatedTime: Sep 3, 2017
 * @LastEditTime: Sep 3, 2017
 *
 */
package chapter8;

import java.util.*;

public class UglyNumberII {
    
    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        PriorityQueue<Long> queue = new PriorityQueue<>();    // ugly number队列
        HashSet<Long> set = new HashSet<>();    // 储存到目前为止出现的所有ugly number
        Long[] prime = new Long[3];
        prime[0] = Long.valueOf(2);
        prime[1] = Long.valueOf(3);
        prime[2] = Long.valueOf(5);
        for (int i = 0; i < 3; i++) {
            queue.offer(prime[i]);
            set.add(prime[i]);
        }
        
        Long num = Long.valueOf(1);
        for (int i = 1; i < n; i++) {
            num = queue.poll();    // n - 1次循环，分别poll出第2,3,4..n个ugly number (number 1没有加入)
            for (int j = 0; j < 3; j++) {
                if (!set.contains(num * prime[j])) {
                    queue.offer(num * prime[j]);
                    set.add(num * prime[j]);
                }
            }
        }
        
        return num.intValue();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UglyNumberII u = new UglyNumberII();
        System.out.println(u.nthUglyNumber(20));
    }

}
