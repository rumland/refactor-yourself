package com.umland.interviewcake.reverselinkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SinglyNodeTest {
    private SinglyNode singlyNode = new SinglyNode(2014);

    @Test
    public void getValue() {
        assertEquals(0, Integer.compare(2014, singlyNode.getValue()));
    }

    @Test
    public void getNext() {
        assertEquals(null, singlyNode.getNext());
    }

    @Test
    public void setNext() {
        SinglyNode lln = new SinglyNode(2017);
        singlyNode.setNext(lln);
        assertEquals(lln, singlyNode.getNext());
    }
}