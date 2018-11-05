package com.sssr.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaojun.wzj
 * @version $Id PrintLeftView.java, v 0.1 2018-10-23 14:23 zhaojun.wzj Exp $$
 */
public class TreeNode {

    String              name;

    TreeNode            parent;

    List<TreeNode> childList = new ArrayList<>();

    public TreeNode(String name) {
        this.name = name;
    }

    public TreeNode() {
        this.name = null;
        this.parent = null;
        this.childList = new ArrayList<>();
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
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>parent</tt>.
     *
     * @return property value of parent
     */
    public TreeNode getParent() {
        return parent;
    }

    /**
     * Setter method for property <tt>parent</tt>.
     *
     * @param parent value to be assigned to property parent
     */
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    /**
     * Getter method for property <tt>childList</tt>.
     *
     * @return property value of childList
     */
    public List<TreeNode> getChildList() {
        return childList;
    }

    /**
     * Setter method for property <tt>childList</tt>.
     *
     * @param childList value to be assigned to property childList
     */
    public void setChildList(List<TreeNode> childList) {
        this.childList = childList;
    }

}