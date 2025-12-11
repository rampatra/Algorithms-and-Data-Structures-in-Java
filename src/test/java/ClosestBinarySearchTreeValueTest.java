import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestBinarySearchTreeValueTest {
    @Test
    void testNullRoot() {
        assertEquals(-1, ClosestBinarySearchTreeValue.closestValue(null, 10.0) );
    }

    @Test
    void testSingleNode() {
        TreeNode root = new TreeNode(10);

        assertEquals(10, ClosestBinarySearchTreeValue.closestValue(root, 5.0));
    }

    @Test
    void testCloserToLeftChild() {
        //      10
        //     /
        //    7
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);

        assertEquals(7, ClosestBinarySearchTreeValue.closestValue(root, 8.0));
    }

    @Test
    void testCloserToRightChild() {
        //      10
        //        \
        //         13
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(13);

        assertEquals(13, ClosestBinarySearchTreeValue.closestValue(root, 12.0));
    }

    @Test
    void testTieBreaking() {
        //      10
        //        \
        //         13
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(13);

        assertEquals(10, ClosestBinarySearchTreeValue.closestValue(root, 11.0));
    }

    @Test
    void testComplexTree() {
        // Let's stick to a valid BST construction.
        //       10
        //     /   \
        //    7     13
        //   / \   /  \
        //  5   9 13   20

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(20);

        assertEquals(7, ClosestBinarySearchTreeValue.closestValue(root, 8.0));
        assertEquals(9, ClosestBinarySearchTreeValue.closestValue(root, 8.1));
    }
}
