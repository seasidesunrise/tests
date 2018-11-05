package com.sssr.tree.binarytree;

/**
 * @author zhaojun.wzj
 * @version $Id PrintLeftView.java, v 0.1 2018-10-23 19:31 zhaojun.wzj Exp $$
 */
public class PrintLeftView {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int      val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int layer = 0; //定义一个全局变量，最大层数layer,  depth是递归的深度。

    public void printleftVeiw(TreeNode root, int depth) {
        if (depth > layer) { //当深度大于层次时，就打印。  因为递归是先左后右，所以每一层 第一个深度大于层次的节点一定为左视图的节点。
            System.out.println(root.val);
            layer++;
        }
        if (root.left != null) {
            printleftVeiw(root.left, depth + 1);
        }
        if (root.right != null) {
            printleftVeiw(root.right, depth + 1);
        }
    }

    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        PrintLeftView test = new PrintLeftView();
        test.printleftVeiw(root, 1);
    }

}