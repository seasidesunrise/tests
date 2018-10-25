package com.sssr.advance.mtreewidth;

/**
 * @author zhaojun.wzj
 * @version $Id BinTreeNode.java, v 0.1 2018-10-25 15:58 zhaojun.wzj Exp $$
 */
public class BinTreeNode {

    private String      name;

    private int depth = 1;

    private BinTreeNode leftNode;

    private BinTreeNode rightNode;

    public BinTreeNode(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for property <tt>depth</tt>.
     *
     * @return property value of depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Setter method for property <tt>depth</tt>.
     *
     * @param depth value to be assigned to property depth
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>leftNode</tt>.
     *
     * @return property value of leftNode
     */
    public BinTreeNode getLeftNode() {
        return leftNode;
    }

    /**
     * Setter method for property <tt>leftNode</tt>.
     *
     * @param leftNode value to be assigned to property leftNode
     */
    public void setLeftNode(BinTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    /**
     * Getter method for property <tt>rightNode</tt>.
     *
     * @return property value of rightNode
     */
    public BinTreeNode getRightNode() {
        return rightNode;
    }

    /**
     * Setter method for property <tt>rightNode</tt>.
     *
     * @param rightNode value to be assigned to property rightNode
     */
    public void setRightNode(BinTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}