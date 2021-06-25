package com.samcrowley;

public class Node {

    private final int value;
    private int height;

    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
        this.value = value;
        height = 1;
    }

    public int getValue() {
        return value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node left) {
        leftChild = left;
    }

    public void setRightChild(Node right) {
        rightChild = right;
    }

}
