package com.rampatra.graphs;

import com.rampatra.common.GraphNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author rampatra
 * @since 2019-02-10
 */
public class Graph<E extends Comparable<E>> {
    private Map<E, GraphNode<E>> nodes = new HashMap<>();

    public GraphNode<E> add(E value, E... adjacentValues) {
        return add(value, Arrays.stream(adjacentValues).map(GraphNode::new).collect(Collectors.toSet()));
    }

    public GraphNode<E> add(E value, Set<GraphNode<E>> adjacentNodes) {
        GraphNode<E> newNode = new GraphNode<>(value, adjacentNodes);
        nodes.put(value, newNode);
        return newNode;
    }

    public GraphNode<E> addOrUpdate(E value, Set<GraphNode<E>> adjacentNodes) {
        GraphNode<E> node = nodes.get(value);
        if (node == null) {
            return add(value, adjacentNodes);
        }
        node.adjacentNodes.addAll(adjacentNodes);
        return node;
    }

    public void print() {
        Set<E> visited = new HashSet<>();
        System.out.print("[");
        for (E val : nodes.keySet()) {
            if (!visited.contains(val)) {
                visited.add(val);
                System.out.print(val + ", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.add(1, 4, 5);
        graph.add(4, 1, 5, 6, 7);
        graph.add(5, 1, 4, 6);
        graph.add(6, 5, 4);
        graph.add(7, 4);
        graph.print();
    }
}
