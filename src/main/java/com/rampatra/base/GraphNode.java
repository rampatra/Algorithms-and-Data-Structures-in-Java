package com.rampatra.base;

import java.util.HashSet;
import java.util.Set;

/**
 * The class for a node in a graph. Ideally, you should make member variable {@code private} and have
 * getters, setters, etc. but to keep it simple, I have omitted all those boilerplate code.
 *
 * @author rampatra
 * @since 2019-02-10
 */
public class GraphNode<E extends Comparable<E>> {
    public E value;
    public Set<GraphNode<E>> adjacentNodes = new HashSet<>();

    public GraphNode(E value) {
        this(value, null);
    }

    public GraphNode(E value, Set<GraphNode<E>> adjacentNodes) {
        this.value = value;
        if (adjacentNodes != null) {
            this.adjacentNodes = adjacentNodes;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphNode<?> graphNode = (GraphNode<?>) o;

        return value.equals(graphNode.value);
    }
}
