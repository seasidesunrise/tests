/**
 * Alipay.com Inc.
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
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

    int layer = 0; //����һ��ȫ�ֱ�����������layer,  depth�ǵݹ����ȡ�

    public void printleftVeiw(TreeNode root, int depth) {
        if (depth > layer) { //����ȴ��ڲ��ʱ���ʹ�ӡ��  ��Ϊ�ݹ���������ң�����ÿһ�� ��һ����ȴ��ڲ�εĽڵ�һ��Ϊ����ͼ�Ľڵ㡣
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
        // ����������
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