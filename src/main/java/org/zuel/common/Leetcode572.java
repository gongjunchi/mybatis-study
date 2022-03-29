package org.zuel.common;

public class Leetcode572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 注意这个函数是判断子树，不是判断树相等了
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            // subRoot一定不为null，如果此时root为null，结果一定是false
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 判断两棵树是否相同，基本代码
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            // 两个节点都是null，相同
            return true;
        }
        if (root == null || subRoot == null) {
            // 有一个是null
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
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
