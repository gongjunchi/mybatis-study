package org.zuel.common;

public class Leetcode572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot != null && root == null) {
            return false;
        }
        if (subRoot == null) {
            return root == null;
        }
        if (root.val == subRoot.val) {
            return isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        Leetcode572 leetcode572 = new Leetcode572();
        TreeNode root = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        root.left = node4;
        root.right = node5;
        node4.left = node1;
        node4.right = node2;
        node2.left = node0;

        TreeNode subRoot = new TreeNode(4);
        TreeNode subRoot1 = new TreeNode(1);
        TreeNode subRoot2 = new TreeNode(2);
        subRoot.left = subRoot1;
        subRoot.right = subRoot2;

        System.out.println(leetcode572.isSubtree(root, subRoot));
    }
}
