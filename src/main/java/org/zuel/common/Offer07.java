package org.zuel.common;

import java.util.HashMap;
import java.util.Map;

public class Offer07 {

    // 做两个全局变量，减少传参
    // 把前序遍历结果存在全局数组里，方便取元素
    int[] preOrder;
    // 做一个map，方便在中序遍历数组中找根节点下标，否则每次拿都要遍历，用时间换空间
    Map<Integer, Integer> map =  new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return rebuildTree(0, preOrder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 构建一个二叉树，需要知道根节点，左子树的所有元素（数组里的开始下标和结束下标），右子树的所有元素
     * @param preL：前序遍历中树的左边界
     * @param preR：前序遍历中树的右边界
     * @param inL：中序遍历中树的左边界
     * @param inR：中序遍历中树的右边界
     * @return
     */
    public TreeNode rebuildTree(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        // 前序遍历的第一个元素一定是当前树的根节点
        TreeNode root = new TreeNode(preOrder[preL]);
        // 取根节点在中序遍历中的下标，接下来的计算中会经常用这个值
        int rootInIndex = map.get(preOrder[preL]);
        // 关键在于计算左子树长度：左子树长度 = 中序遍历根节点下标 - 左子树左边界 = rootInindex - inL
//        root.left = rebuildTree(preL + 1, preL + 左子树长度, inL, rootInIndex - 1);
//        root.right = rebuildTree(preL + 左子树长度 + 1, preR, rootInIndex + 1, inR);
        root.left = rebuildTree(preL + 1, preL + (rootInIndex - inL), inL, rootInIndex - 1);
        root.right = rebuildTree(preL + (rootInIndex - inL) + 1, preR, rootInIndex + 1, inR);
        return root;
    }

    public static void main(String[] args) {
        new Offer07();
    }
}
