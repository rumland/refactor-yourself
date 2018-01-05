package com.umland.interviewcake.reverselinkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SinglyLinkedListTest {
    private final int jennBirthYear = 1984;
    private SinglyLinkedList singlyLinkedList;
    private SinglyNode expectedRoot;

    @Before
    public void beforeEachTest() throws AddNodePastEndOfListException {
        singlyLinkedList = new SinglyLinkedList();
        expectedRoot = new SinglyNode(jennBirthYear);
        singlyLinkedList.addAt(expectedRoot, 0);
    }

    @Test
    public void getRootTest() {
        assertEquals(expectedRoot, singlyLinkedList.getRoot());
    }

    @Test
    public void getNodeCountTest() {
        assertEquals(Integer.valueOf(1), singlyLinkedList.getNodeCount());
    }

    @Test
    public void addAtBeginningTest() throws AddNodePastEndOfListException {
        singlyLinkedList.addAt(new SinglyNode(1983), 0);

        int[] expectedBirthYears = new int[]{1983, jennBirthYear};
        int[] actualBirthYears = new int[2];
        SinglyNode currentNode = singlyLinkedList.getRoot();
        int nodeCounter = 0;
        while (currentNode != null) {
            actualBirthYears[nodeCounter] = currentNode.getValue();
            currentNode = currentNode.getNext();
            ++nodeCounter;
        }

        assertArrayEquals(expectedBirthYears, actualBirthYears);
    }

    @Test
    public void addAtEndTest() throws AddNodePastEndOfListException {
        singlyLinkedList.addAt(new SinglyNode(2017), singlyLinkedList.getNodeCount());

        int[] expectedBirthYears = new int[]{jennBirthYear, 2017};
        int[] actualBirthYears = new int[2];
        SinglyNode currentNode = singlyLinkedList.getRoot();
        int nodeCounter = 0;
        while (currentNode != null) {
            actualBirthYears[nodeCounter] = currentNode.getValue();
            currentNode = currentNode.getNext();
            ++nodeCounter;
        }

        assertArrayEquals(expectedBirthYears, actualBirthYears);
    }

    @Test
    public void addInMiddleTest() throws AddNodePastEndOfListException {
        singlyLinkedList.addAt(new SinglyNode(1983), 0);
        singlyLinkedList.addAt(new SinglyNode(2017), singlyLinkedList.getNodeCount());
        singlyLinkedList.addAt(new SinglyNode(2014), 2);

        int[] expectedBirthYears = new int[]{1983, jennBirthYear, 2014, 2017};
        int[] actualBirthYears = new int[4];
        SinglyNode currentNode = singlyLinkedList.getRoot();
        int nodeCounter = 0;
        while (currentNode != null) {
            actualBirthYears[nodeCounter] = currentNode.getValue();
            currentNode = currentNode.getNext();
            ++nodeCounter;
        }

        assertArrayEquals(expectedBirthYears, actualBirthYears);
    }

    @Test(expected = AddNodePastEndOfListException.class)
    public void addPastEndTest() throws AddNodePastEndOfListException {
        singlyLinkedList.addAt(new SinglyNode(2017), 50);
    }

    @Test
    public void reverseListTest() throws AddNodePastEndOfListException {
        singlyLinkedList.addAt(new SinglyNode(1983), 0);
        singlyLinkedList.addAt(new SinglyNode(2017), singlyLinkedList.getNodeCount());
        singlyLinkedList.addAt(new SinglyNode(2014), 2);
        singlyLinkedList.reverse();

        int[] expectedBirthYears = new int[]{2017, 2014, jennBirthYear, 1983};
        int[] actualBirthYears = new int[4];
        SinglyNode currentNode = singlyLinkedList.getRoot();
        int nodeCounter = 0;
        while (currentNode != null) {
            actualBirthYears[nodeCounter] = currentNode.getValue();
            currentNode = currentNode.getNext();
            ++nodeCounter;
        }

        assertArrayEquals(expectedBirthYears, actualBirthYears);
    }

    @Test
    public void reverseListOfSizeZeroTest() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.reverse();
        assertEquals(Integer.valueOf(0), sll.getNodeCount());
    }

    @Test
    public void reverseListOfSizeOneTest() {
        singlyLinkedList.reverse();

        int[] expectedBirthYears = new int[]{jennBirthYear};
        int[] actualBirthYears = new int[1];
        SinglyNode currentNode = singlyLinkedList.getRoot();
        int nodeCounter = 0;
        while (currentNode != null) {
            actualBirthYears[nodeCounter] = currentNode.getValue();
            currentNode = currentNode.getNext();
            ++nodeCounter;
        }

        assertArrayEquals(expectedBirthYears, actualBirthYears);
    }

    @Test
    public void reverseListOfSizeTwoTest() throws AddNodePastEndOfListException {
        singlyLinkedList.addAt(new SinglyNode(1983), 0);
        singlyLinkedList.reverse();

        int[] expectedBirthYears = new int[]{jennBirthYear, 1983};
        int[] actualBirthYears = new int[2];
        SinglyNode currentNode = singlyLinkedList.getRoot();
        int nodeCounter = 0;
        while (currentNode != null) {
            actualBirthYears[nodeCounter] = currentNode.getValue();
            currentNode = currentNode.getNext();
            ++nodeCounter;
        }

        assertArrayEquals(expectedBirthYears, actualBirthYears);
    }

    @Test
    public void reverseLargeListTest() {
        List<Integer> integers = IntStream.range(10, 1000000).boxed().collect(Collectors.toList());
        integers.forEach(value ->
        {
            try {
                singlyLinkedList.addAt(new SinglyNode(value), 0);
            } catch (AddNodePastEndOfListException e) {
                e.printStackTrace();
            }
        });
        integers.add(0, jennBirthYear);

        singlyLinkedList.reverse();

        List<Integer> actualBirthYears = new ArrayList<>(integers.size());
        SinglyNode currentNode = singlyLinkedList.getRoot();
        while (currentNode != null) {
            actualBirthYears.add(currentNode.getValue());
            currentNode = currentNode.getNext();
        }

        assertEquals(integers, actualBirthYears);
    }

    @Test
    public void getKthToLastValueTest() throws AddNodePastEndOfListException {
        singlyLinkedList.addAt(new SinglyNode(2014), singlyLinkedList.getNodeCount());
        singlyLinkedList.addAt(new SinglyNode(2017), singlyLinkedList.getNodeCount());
        singlyLinkedList.addAt(new SinglyNode(1983), 0);

        assertEquals(Integer.valueOf(2014), singlyLinkedList.getKthToLastValue(2));
    }
}