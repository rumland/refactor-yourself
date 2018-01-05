package com.umland.interviewcake.reverselinkedlist;

//TODO: use generics instead of forcing type to Integer
public class SinglyNode implements Comparable<Integer> {
    private Integer value;
    private SinglyNode next;

    SinglyNode(Integer value) {
        this.value = value;
        this.next = null;
    }

    public Integer getValue() {
        return value;
    }

    public SinglyNode getNext() {
        return next;
    }

    public void setNext(SinglyNode next) {
        this.next = next;
    }

    @Override
    public int compareTo(Integer o) {
        return o.compareTo(getValue());
    }
}
