package com.rampatra.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author rampatra
 * @since 2019-02-14
 */
public class UndirectedGraph<E extends Comparable<E>> extends Graph<E> {
    // map for a fast lookup
    private Map<E, GraphNode<E>> nodes = new HashMap<>();

    public GraphNode<E> addEdge(E value, E adjacentValue) {
        GraphNode<E> node = nodes.get(value);
        GraphNode<E> adjNode = nodes.get(adjacentValue);
        if (node == null) {
            node = new GraphNode<>(value);
            nodes.put(value, node);
        }
        if (adjNode == null) {
            adjNode = new GraphNode<>(adjacentValue);
            nodes.put(adjacentValue, adjNode);
        }
        node.adjacentNodes.add(adjNode);
        adjNode.adjacentNodes.add(node); // as this is an undirected graph
        return node;
    }

    // todo
    public boolean hasPathDFS(E src, E dest) {
        GraphNode<E> s = nodes.get(src);
        GraphNode<E> d = nodes.get(dest);
        Set<GraphNode<E>> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    // todo
    public boolean hasPathDFS(GraphNode<E> src, GraphNode<E> dest, Set<GraphNode<E>> visited) {
        if (src == null || dest == null) {
            return false;
        }
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
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 1);
        graph.addEdge(5, 6);
        graph.addEdge(8, null);
        graph.print();
        // todo
        System.out.println(graph.hasPathDFS(1, 5));
        System.out.println(graph.hasPathDFS(1, 6));
        System.out.println(graph.hasPathDFS(1, 8));
        System.out.println(graph.hasPathDFS(4, 8));
        System.out.println(graph.hasPathDFS(4, 100));
    }
}
