package com.example.demo.algorithm.day020;


/**
 * LinkList 实现
 */
public class LinkListImpl implements LinkList {

    // 队列尾
    private Node last;


    public LinkListImpl() {
    }


    @Override
    public boolean isExists(Integer value) {
        if (null == last || null == value) return false;
        // 临时变量
        Node tmp = last;
        // 循环直到最后一个元素
        while (null != tmp.getPrev()) {
            // last的上一个元素
            Node element = tmp.getPrev();

            if (value.equals(tmp.getValue()) || value.equals(element.getValue())) {// last 或 last上一个元素钰目标元素相等
                return true;
            } else { // 否则取last prev 作为last元素
                tmp = tmp.getPrev();
            }
        }

        return false;
    }

    @Override
    public void add(Node node) {
        // 取队列最后一个元素，作为临时变量
        Node element = last;
        // 重新构造当前添加元素
        // 始终将最新添加元素作为last
        last = new Node(element, node);
        if (null != element) { // 否则，将 "上次添加队尾元素" 作为新添加元素的prev
            last.setPrev(element);
        }
    }
}
