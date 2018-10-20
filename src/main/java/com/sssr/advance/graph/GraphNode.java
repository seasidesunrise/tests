package com.sssr.advance.graph;

/**
 * 结点模型
 *
 * @author zhaojun.wzj
 * @version $Id GraphNode.java, v 0.1 2018-10-17 12:27 zhaojun.wzj Exp $$
 */
public class GraphNode {

    /** 结点名称 */
    private String name;

    /** 结点权重 */
    private Integer value;

    /** 结点距离 */
    private Integer dist;

    /** 结点路径 */
    private String path;

    public GraphNode() {

    }

    public GraphNode(String name, Integer value) {
        this.name = name;
        this.value = value;
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
     * Getter method for property <tt>value</tt>.
     *
     * @return property value of value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Setter method for property <tt>value</tt>.
     *
     * @param value value to be assigned to property value
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Getter method for property <tt>dist</tt>.
     *
     * @return property value of dist
     */
    public Integer getDist() {
        return dist;
    }

    /**
     * Setter method for property <tt>dist</tt>.
     *
     * @param dist value to be assigned to property dist
     */
    public void setDist(Integer dist) {
        this.dist = dist;
    }

    /**
     * Getter method for property <tt>path</tt>.
     *
     * @return property value of path
     */
    public String getPath() {
        return path;
    }

    /**
     * Setter method for property <tt>path</tt>.
     *
     * @param path value to be assigned to property path
     */
    public void setPath(String path) {
        this.path = path;
    }

    public String toString() {
        return "node:" + this.getName() + "[" + this.getValue() + "|" + this.dist + "|" + this.path + "]";
    }

}