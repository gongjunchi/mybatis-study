package org.zuel.common;

public class Offer68_1 {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > p.val && root.val > q.val) {
            lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            lowestCommonAncestor(root.right, p, q);
        } else {
            res = root;
        }
        return res;
    }

    // 递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
