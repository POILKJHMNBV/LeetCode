package com.example.graph;

import java.util.ArrayList;

/**
 * 图中结点的基本数据结构
 */
public class Node<E> {
    /**
     * 结点存储的数据
     */
    public E item;

    /**
     * 结点的入度
     */
    public int in;

    /**
     * 结点的出度
     */
    public int out;

    /**
     * 以该结点为弧尾的邻接结点
     */
    public ArrayList<Node<E>> adjacentList;

    /**
     * 从该结点发散出去的边
     */
    public ArrayList<Edge<E>> edges;

    public Node(E item) {
        this.item = item;
        in = 0;
        out = 0;
        adjacentList = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
       return super.hashCode();
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
