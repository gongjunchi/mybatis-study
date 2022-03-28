package org.zuel.common;

public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode temp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = temp;
        return root;
    }
}
