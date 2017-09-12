/**
 * 
 * @LintCode: 120. Word Ladder
 * @Description:  Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:
 *
 *  - Only one letter can be changed at a time
 *  - Each intermediate word must exist in the dictionary
 *  
 *  ! Notice
 *  - Return 0 if there is no such transformation sequence.
 *  - All words have the same length.
 *  - All words contain only lowercase alphabetic characters.
 *   
 * @Difficulty: Medium 
 * @Category: BFS 
 * @Author: Yi Chen
 * @CreatedTime: Aug 20, 2017
 * @LastEditTime: Aug 20, 2017
 *
 */

package chapter5;

import java.util.*;


public class WordLadder {
    
     /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        
        
        dict.add(start);
        dict.add(end);
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> hash = new HashSet<>();
        
        queue.offer(start);
        hash.add(start);
        
        
        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                
                for(String newWord : getNextWords(word, dict)) {
                    if (hash.contains(newWord)) {
                        continue;
                    }
                    if (newWord.equals(end)) {
                        return length;
                    }
                    queue.offer(newWord);
                    hash.add(newWord);
                }
                
            }
        }
        
        return 0;
    }
    
    private String replace(String word, int index, char c) {
        char[] charArr = word.toCharArray();
        charArr[index] = c;
        
        return new String(charArr);
    }
    
    
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWordsInDict = new ArrayList<>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                String replacedWord = replace(word, i, c);
                if (dict.contains(replacedWord)) {
                    nextWordsInDict.add(replacedWord);
                }
            }
        }
        
        return nextWordsInDict;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
