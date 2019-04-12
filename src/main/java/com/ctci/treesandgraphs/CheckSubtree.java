package com.ctci.treesandgraphs;

/**
 * @author rampatra
 * @since 2019-02-24
 */
public class CheckSubtree {

    private static boolean isT2SubtreeOfT1(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        } else if (t2 == null) {
            return true;
        }

        if (t1.val == t2.val) {
            if (matchTree(t1, t2)) {
                return true;
            }
        }
        return isT2SubtreeOfT1(t1.left, t2) || isT2SubtreeOfT1(t1.right, t2);
    }

    private static boolean matchTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null) {
            return false;
        } else if (b == null) {
            return true;
        } else if (a.val != b.val) {
            return false;
        } else {
            return matchTree(a.left, b.left) && matchTree(a.right, b.right);
        }
    }

    public static void main(String[] args) {
        /*
            The BST looks like:
            
                      4
                   /    \
                  2      8
                /  \   /  \
               1   3  6   9
              /
             0
             
         */
        TreeNode treeRoot = new TreeNode(4);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(8);
        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.right = new TreeNode(3);
        treeRoot.left.left.left = new TreeNode(0);
        treeRoot.right.left = new TreeNode(6);
        treeRoot.right.right = new TreeNode(9);
        System.out.println(isT2SubtreeOfT1(treeRoot, treeRoot));
        System.out.println(isT2SubtreeOfT1(treeRoot, treeRoot.left));
        System.out.println(isT2SubtreeOfT1(treeRoot, treeRoot.right));

        /*
            The sub-tree:
            
                8
               /
              6
         */
        TreeNode treeRoot2 = new TreeNode(8);
        treeRoot2.left = new TreeNode(6);
        System.out.println(isT2SubtreeOfT1(treeRoot, treeRoot2));
        
        /*
            The sub-tree:
            
                2
               /
              1
         */
        TreeNode treeRoot3 = new TreeNode(2);
        treeRoot3.left = new TreeNode(1);
        System.out.println(isT2SubtreeOfT1(treeRoot, treeRoot3));

        /*
            The sub-tree:
            
                8
               /
              9
         */
        TreeNode treeRoot4 = new TreeNode(8);
        treeRoot4.left = new TreeNode(9);
        System.out.println(isT2SubtreeOfT1(treeRoot, treeRoot4));
    }
}