package com.sssr.advance.mtreewidth;

import java.util.List;

/**
 * @author zhaojun.wzj
 * @version $Id TreeNode.java, v 0.1 2018-10-25 15:24 zhaojun.wzj Exp $$
 */
public class TreeNode {

    private String         name;

    private List<TreeNode> subNodes;

    public TreeNode() {

    }

    public TreeNode(String name) {
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
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>subNodes</tt>.
     *
     * @return property value of subNodes
     */
    public List<TreeNode> getSubNodes() {
        return subNodes;
    }

    /**
     * Setter method for property <tt>subNodes</tt>.
     *
     * @param subNodes value to be assigned to property subNodes
     */
    public void setSubNodes(List<TreeNode> subNodes) {
        this.subNodes = subNodes;
    }
}