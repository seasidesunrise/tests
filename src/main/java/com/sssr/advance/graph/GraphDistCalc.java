package com.sssr.advance.graph;

import com.google.common.graph.MutableGraph;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * �����������
 *
 * @author zhaojun.wzj
 * @version $Id GraphDistCalc.java, v 0.1 2018-10-17 13:10 zhaojun.wzj Exp $$
 */
public class GraphDistCalc {

    /** ·���ָ��� */
    private static final String PATH_SEP = "->";

    /** s���ϣ��Ѽ����� */
    private TreeMap<String, GraphNode> sMap = new TreeMap<String, GraphNode>();

    /** u���ϣ��������� */
    private Map<String, GraphNode> uMap = Collections.synchronizedMap(new LinkedHashMap<String, GraphNode>());

    /**
     * �����·��
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
            // ȡuMap��ȡֵ��С�Ľڵ�����
            String nodeName = getMinNodeFromUMap(uMap);

            GraphNode currNode = uMap.get(nodeName);
            sMap.put(currNode.getName(), currNode);

            // ���½ڵ����·��
            String sPath = currNode.getPath();
            if (StringUtils.isEmpty(sPath)) {
                sPath = prevPath + PATH_SEP + currNode.getName();
            }
            currNode.setPath(sPath);

            // ��ӵ�sMap�󣬴�uMap��ɾ��
            uMap.remove(currNode.getName());

            // ����ʱ��־����ɾ��
            System.out.println("\nsList:" + sMap);
            System.out.println("uList:" + uMap + "\n");

            // �����ӽ����롢·�����Լ��Կ��ܳ��ֻ�·�Ĵ���
            updateDist(graph, uMap, currNode);
        }

        // ����value���򣬴�sMap��ȡ�����
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
     * ���½ڵ�·������������ԣ��Լ���·����
     *
     * @param graph
     * @param sMap
     * @param currNode
     */
    private void updateDist(MutableGraph<GraphNode> graph, Map<String, GraphNode> sMap, GraphNode currNode) {
        // ����node��Ӧ�ĺ�̽ڵ�
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
     * ��u�����л�ȡ��С�ڵ�
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
     * S���ϣ�U���ϳ�ʼ��
     *
     * @param graph
     * @param graphNode
     * @throws Exception
     */
    private void initSUMap(MutableGraph<GraphNode> graph, GraphNode nodeA) throws Exception {
        // ��ʼ��sMap
        nodeA.setDist(nodeA.getValue());
        sMap.put(nodeA.getName(), nodeA);


        // ��ʼ��uMap
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