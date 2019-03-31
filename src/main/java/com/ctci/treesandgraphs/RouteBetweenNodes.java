package com.ctci.treesandgraphs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author rampatra
 * @since 2019-03-21
 */
public class RouteBetweenNodes {

    class Graph {

        private final Map<Integer, GraphNode> nodes = new HashMap<>();

        /**
         * Adds an edge from a node with value {@code v1} to another node with value {@code v2}.
         * Note: This code doesn't work for nodes having duplicate values.
         *
         * @param v1
         * @param v2
         */
        void addEdge(int v1, int v2) {
            GraphNode n1 = nodes.get(v1);
            GraphNode n2 = nodes.get(v2);

            if (n1 == null) {
                n1 = new GraphNode(v1);
                nodes.put(v1, n1);
            }
            if (n2 == null) {
                n2 = new GraphNode(v2);
                nodes.put(v2, n2);
            }

            n1.adjacent.add(n2); // as it is a directed graph
        }

        /**
         * Checks for a path from a node with value {@code v1} to another node with value {@code v2} in a breadth-first
         * manner. Note: This code doesn't work for nodes having duplicate values.
         *
         * @param v1 the value of the first node or starting node.
         * @param v2 the value of the ending node.
         * @return {@code true} if path exists, {@code false} otherwise.
         */
        boolean isRoutePresent(int v1, int v2) {
            Queue<GraphNode> queue = new ArrayDeque<>();
            Set<GraphNode> visited = new HashSet<>();

            GraphNode n1 = nodes.get(v1);
            GraphNode n2 = nodes.get(v2);

            if (n1 == null || n2 == null) {
                return false;
            }

            queue.add(n1);

            while (!queue.isEmpty()) {
                GraphNode n = queue.poll();

                if (visited.contains(n)) {
                    continue;
                }
                if (n.adjacent.contains(n2)) {
                    return true;
                }
                queue.addAll(n.adjacent);
                visited.add(n);
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Graph g = new RouteBetweenNodes().new Graph();
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        System.out.println("Route exists from 1 to 2: " + g.isRoutePresent(1, 2));
        System.out.println("Route exists from 2 to 5: " + g.isRoutePresent(2, 5));
        System.out.println("Route exists from 1 to 3: " + g.isRoutePresent(1, 3));
        System.out.println("Route exists from 4 to 6: " + g.isRoutePresent(4, 6));
        System.out.println("Route exists from 6 to 4: " + g.isRoutePresent(6, 4));
        System.out.println("Route exists from 6 to 5: " + g.isRoutePresent(6, 5));
    }
}