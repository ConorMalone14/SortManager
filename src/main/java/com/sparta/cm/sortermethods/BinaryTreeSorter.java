package com.sparta.cm.sortermethods;

import com.sparta.cm.exceptions.ChildNotFoundException;
import com.sparta.cm.sortermethods.Sort;
import com.sparta.cm.sortermethods.Sorter;
import com.sparta.cm.sortermethods.binarysearchtree.BinaryTree;
import com.sparta.cm.sortermethods.binarysearchtree.Node;

public class BinaryTreeSorter extends Sort implements BinaryTree {
    private Node root;
    int size = 0;
    static int numberOfSortedElements;
    static int[] outputArray;

    public BinaryTreeSorter(int[] array) {
        super();
        buildTree(array);
    }

    @Override
    public int[] sortArray(int[] array) {
        int[] output = getSortedTreeAsc();
        return output;
    }
    public void buildTree(int[] array){
        addElements(array);
    }

    @Override
    public String getName() {
        return "BinaryTreeSort";
    }

    @Override
    public int getRootElement() {
        return this.root.getKey();
    }

    @Override
    public int getNumberOfElements() {
        return this.size;
    }

    @Override
    public void addElement(int element) {
        if(root==null){
            root = new Node(element);
        }else {
            Node current = root;
            boolean endNotFound = true;
            while (endNotFound) {
                if (current.getKey() >= element && current.isThereALeftChild()) {
                    current = current.getLeftNode();
                } else if (current.getKey() < element && current.isThereARightChild()) {
                    current = current.getRightNode();
                } else if (current.getKey() >= element) {
                    current.setLeftNode(new Node(element));
                    endNotFound = false;
                } else if (current.getKey() < element) {
                    current.setRightNode(new Node(element));
                    endNotFound = false;
                }
            }
        }
    }

    @Override
    public void addElements(int[] elements) {
        size = size + elements.length;
        for(int i = 0; i< elements.length;i++){
            addElement(elements[i]);
        }
    }

    @Override
    public boolean findElement(int value) {
        Node current = root;
        boolean endNotFound = true;
        while(endNotFound) {
            if (current.getKey() > value && current.isThereALeftChild()) {
                current = current.getLeftNode();
            } else if (current.getKey() < value && current.isThereARightChild()) {
                current = current.getRightNode();
            } else if (current.getKey() == value) {
                return true;
            } else {
                endNotFound=false;
            }
        }
        return false;
    }
    private Node findNode(int element){
        Node node = root;
        while (node !=null){
            if(element==node.getKey()){
                return node;
            }else if(element < node.getKey()){
                node = node.getLeftNode();
            } else{
                node = node.getRightNode();
            }
        }
        return null;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if(node != null){
            return node.getLeftNode().getKey();
        }
        throw new ChildNotFoundException();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if(node != null){
            return node.getRightNode().getKey();
        }
        throw new ChildNotFoundException();

    }
    private void traverse(Node node) {
        if(node.isThereALeftChild()){
            traverse(node.getLeftNode());
        }
        outputArray[numberOfSortedElements] = node.getKey();
        numberOfSortedElements++;
        if(node.isThereARightChild()){
            traverse(node.getRightNode());
        }
    }
    private void traverseDescending(Node node) {
        if(node.isThereARightChild()){
            traverse(node.getRightNode());
        }

        outputArray[numberOfSortedElements] = node.getKey();
        numberOfSortedElements++;

        if(node.isThereALeftChild()){
            traverse(node.getLeftNode());
        }


    }
    @Override
    public int[] getSortedTreeAsc() {
        outputArray = new int[this.getNumberOfElements()];
        traverse(root);
        return outputArray;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] output = new int[this.getNumberOfElements()];
        traverseDescending(root);
        return output;
    }
}
