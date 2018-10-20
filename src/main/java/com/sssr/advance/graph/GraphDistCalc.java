package com.sssr.advance.graph;

import com.google.common.graph.MutableGraph;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 结点距离计算类
 *
 * @author zhaojun.wzj
 * @version $Id GraphDistCalc.java, v 0.1 2018-10-17 13:10 zhaojun.wzj Exp $$
 */
public class GraphDistCalc {

    /** 路径分隔符 */
    private static final String PATH_SEP = "->";

    /** s集合，已计算结点 */
    private TreeMap<String, GraphNode> sMap = new TreeMap<String, GraphNode>();

    /** u集合，待计算结点 */
    private Map<String, GraphNode> uMap = Collections.synchronizedMap(new LinkedHashMap<String, GraphNode>());

    /**
     * 计算最长路径
     *
     * @param graph
     * @param nodeA
     * @return
     * @throws Exception
     */
    public GraphNode calc(MutableGraph<GraphNode> graph, GraphNode nodeA) throws Exception {
        initSUMap(graph, nodeA);

        String prevPath = nodeA.getName();
        while (uMap.size() > 0) {
            // 取uMap中取值最小的节点名称
            String nodeName = getMinNodeFromUMap(uMap);

            GraphNode currNode = uMap.get(nodeName);
            sMap.put(currNode.getName(), currNode);

            // 更新节点访问路径
            String sPath = currNode.getPath();
            if (StringUtils.isEmpty(sPath)) {
                sPath = prevPath + PATH_SEP + currNode.getName();
            }
            currNode.setPath(sPath);

            // 添加到sMap后，从uMap中删除
            uMap.remove(currNode.getName());

            // 运行时日志，可删除
            System.out.println("\nsList:" + sMap);
            System.out.println("uList:" + uMap + "\n");

            // 更新子结点距离、路径，以及对可能出现环路的处理
            updateDist(graph, uMap, currNode);
        }

        // 根据value排序，从sMap中取出结果
        if (sMap != null && sMap.size() > 0) {
            int maxValue = 0;
            String maxValNodeName = null;
            Set<Map.Entry<String, GraphNode>> entrySet = sMap.entrySet();
            Iterator<Map.Entry<String, GraphNode>> iter = entrySet.iterator();
            while (iter.hasNext()) {
                Map.Entry<String, GraphNode> entry = iter.next();
                GraphNode node = entry.getValue();
                if (node.getDist() > maxValue) {
                    maxValue = node.getDist();
                    maxValNodeName = node.getName();
                }
            }

            if (maxValNodeName != null) {
                return sMap.get(maxValNodeName);
            }
        }

        return null;
    }

    /**
     * 更新节点路径及距离等属性，以及环路控制
     *
     * @param graph
     * @param sMap
     * @param currNode
     */
    private void updateDist(MutableGraph<GraphNode> graph, Map<String, GraphNode> sMap, GraphNode currNode) {
        // 查找node对应的后继节点
        Set<GraphNode> nodeASuccs = graph.successors(currNode);
        if (CollectionUtils.isEmpty(nodeASuccs)) {
            return;
        }

        Iterator<GraphNode> nodeIt2 = nodeASuccs.iterator();
        while (nodeIt2.hasNext()) {
            GraphNode myNode1 = nodeIt2.next();

            String[] pathArr = currNode.getPath().split(PATH_SEP);
            if (!Arrays.asList(pathArr).contains(myNode1.getName())) {
                int value = myNode1.getValue() + currNode.getDist();
                String path = currNode.getPath() + PATH_SEP + myNode1.getName();

                myNode1.setDist(value);
                myNode1.setPath(path);

                if (uMap != null && !uMap.containsKey(myNode1.getName())) {
                    uMap.put(myNode1.getName(), myNode1);
                }
            }

        }
    }

    /**
     * 从u集合中获取最小节点
     *
     * @param uMap
     * @return
     */
    private String getMinNodeFromUMap(Map<String, GraphNode> uMap) {
        int minValue = Integer.MAX_VALUE;
        String nodeName = null;

        Set<Map.Entry<String, GraphNode>> entrySet = uMap.entrySet();
        Iterator<Map.Entry<String, GraphNode>> iter = entrySet.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, GraphNode> entry = iter.next();
            GraphNode node = entry.getValue();

            if (node != null && node.getDist() < minValue) {
                minValue = node.getDist();
                nodeName = node.getName();
            }

        }

        return nodeName;
    }

    /**
     * S集合，U集合初始化
     *
     * @param graph
     * @param graphNode
     * @throws Exception
     */
    private void initSUMap(MutableGraph<GraphNode> graph, GraphNode nodeA) throws Exception {
        // 初始化sMap
        nodeA.setDist(nodeA.getValue());
        sMap.put(nodeA.getName(), nodeA);


        // 初始化uMap
        Set<GraphNode> nodeASuccs = graph.successors(nodeA);
        Iterator<GraphNode> nodeASIt = nodeASuccs.iterator();
        while (nodeASIt.hasNext()) {
            GraphNode myNode = nodeASIt.next();
            myNode.setDist(nodeA.getValue() + myNode.getValue());

            uMap.put(myNode.getName(), myNode);
        }

        Set<GraphNode> nodeSet = graph.nodes();
        Iterator<GraphNode> nodeSetIt2 = nodeSet.iterator();
        while (nodeSetIt2.hasNext()) {
            GraphNode myNode = nodeSetIt2.next();
            if (StringUtils.equals(myNode.getName(), nodeA.getName())) {
                continue;
            }
            if (nodeASuccs.contains(myNode)) {
                continue;
            }
            myNode.setDist(Integer.MAX_VALUE);
            uMap.put(myNode.getName(), myNode);
        }
    }

}