package com.example.demo.algorithm.day020;


/**
 * 节点
 */
public class Node {

    private Integer value;

    private Node prev;


    public Node() {
    }

    public Node(Integer value) {
        this.value = value;
    }

    public Node(Node prev, Node value) {
        this.prev = prev;
        this.value = value.value;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
