/**
 * 
 * @LintCode:
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Aug 20, 2017
 * @LastEditTime: Aug 20, 2017
 *
 */
package chapter5;

import java.util.*;
public class WordLadderII {
    
    
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> ladders = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        dict.add(start);
        dict.add(end);
        
        bfs(dict, map, distance, end);
        
        List<String> path = new ArrayList<>();
        dfs(ladders, path, end, start, distance, map);
        
        return ladders;
    }
    
    private void dfs(List<List<String>> ladders, List<String> path, 
                     String end, String current,
                     Map<String, Integer> distance, 
                     Map<String, List<String>> map) {
        path.add(current);
        if (current.equals(end)) {
            ladders.add(new ArrayList<String>(path));
        } else {
            for (String neighbor : map.get(current)) {
                if (distance.containsKey(neighbor) 
                    && distance.get(neighbor) == distance.get(current) - 1) {
                    dfs(ladders, path, end, neighbor, distance, map);
                }
            }
        }
        path.remove(path.size() - 1);
    }
    
    private void bfs(Set<String> dict, Map<String, List<String>> map, Map<String, Integer> distance, String end) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        distance.put(end, 0);
        
        for (String word : dict) {
            map.put(word, new ArrayList<String>());
        }
        
        while (!queue.isEmpty()) {
            String word = queue.poll();
            List<String> neighborWords = getNextWords(word, dict);
            for (String neighborWord : neighborWords) {
                map.get(neighborWord).add(word);
                if (!distance.containsKey(neighborWord)) {
                    distance.put(neighborWord, distance.get(word) + 1);
                    queue.offer(neighborWord);
                }
            }
        }        
    }
    
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    continue;
                }
                String replacedWord = replace(word, i, c);
                if (dict.contains(replacedWord)) {
                    nextWords.add(replacedWord);
                }
            }
        }
        
        return nextWords;
    }
    
    private String replace(String word, int index, char c) {
        char[] charArr = word.toCharArray();
        charArr[index] = c;
        
        return new String(charArr);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        WordLadderII w = new WordLadderII();
        List<List<String>> result = w.findLadders(start, end, dict);
        for (List<String> path : result) {
            for (String word : path) {
                System.out.print(word + ",");
            }
            System.out.println();
        }
    }

}
