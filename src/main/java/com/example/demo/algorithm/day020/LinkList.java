package com.example.demo.algorithm.day020;


/**
 * LinkList
 */
public interface LinkList {


    // time complexity less than O(n)
    // if value exists return true otherwise return false
    boolean isExists(Integer value);

    // time complexity less than O(n)
    void add(Node node);


}
