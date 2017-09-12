package chapter4;

import java.util.*;

public class UndirectedGraphNode {
    public int label;
    List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        this.label = x;
        this.neighbors = new ArrayList<UndirectedGraphNode>();
    }
}