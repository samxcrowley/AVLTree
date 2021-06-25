package com.samcrowley;

public class AVLTree {

    public Node root;

    public Node insert(Node node, int value) {

        // create new head node if none exists
        if (node == null) return new Node(value);

        // insert node either to the left or right depending on value
        if (value < node.getValue()) {
            node.setLeftChild(insert(node.getLeftChild(), value));
        } else if (value > node.getValue()) {
            node.setRightChild(insert(node.getRightChild(), value));
        } else { // no duplicate values, ignore this node
            return node;
        }

        // update height of the root node
        node.setHeight(Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1);

        int balanceFactor = getBalanceFactor(node);

        // rebalance node
        if (balanceFactor > 1) {

            // case 1
            if (value < node.getLeftChild().getValue()) {
                return rotateRight(node);

            // case 2
            } else if (value > node.getLeftChild().getValue()) {
                node.setLeftChild(node.getLeftChild());
                return rotateRight(node);
            }

        } else if (balanceFactor < -1) {

            // case 3
            if (value > node.getRightChild().getValue()) {
                return rotateLeft(node);

            // case 4
            } else if (value < node.getRightChild().getValue()) {
                node.setRightChild(rotateRight(node.getRightChild()));
                return rotateLeft(node);
            }

        }

        return node;

    }

    private Node rotateLeft(Node node) {

        Node r = node.getRightChild();
        Node t = r.getLeftChild();

        r.setLeftChild(node);
        node.setRightChild(t);

        int leftHeight1 = getHeight(node.getLeftChild());
        int leftHeight2 = getHeight(r.getLeftChild());
        int rightHeight1 = getHeight(node.getRightChild());
        int rightHeight2 = getHeight(r.getRightChild());

        node.setHeight(Math.max(leftHeight1, rightHeight1) + 1);
        r.setHeight(Math.max(leftHeight2, rightHeight2) + 1);

        return r;

    }

    private Node rotateRight(Node node) {

        Node r = node.getLeftChild();
        Node t = r.getRightChild();

        r.setRightChild(node);
        node.setLeftChild(t);

        int leftHeight1 = getHeight(node.getLeftChild());
        int leftHeight2 = getHeight(r.getLeftChild());
        int rightHeight1 = getHeight(node.getRightChild());
        int rightHeight2 = getHeight(r.getRightChild());

        node.setHeight(Math.max(leftHeight1, rightHeight1) + 1);
        r.setHeight(Math.max(leftHeight2, rightHeight2) + 1);

        return r;

    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return node.getHeight();
    }

    private int getBalanceFactor(Node node) {
        if (node == null) return 0;
        return getHeight(node.getLeftChild()) - getHeight(node.getRightChild());
    }

    // prints the AVL tree in a the form of a pre-order traversal
    public void printTree(Node node) {

        if (node != null) {

            System.out.println(node.getValue() + " ");
            printTree(node.getLeftChild());
            printTree(node.getRightChild());

        }

    }

}
