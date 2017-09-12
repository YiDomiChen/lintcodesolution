/**
 * 
 * @LintCode: 136. Palindrome Partitioning
 * @Description: Given a string s, partition s such that every substring of 
 * the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * @Difficulty: Medium 
 * @Category: DFS
 * @Author: Yi Chen
 * @CreatedTime: Aug 19, 2017
 * @LastEditTime: Aug 19, 2017
 *
 */
package chapter5;

import java.util.*;

public class PalindromePartitioning {

    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        List<String> partition = new ArrayList<>();
        if (s.length() == 0) {
            result.add(partition);
            return result;
        }
        helper(s, 0, partition, result);
        
        return result;
    }
    
    public void helper(String s, int startIndex,
                       List<String> partition,
                       List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<String>(partition));
            return;
        }
        
        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            
            partition.add(subString);
            helper(s, i + 1, partition, result);
            partition.remove(partition.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        
        return true;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
