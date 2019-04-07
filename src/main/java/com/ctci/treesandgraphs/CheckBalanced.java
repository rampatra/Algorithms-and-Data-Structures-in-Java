package com.ctci.treesandgraphs;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced
 * tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 *
 * @author rampatra
 * @since 2019-02-16
 */
public class CheckBalanced {

    /**
     * Checks whether its left and right child are balanced, if yes then continues down the
     * tree or else stops and returns {@code false}. Time complexity: O(n log n) since each
     * node is touched once per node above it. Space complexity: O(h) where, h is the height
     * of the tree.
     *
     * @param node reference to the node for which the balanced property needs to be checked
     * @return {@code true} if balanced, {@code false} otherwise
     */
    private static boolean isBalanced(TreeNode node) {
        if (node == null) return true;

        boolean isBalanced = (height(node.left) - height(node.right)) <= 1;
        
        /* Note: isBalanced is first checked below as there is no point is checking the left and right child 
        if the current node itself is not balanced. And, as '&&' is a short circuit operator, it won't evaluate 
        the rest of the conditions if the first condition is false. */
        return isBalanced && isBalanced(node.left) && isBalanced(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return -1;

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    /**
     * This approach is a slight modification to the above {@link CheckBalanced#height(TreeNode)} method where
     * while calculating the height we also check whether the difference between the left and right child heights
     * is more than 1. If yes, we return an error code, which in this case, is {@code Integer.MIN_VALUE}.
     * Time complexity: O(n). Space complexity: O(h) where, h is the height of the tree.
     *
     * @param node reference to the node for which the balanced property needs to be checked
     * @return the height of the tree if it's balance, {@code Integer.MIN_VALUE} otherwise
     */
    private static int checkHeightAndBalance(TreeNode node) {
        if (node == null) return -1;

        int leftHeight = checkHeightAndBalance(node.left);
        int rightHeight = checkHeightAndBalance(node.right);

        if (leftHeight == Integer.MIN_VALUE || rightHeight == Integer.MIN_VALUE || !(leftHeight - rightHeight <= 1)) {
            return Integer.MIN_VALUE;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalancedOptimized(TreeNode node) {
        return checkHeightAndBalance(node) != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(1);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(3);
        System.out.println("Height: " + height(treeRoot));
        System.out.println("Is Balance: " + isBalanced(treeRoot));
        System.out.println("Is Balance Optimized: " + isBalancedOptimized(treeRoot));

        treeRoot = new TreeNode(1);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(3);
        treeRoot.left.left = new TreeNode(4);
        treeRoot.left.left.left = new TreeNode(5);
        System.out.println("Height: " + height(treeRoot));
        System.out.println("Is Balance: " + isBalanced(treeRoot));
        System.out.println("Is Balance Optimized: " + isBalancedOptimized(treeRoot));
    }
}