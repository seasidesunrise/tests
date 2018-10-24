/**
 * Alipay.com Inc.
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.sssr.tree;

import java.util.Arrays;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @author zhaojun.wzj
 * @version $Id MTree.java, v 0.1 2018-10-23 16:02 zhaojun.wzj Exp $$
 */
public class MTree {

    public static TreeNode nodeA = new TreeNode("A");

    private static void displayTree(TreeNode f, int level) {
        // µÝ¹éÏÔÊ¾Ê÷
        String preStr = "";
        for (int i = 0; i < level; i++) {
            preStr += "    ";
        }

        for (int i = 0; i < f.childList.size(); i++) {
            TreeNode t = f.childList.get(i);
            System.out.println(preStr + "-" + t.name);

            if (!t.childList.isEmpty()) {
                displayTree(t, level + 1);
            }
        }

    }

    /**
     * ÐÞ¼ôÕâ¿Å¶à²æÊ÷
     *
     * @param f
     */
    public static void trim(TreeNode f) {
        if (CollectionUtils.isNotEmpty(f.childList)) {
            for (TreeNode tnode : f.childList) {
                if (tnode != null && CollectionUtils.isEmpty(tnode.childList) && tnode.parent.childList.size() == 1) {
                    if (tnode.parent.parent.equals(nodeA)) {
                        // replace nodeE to nodeF
                        for (int j = 0; j < nodeA.childList.size(); j++) {
                            TreeNode no = nodeA.childList.get(j);
                            if (no.equals(tnode.parent)) {
                                nodeA.childList.set(j, tnode);
                                if (!tnode.parent.equals(nodeA)) {
                                    trim(tnode.parent);
                                }
                                break;
                            }
                        }
                    } else {
                        tnode.parent = tnode.parent.parent;
                        tnode.parent.childList = Arrays.asList(tnode);
                        trim(tnode.parent);
                    }
                } else {
                    trim(tnode);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        TreeNode nodeA = new TreeNode("A");
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

        MTree.nodeA = nodeA;
        nodeA.parent = null;
        nodeA.childList = Arrays.asList(nodeB, nodeE, nodeG, nodeJ);

        nodeB.parent = nodeA;
        nodeB.childList = Arrays.asList(nodeC);

        nodeC.parent = nodeB;
        nodeC.childList = Arrays.asList(nodeD);

        nodeD.parent = nodeC;

        nodeE.parent = nodeA;
        nodeE.childList = Arrays.asList(nodeF);

        nodeF.parent = nodeE;

        nodeG.parent = nodeA;
        nodeG.childList = Arrays.asList(nodeH, nodeI);

        nodeH.parent = nodeG;

        nodeI.parent = nodeG;


        nodeJ.parent = nodeA;
        nodeJ.childList = Arrays.asList(nodeK);

        nodeK.parent = nodeJ;

        displayTree(nodeA, 0);
        trim(nodeA);
        System.out.println("--------------------------------------------------");
        displayTree(nodeA, 0);

    }

}