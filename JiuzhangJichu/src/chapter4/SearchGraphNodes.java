/**
 * 
 * @LintCode:
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Aug 15, 2017
 * @LastEditTime: Aug 15, 2017
 *
 */
package chapter4;

import java.util.*;

public class SearchGraphNodes {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph, 
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node, 
                                          int target) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> hash = new HashSet<>();
        
        queue.offer(node);
        hash.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode first = queue.poll();
            if (values.get(first) == target) {
                return first;
            }
            for (UndirectedGraphNode neighbor : first.neighbors) {
                if (!hash.contains(neighbor)) {
                    queue.offer(neighbor);
                    hash.add(neighbor);
                }
            }
        }
        
        return null;
    }
}
