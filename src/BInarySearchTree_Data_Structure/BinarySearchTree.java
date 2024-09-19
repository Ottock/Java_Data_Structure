// src/BinarySearchTree_Data_Structure/BinarySearchTree.java
package BInarySearchTree_Data_Structure;

public class BinarySearchTree {
    // Attributes
    private BSTNode root;
    private int size;

    // Constructors
    public BinarySearchTree() {}
    public BinarySearchTree(BSTNode root) {
        this.root = root;
        this.size = 1;
    }

    // Setters
    public void setRoot(BSTNode root) {
        this.root = root;
    }
    public void setSize(int size) {
        this.size = size;
    }

    // Getters
    public BSTNode getRoot() {
        return root;
    }
    public int getSize() {
        return size;
    }

    // BinarySearchTree Functions
    public boolean searchTree(int key) {
        BSTNode current = this.root;
        while (current != null && current.data != key) {
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null){
            return false;
        }
        return key == current.data;
    }
    
    public void addNode(BSTNode parentNode, BSTNode newNode) {
        if (parentNode == null) {
            throw new RuntimeException(">> parentNode é null");
        }
        if (newNode.data < parentNode.data) {
            if (parentNode.getLeft() == null) {
                parentNode.setLeft(newNode);
                newNode.setParent(parentNode);
                this.size++;
            } else {
                addNode(parentNode.getLeft(), newNode);
            }
        } else {
            if (parentNode.getRight() == null) {
                parentNode.setRight(newNode);
                newNode.setParent(parentNode);
                this.size++;
            } else {
                addNode(parentNode.getRight(), newNode);
            }
        }
    }

    public void removeNode(BSTNode node) {}

    // Internal Class BSTNode
    public static class BSTNode {
        // Attributes
        private BSTNode parent;
        private int data;
        private BSTNode left;
        private BSTNode right;

        // Constructors
        public BSTNode() {}
        public BSTNode(int data) {
            this.data = data;
        }

        // Setters
        public void setParent(BSTNode parent) {
            this.parent = parent;
        }
        public void setData(int data) {
            this.data = data;
        }
        public void setLeft(BSTNode left) {
            this.left = left;
        }
        public void setRight(BSTNode right) {
            this.right = right;
        }

        // Getters
        public BSTNode getParent() {
            return parent;
        }
        public int getData() {
            return data;
        }
        public BSTNode getLeft() {
            return left;
        }
        public BSTNode getRight() {
            return right;
        }

        // BSTNode Functions

    }
}
