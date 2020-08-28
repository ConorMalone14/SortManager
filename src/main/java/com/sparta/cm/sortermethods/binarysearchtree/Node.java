package com.sparta.cm.sortermethods.binarysearchtree;

public class Node {
    private final int key;
    private Node leftNode;
    private Node rightNode;
    public Node(int key){
        this.key=key;
        this.leftNode=null;
        this.rightNode=null;
    }

    public int getKey() {
        return key;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
    public boolean isThereALeftChild(){
        if(leftNode==null){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean isThereARightChild(){
        if(rightNode==null){
            return false;
        }
        else {
            return true;
        }
    }
}
