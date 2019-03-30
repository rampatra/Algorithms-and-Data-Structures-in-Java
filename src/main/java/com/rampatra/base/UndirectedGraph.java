package com.rampatra.base;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author rampatra
 * @since 2019-02-14
 */
public class UndirectedGraph<E extends Comparable<E>> extends Graph<E> {
    // map for a fast lookup
    private Map<E, GraphNode<E>> nodes = new HashMap<>();

    /**
     * Adds an edge between a node with value {@code value} and another node with value {@code adjacentValue}. As the
     * graph is undirected, the edges are added in both the nodes. If nodes with respective values are not present in
     * the graph then this method creates the nodes.
     *
     * @param value         refers to the value for first node
     * @param adjacentValue refers to the value for the second node
     * @return the node with value {@code value}, or the first node
     */
    public GraphNode<E> addEdge(E value, E adjacentValue) {
        GraphNode<E> node = nodes.get(value);
        GraphNode<E> adjNode = nodes.get(adjacentValue);
        if (node == null && value != null) {
            node = new GraphNode<>(value);
            nodes.put(value, node);
        }
        if (adjNode == null && adjacentValue != null) {
            adjNode = new GraphNode<>(adjacentValue);
            nodes.put(adjacentValue, adjNode);
        }
        if (node != null && adjNode != null) {
            node.adjacentNodes.add(adjNode);
            adjNode.adjacentNodes.add(node); // as this is an undirected graph
        }
        return node;
    }

    /**
     * Method to check whether {@code src} and {@code dest} nodes are connected by depth first search (DFS).
     *
     * @param src  source node in graph
     * @param dest destination node in graph
     * @return {@code true} if there is a path from {@code src} to {@code dest}, {@code false} otherwise
     */
    public boolean hasPathDFS(E src, E dest) {
        GraphNode<E> s = nodes.get(src);
        GraphNode<E> d = nodes.get(dest);
        Set<GraphNode<E>> visited = new HashSet<>(); // to save all visited nodes so that we do not visit them again
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(GraphNode<E> src, GraphNode<E> dest, Set<GraphNode<E>> visited) {
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

    /**
     * Method to check whether {@code src} and {@code dest} nodes are connected by breadth first search (BFS).
     *
     * @param src  source node in graph
     * @param dest destination node in graph
     * @return {@code true} if there is a path from {@code src} to {@code dest}, {@code false} otherwise
     */
    public boolean hasPathBFS(E src, E dest) {
        GraphNode<E> s = nodes.get(src);
        GraphNode<E> d = nodes.get(dest);
        if (s == null || d == null) {
            return false;
        }
        Set<GraphNode<E>> visited = new HashSet<>();
        Queue<GraphNode<E>> toVisit = new ArrayDeque<>();
        toVisit.add(s);
        return hasPathBFS(d, visited, toVisit);
    }

    private boolean hasPathBFS(GraphNode<E> dest, Set<GraphNode<E>> visited, Queue<GraphNode<E>> toVisit) {
        while (!toVisit.isEmpty()) {
            GraphNode<E> node = toVisit.poll();
            if (visited.contains(node)) {
                continue;
            } else {
                visited.add(node);
            }
            toVisit.addAll(node.adjacentNodes.stream().filter(n -> !visited.contains(n)).collect(Collectors.toList()));
            if (node.value.compareTo(dest.value) == 0) {
                return true;
            }
        }
        return false;
    }


    /**
     * Prints the node values in the graph.
     */
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
        graph.addEdge(null, 9);
        graph.print();

        System.out.println("----");

        // has path DFS
        System.out.println(graph.hasPathDFS(1, 5));
        System.out.println(graph.hasPathDFS(1, 6));
        System.out.println(graph.hasPathDFS(1, 8));
        System.out.println(graph.hasPathDFS(4, 8));
        System.out.println(graph.hasPathDFS(4, 9));
        System.out.println(graph.hasPathDFS(4, 100));

        System.out.println("----");

        // has path BFS
        System.out.println(graph.hasPathBFS(1, 5));
        System.out.println(graph.hasPathBFS(1, 6));
        System.out.println(graph.hasPathBFS(1, 8));
        System.out.println(graph.hasPathBFS(4, 8));
        System.out.println(graph.hasPathBFS(4, 9));
        System.out.println(graph.hasPathBFS(4, 100));
    }
}
