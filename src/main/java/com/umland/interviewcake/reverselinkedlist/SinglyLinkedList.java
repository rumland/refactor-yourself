package com.umland.interviewcake.reverselinkedlist;

public class SinglyLinkedList {
    private SinglyNode root;
    private Integer nodeCount;

    SinglyLinkedList() {
        root = null;
        nodeCount = 0;
    }

    SinglyNode getRoot() {
        return root;
    }

    Integer getNodeCount() {
        return nodeCount;
    }

    public void addAt(SinglyNode newNode, Integer position) throws AddNodePastEndOfListException {
        if (position > nodeCount) {
            throw new AddNodePastEndOfListException("Cannot add node past end of list");
        }

        if (position == 0) {
            SinglyNode currentRoot = getRoot();
            root = newNode;
            root.setNext(currentRoot);
        } else {
            SinglyNode currentNode = getRoot();
            for (Integer idx = 1; idx < position; ++idx) {
                currentNode = currentNode.getNext();
            }
            SinglyNode originalNextNode = currentNode.getNext();
            currentNode.setNext(newNode);
            if (originalNextNode != null) {
                newNode.setNext(originalNextNode);
            }
        }

        ++nodeCount;
    }

    public void reverse() {
        if (getRoot() == null) {
            return;
        }

        SinglyNode priorNode = null;
        SinglyNode currentWorkingNode = getRoot();
        while (currentWorkingNode.getNext() != null) {
            root = currentWorkingNode.getNext();
            currentWorkingNode.setNext(priorNode);
            priorNode = currentWorkingNode;
            currentWorkingNode = root;
        }
        currentWorkingNode.setNext(priorNode);
    }

    public Integer getKthToLastValue(int kthToLast) {
        SinglyNode currentNode = getRoot();
        for (int idx = 0; idx < getNodeCount() - kthToLast; ++idx) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getValue();
    }
}
