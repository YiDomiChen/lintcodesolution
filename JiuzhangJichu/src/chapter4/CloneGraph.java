/**
 * 
 * @LintCode:
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Aug 14, 2017
 * @LastEditTime: Aug 14, 2017
 *
 */
package chapter4;

import java.util.*;

public class CloneGraph {
    
    
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return node;
        }
        
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>(); 
        for(UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        
        for(UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for(UndirectedGraphNode oldNeighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(oldNeighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        
        
        return mapping.get(node);
    }
    
    public ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode firstNode = queue.poll();
            for(UndirectedGraphNode neighborNode : firstNode.neighbors) {
                if(!set.contains(neighborNode)) {
                    queue.offer(neighborNode);
                    set.add(neighborNode);
                }
            }
        }
        
        return new ArrayList<UndirectedGraphNode>(set);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
