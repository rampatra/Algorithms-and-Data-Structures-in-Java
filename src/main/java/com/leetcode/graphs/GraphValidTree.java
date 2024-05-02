package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/graph-valid-tree/
 * Problem Description:
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function
 * to check whether these edges make up a valid tree.
 * <p>
 * Example 1:
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * <p>
 * Example 2:
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * <p>
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the
 * same as [1,0] and thus will not appear together in edges.
 *
 * @author rampatra
 * @since 2019-08-05
 */
public class GraphValidTree {
    
    /**
     * Checks if the given edges form a valid tree using BFS.
     */
    public static boolean isValidTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = buildAdjacencyList(n, edges);
        return isTreeBFS(n, adjacencyList);
    }

    /**
     * Builds the adjacency list from the given edges.
     */
    private static List<List<Integer>> buildAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);  // Since the graph is undirected
        }
        return adjacencyList;
    }

    /**
     * Uses BFS to check for cycles and disconnected components.
     */
    private static boolean isTreeBFS(int n, List<List<Integer>> adjacencyList) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjacencyList.get(node)) {
                if (!visited.add(neighbor)) {  // if 'add' returns false, 'neighbor' is already visited
                    return false;
                }
                queue.offer(neighbor);
            }
        }
        return visited.size() == n;
    }

    /**
     * Checks if the given edges form a valid tree using the Union-Find algorithm.
     */
    public static boolean isValidTreeUsingUnionFind(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);

            if (x == y) return false; // x and y are in the same set

            // Union operation
            parent[y] = x;
        }

        return edges.length == n - 1; // Tree should have exactly n-1 edges
    }

    /**
     * Finds the root of the node 'i' using path compression.
     */
    private static int find(int[] parent, int i) {
        if (parent[i] == -1) return i;
        return find(parent, parent[i]);
    }

    public static void main(String[] args) {
        assertTrue(isValidTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        assertFalse(isValidTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        assertFalse(isValidTree(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));

        assertTrue(isValidTreeUsingUnionFind(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        assertFalse(isValidTreeUsingUnionFind(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        assertFalse(isValidTreeUsingUnionFind(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
    }
}