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
     *
     * @param n
     * @param edges
     * @return
     */
    public static boolean isValidTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
        }

        boolean[] visited = new boolean[n];

        if (hasCycle(adjacencyList, 0, -1, visited)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean hasCycle(List<List<Integer>> adjacencyList, int node1, int exclude, boolean[] visited) {
        visited[node1] = true;

        for (int i = 0; i < adjacencyList.get(node1).size(); i++) {
            int node2 = adjacencyList.get(node1).get(i);

            if ((visited[node2] && exclude != node2) || (!visited[node2] && hasCycle(adjacencyList, node2, node1, visited))) {
                return true;
            }
        }

        return false;
    }


    /**
     * Union-find algorithm: We keep all connected nodes in one set in the union operation and in find operation we
     * check whether two nodes belong to the same set. If yes then there's a cycle and if not then no cycle.
     *
     * Good articles on union-find:
     * - https://www.hackerearth.com/practice/notes/disjoint-set-union-union-find/
     * - https://www.youtube.com/watch?v=wU6udHRIkcc
     *
     * @param n
     * @param edges
     * @return
     */
    public static boolean isValidTreeUsingUnionFind(int n, int[][] edges) {
        int[] roots = new int[n];

        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            // find operation
            if (roots[edges[i][0]] == roots[edges[i][1]]) {
                return false;
            }
            // union operation
            roots[edges[i][1]] = findRoot(roots, roots[edges[i][0]]); // note: we can optimize this even further by
            // considering size of each side and then join the side with smaller size to the one with a larger size (weighted union).
            // We can use another array called size to keep count of the size or we can use the same root array with
            // negative values, i.e, negative resembles that the node is pointing to itself and the number will represent
            // the size. For example, roots = [-2, -1, -1, 0] means that node 3 is pointing to node 0 and node 0 is pointing
            // to itself and is has 2 nodes under it including itself.
        }

        return edges.length == n - 1;
    }

    private static int findRoot(int[] roots, int node) {
        while (roots[node] != node) {
            node = roots[node];
        }
        return node;
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