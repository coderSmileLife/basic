package com.example.demo.algorithm.day020;

public class Test {


    /**
     * test isExists and add
     */
    public static void main(String[] args) {
        LinkList list = new LinkListImpl();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));

        System.out.println(list.isExists(1));
        System.out.println(list.isExists(2));
        System.out.println(list.isExists(3));
    }
}