package com.sssr.advance.mtreewidth;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @author zhaojun.wzj
 * @version $Id MTree.java, v 0.1 2018-10-25 15:24 zhaojun.wzj Exp $$
 */
public class MTree {

    static TreeNode rootNode = new TreeNode("A");

    static {
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        TreeNode nodeH = new TreeNode("H");
        TreeNode nodeI = new TreeNode("I");
        TreeNode nodeJ = new TreeNode("J");
        TreeNode nodeK = new TreeNode("K");

        rootNode.setSubNodes(Arrays.asList(nodeB, nodeC));
        nodeB.setSubNodes(Arrays.asList(nodeE, nodeF));
        nodeE.setSubNodes(Arrays.asList(nodeG));
        nodeF.setSubNodes(Arrays.asList(nodeH));
        nodeC.setSubNodes(Arrays.asList(nodeI, nodeJ));
        nodeJ.setSubNodes(Arrays.asList(nodeK));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(rootNode);

        preOrder(rootNode, 1);
        System.out.printf("\n");
    }

    /**
     * 前序遍历
     *
     * @param treeNode
     * @param depth
     */
    private static void preOrder(TreeNode treeNode, int depth) {
        System.out.print(treeNode.getName() + "  ");

        List<TreeNode> treeNodeList = treeNode.getSubNodes();
        if (CollectionUtils.isNotEmpty(treeNodeList)) {
            for (TreeNode tnode : treeNodeList) {
                preOrder(tnode, depth + 1);
            }
        }
    }

    /**
     * 中序遍历 LNR
     * @param treeNode
     * @param depth
     */
    private static void midOrder(TreeNode treeNode, int depth) {
        System.out.print(treeNode.getName() + "  ");

        List<TreeNode> treeNodeList = treeNode.getSubNodes();
        if (CollectionUtils.isNotEmpty(treeNodeList)) {
            for (TreeNode tnode : treeNodeList) {
                preOrder(tnode, depth + 1);
            }
        }
    }

}