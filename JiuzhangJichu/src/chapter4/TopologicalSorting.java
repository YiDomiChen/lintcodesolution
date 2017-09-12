/**
 * 
 * @LintCode: 127. Topological Sorting
 * @Description: Given an directed graph, a topological order of the graph nodes is defined as follow:
 * 
 * -- For each directed edge A -> B in graph, A must before B in the order list.
 * -- The first node in the order can be any node in the graph with no nodes direct to it.
 * 
 * Find any topological order for the given graph.
 * @Difficulty: Medium
 * @Category: BFS, DFS
 * @Author: Yi Chen
 * @CreatedTime: Aug 15, 2017
 * @LastEditTime: Aug 15, 2017
 *
 */
package chapter4;

import java.util.*;

public class TopologicalSorting {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        // 1. Calculate the in-degree of each node
        Map<DirectedGraphNode, Integer> map = getIndegree(graph);
        // 2. Get original start nodes whose in-degree are 0
        ArrayList<DirectedGraphNode> startNodes = getStartNodes(graph, map);
        // 3. Use BFS to generate topological order
        order = getOrder(startNodes, map);
        
        if (order.size() == graph.size()) {
            return order;
        } else {
            return null;
        }
    }
    
    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        
        return map;
    }
    
    private ArrayList<DirectedGraphNode> getStartNodes(
            ArrayList<DirectedGraphNode> graph,
            Map<DirectedGraphNode, Integer> map) {
        ArrayList<DirectedGraphNode> startNodes = new ArrayList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                startNodes.add(node);
            }
        }
        
        return startNodes;
    }
    
    private ArrayList<DirectedGraphNode> getOrder(
            ArrayList<DirectedGraphNode> startNodes,
            Map<DirectedGraphNode, Integer> map) {
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        
        // add the start nodes first
        for (DirectedGraphNode n : startNodes) {
            order.add(n);
            queue.offer(n);
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    order.add(neighbor);
                }
                
            }
        }
        
        return order;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
