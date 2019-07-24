package com.hackerrank.java.advanced;

import java.util.*;

/**
 * Level: Medium
 * Problem Link: https://www.hackerrank.com/challenges/java-vistor-pattern/
 *
 * @author rampatra
 * @since 2019-06-22
 */
enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);


}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int nodeSum = 0;
    int leafSum = 0;

    public int getResult() {
        //implement this
        return leafSum;
    }

    public void visitNode(TreeNode node) {
        //implement this
        //nodeSum += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        leafSum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    int prodOfRedNodesAndLeaves = 1;
    private final int M = 1000000007;

    public int getResult() {
        //implement this
        return prodOfRedNodesAndLeaves;
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getColor() == Color.RED) {
            prodOfRedNodesAndLeaves *= (node.getValue() % M);
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.RED) {
            prodOfRedNodesAndLeaves *= (leaf.getValue() % M);
        }
    }
}

class FancyVisitor extends TreeVis {
    int sumOfNodesAtEvenDepth = 0;
    int sumOfGreenLeaves = 0;

    public int getResult() {
        //implement this
        return Math.abs(sumOfNodesAtEvenDepth - sumOfGreenLeaves);
    }

    public void visitNode(TreeNode node) {
        //implement this
        if (node.getDepth() % 2 == 0) {
            sumOfNodesAtEvenDepth += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
        if (leaf.getColor() == Color.GREEN) {
            sumOfGreenLeaves += leaf.getValue();
        }
    }
}

public class JavaVisitorPattern {

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner s = new Scanner(System.in);

        int numOfNodes = s.nextInt();
        int[] nodeValues = new int[numOfNodes];
        int[] nodeColors = new int[numOfNodes];
        Map<Integer, Set<Integer>> parentToChildMap = new HashMap<>();
        Map<Integer, Integer> childToParentMap = new HashMap<>();

        for (int i = 0; i < numOfNodes; i++) {
            nodeValues[i] = s.nextInt();
        }
        for (int i = 0; i < numOfNodes; i++) {
            nodeColors[i] = s.nextInt();
        }
        for (int i = 0; i < numOfNodes - 1; i++) {
            int parentIndex = s.nextInt();
            int childIndex = s.nextInt();

            Set<Integer> children = parentToChildMap.get(parentIndex - 1) != null ? parentToChildMap.get(parentIndex - 1) : new HashSet<>();
            children.add(childIndex - 1);
            parentToChildMap.put(parentIndex - 1, children);
            childToParentMap.put(childIndex - 1, parentIndex - 1);
        }

        List<Tree> nodes = new ArrayList<>(numOfNodes);
        for (int i = 0; i < numOfNodes; i++) {

            int depth = childToParentMap.get(i) == null ? -1 : nodes.get(childToParentMap.get(i)).getDepth();

            if (parentToChildMap.get(i) != null) {
                nodes.add(new TreeNode(nodeValues[i], nodeColors[i] == 0 ? Color.RED : Color.GREEN, depth + 1));
            } else {
                nodes.add(new TreeLeaf(nodeValues[i], nodeColors[i] == 0 ? Color.RED : Color.GREEN, depth + 1));
            }
        }


        for (Map.Entry<Integer, Set<Integer>> entry : parentToChildMap.entrySet()) {

            TreeNode parent = (TreeNode) nodes.get(entry.getKey());

            for (Integer childIndex : entry.getValue()) {
                parent.addChild(nodes.get(childIndex));
            }
        }

        return nodes.get(0);
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}