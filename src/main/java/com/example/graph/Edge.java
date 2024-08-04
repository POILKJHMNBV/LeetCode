package com.example.graph;

/**
 * 图中边的基本数据结构
 */
public class Edge<E> {
    /**
     * 边上的权值
     */
    public int weight;

    /**
     * 边的弧尾
     */
    public Node<E> from;

    /**
     * 边的弧头
     */
    public Node<E> to;

    public Edge(int weight, Node<E> from, Node<E> to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
