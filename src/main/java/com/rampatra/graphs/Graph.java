package com.rampatra.graphs;

import com.rampatra.common.GraphNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A rudimentary Graph having all the basic methods.
 *
 * @author rampatra
 * @since 2019-02-10
 */
public class Graph<E extends Comparable<E>> {
    // map for a fast lookup
    private Map<E, GraphNode<E>> nodes = new HashMap<>();

    public GraphNode<E> addEdges(E value, E... adjacentValues) {
        return addOrUpdateNodes(value, Arrays.stream(adjacentValues).map(GraphNode::new).collect(Collectors.toSet()));
    }

    private GraphNode<E> addOrUpdateNodes(E value, Set<GraphNode<E>> adjacentNodes) {
        GraphNode<E> node = nodes.get(value);
        if (node == null) {
            return add(value, adjacentNodes);
        }
        node.adjacentNodes.addAll(adjacentNodes);
        return node;
    }

    private GraphNode<E> add(E value, Set<GraphNode<E>> adjacentNodes) {
        GraphNode<E> newNode = new GraphNode<>(value, adjacentNodes);
        nodes.put(value, newNode);
        return newNode;
    }

    // todo
    public boolean hasPathDFS(E src, E dest) {
        GraphNode<E> s = nodes.get(src);
        GraphNode<E> d = nodes.get(dest);
        Set<GraphNode<E>> visited = new HashSet<>();
        for (GraphNode<E> node : s.adjacentNodes) {
            if (hasPathDFS(node, d, visited)) {
                return true;
            }
        }
        return false;
    }
    
    // todo
    public boolean hasPathDFS(GraphNode<E> src, GraphNode<E> dest, Set<GraphNode<E>> visited) {
        if (src.value.compareTo(dest.value) == 0) {
            return true;
        } else if (!visited.contains(src)) {
            visited.add(src);
            for (GraphNode<E> node : src.adjacentNodes) {
                if (hasPathDFS(node, dest, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void print() {
        Set<E> visited = new HashSet<>();
        System.out.print("[");
        Iterator<E> iterator = nodes.keySet().iterator();
        while (iterator.hasNext()) {
            E node = iterator.next();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node);
                if (iterator.hasNext()) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addEdges(1, 4, 5);
        graph.addEdges(4, 1, 5, 6, 7);
        graph.addEdges(5, 1, 4, 6);
        graph.addEdges(6, 5, 4);
        graph.addEdges(7, 4);
        graph.print();
        // todo
        System.out.println(graph.hasPathDFS(1,5));
        System.out.println(graph.hasPathDFS(1,6));
    }
}
