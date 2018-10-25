package com.sssr.advance.mtreewidth;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zhaojun.wzj
 * @version $Id BinTree.java, v 0.1 2018-10-25 16:43 zhaojun.wzj Exp $$
 */
public class BinTree {

    static BinTreeNode rootNode = new BinTreeNode("A");

    static {
        BinTreeNode nodeB = new BinTreeNode("B");
        BinTreeNode nodeC = new BinTreeNode("C");
        BinTreeNode nodeD = new BinTreeNode("D");
        BinTreeNode nodeE = new BinTreeNode("E");
        BinTreeNode nodeF = new BinTreeNode("F");
        BinTreeNode nodeG = new BinTreeNode("G");
        BinTreeNode nodeH = new BinTreeNode("H");
        BinTreeNode nodeI = new BinTreeNode("I");
        BinTreeNode nodeJ = new BinTreeNode("J");
        BinTreeNode nodeK = new BinTreeNode("K");

        rootNode.setLeftNode(nodeB);
        rootNode.setRightNode(nodeC);

        nodeB.setLeftNode(nodeE);
        nodeB.setRightNode(nodeF);

        nodeE.setLeftNode(nodeG);
        nodeF.setRightNode(nodeH);

        nodeC.setLeftNode(nodeI);
        nodeC.setRightNode(nodeJ);

        nodeJ.setRightNode(nodeK);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(rootNode);
        preOrder(rootNode, 1);
        System.out.printf("\n");
        midOrder(rootNode, 1);
        System.out.println("\n");
        sufOrder(rootNode, 1);
        System.out.println("\n");
        BFSOrder(rootNode, 1);
    }

    /**
     * 前序遍历
     *
     * @param treeNode
     * @param depth
     */
    private static void preOrder(BinTreeNode treeNode, int depth) {
        System.out.print(treeNode.getName() + "  ");

        BinTreeNode leftnode = treeNode.getLeftNode();
        if (leftnode != null) {
            preOrder(leftnode, depth + 1);
        }

        BinTreeNode rightnode = treeNode.getRightNode();
        if (rightnode != null) {
            preOrder(rightnode, depth + 1);
        }
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     * @param depth
     */
    private static void midOrder(BinTreeNode treeNode, int depth) {
        BinTreeNode leftnode = treeNode.getLeftNode();
        if (leftnode != null) {
            midOrder(leftnode, depth + 1);
        }

        System.out.print(treeNode.getName() + "  ");

        BinTreeNode rightnode = treeNode.getRightNode();
        if (rightnode != null) {
            midOrder(rightnode, depth + 1);
        }
    }

    /**
     * 后序遍历
     *
     * @param treeNode
     * @param depth
     */
    private static void sufOrder(BinTreeNode treeNode, int depth) {
        BinTreeNode leftnode = treeNode.getLeftNode();
        if (leftnode != null) {
            sufOrder(leftnode, depth + 1);
        }

        BinTreeNode rightnode = treeNode.getRightNode();
        if (rightnode != null) {
            sufOrder(rightnode, depth + 1);
        }

        System.out.print(treeNode.getName() + "  ");
    }

    /**
     * 层序遍历
     *
     * @param treeNode
     * @param depth
     */
    private static void BFSOrder(BinTreeNode treeNode, int depth) {
        if (treeNode == null) {
            return;
        }

        Queue<BinTreeNode> queue = new ArrayDeque<BinTreeNode>();
        queue.offer(treeNode);
        treeNode.setDepth(depth);
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            System.out.print(treeNode.getName() + "|" + treeNode.getDepth() + "\t");
            BinTreeNode leftNode = treeNode.getLeftNode();
            if (leftNode != null) {
                leftNode.setDepth(treeNode.getDepth() + 1);
                queue.offer(leftNode);
            }
            BinTreeNode rightNode = treeNode.getRightNode();
            if (rightNode != null) {
                rightNode.setDepth(treeNode.getDepth() + 1);
                queue.offer(rightNode);
            }
        }

    }
}