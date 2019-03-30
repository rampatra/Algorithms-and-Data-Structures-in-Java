package com.ctci.treesandgraphs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rampatra
 * @since 2019-03-21
 */
public class GraphNode {
    int value;
    Set<GraphNode> adjacent = new HashSet<>();
    
    GraphNode(int value) {
        this.value = value;
    }
}