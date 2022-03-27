package org.zuel.common;

public class Offer68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 树的递归基本都是对root节点的操作
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右子树都不包含p,q
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // left和right同时不为空，说明p,q在
        return root;
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (isChildren(root.left, p) && isChildren(root.left, q)) {
//            return lowestCommonAncestor(root.left, p, q);
//        }
//        if (isChildren(root.right, p) && isChildren(root.right, q)) {
//            return lowestCommonAncestor(root.right, p, q);
//        }
//        return root;
//    }
//
//    // 判断指定节点是否是当前节点的子节点
//    public boolean isChildren(TreeNode root, TreeNode target) {
//        if (root == target) {
//            return true;
//        }
//        if (root == null) {
//            return false;
//        }
//        isChildren(root.left, target);
//        isChildren(root.right,target);
//        return false;
//    }
}
