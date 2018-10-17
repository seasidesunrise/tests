package com.sssr.advance.graph;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

/**
 * Graph单元测试
 *
 * @author zhaojun.wzj
 * @version $Id GraphTest.java, v 0.1 2018-10-17 11:53 zhaojun.wzj Exp $$
 */
public class GraphDistTest {

    MutableGraph<GraphNode> graph1 = null;

    GraphNode resultNode = null;

    private GraphNode nodeA = null, nodeB = null, nodeC = null, nodeD = null, nodeE = null;

    @Before
    public void before() {
        graph1 = GraphBuilder.directed()
                .nodeOrder(ElementOrder.<GraphNode>insertion())
                .expectedNodeCount(10)
                .allowsSelfLoops(true)
                .build();

        nodeA = new GraphNode("A", 1);
        nodeB = new GraphNode("B", 2);
        nodeC = new GraphNode("C", 2);
        nodeD = new GraphNode("D", 4);
        nodeE = new GraphNode("E", 5);
    }

    @After
    public void after() throws Exception {
        Set<GraphNode> nodes = graph1.nodes();
        System.out.println("graph1 nodes count:" + nodes.size() + ", nodes value:" + format(nodes));

        resultNode = new GraphDistCalc().calc(graph1, nodeA);
        System.out.println("max dist:" + resultNode.getDist() + ", maxPath:" + resultNode.getPath());

        graph1 = null;
    }

    private static <T> String format(Iterable<T> iterable) {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (T obj : iterable) {
            builder.append(obj).append(",");
        }
        if (builder.length() > 1) {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("}");
        return builder.toString();
    }

    @Test
    public void test1() {
        graph1.putEdge(nodeA, nodeB);
        graph1.putEdge(nodeB, nodeC);
        graph1.putEdge(nodeA, nodeC);
    }

    @Test
    public void test2() {
        graph1.putEdge(nodeA, nodeB);
        graph1.putEdge(nodeA, nodeC);
        graph1.putEdge(nodeC, nodeD);
        graph1.putEdge(nodeD, nodeE);
    }

    @Test
    public void test3() {
        graph1.putEdge(nodeA, nodeB);
        graph1.putEdge(nodeA, nodeC);
        graph1.putEdge(nodeA, nodeD);
        graph1.putEdge(nodeC, nodeE);
    }

    @Test
    public void test4() {
        graph1.putEdge(nodeA, nodeC);
        graph1.putEdge(nodeA, nodeB);
        graph1.putEdge(nodeC, nodeD);
    }

    /**
     * A->B->C
     */
    @Test
    public void testLoop() {
        graph1.putEdge(nodeA, nodeB);
        graph1.putEdge(nodeB, nodeC);
        graph1.putEdge(nodeC, nodeA);
    }

    /**
     * A->C->D->B
     */
    @Test
    public void testLoop2() {
        graph1.putEdge(nodeA, nodeB);
        graph1.putEdge(nodeA, nodeC);
        graph1.putEdge(nodeC, nodeD);
        graph1.putEdge(nodeD, nodeB);
    }

}