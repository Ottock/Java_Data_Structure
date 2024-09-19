// src/BinaryTree_Data_Structure/BinaryTree.java
package BinaryTree_Data_Structure;

import Tree_Data_Structure.Tree;

public class BinaryTree {
    // Attributes
    private BinaryNode root;
    private int size;

    // Constructors
    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }
    public BinaryTree(BinaryNode root) {
        this.root = root;
        this.size = 1;
    }

    // Setters
    public void setRoot(BinaryNode root) {
        this.root = root;
    }
    public void setSize(int size) {
        this.size = size;
    }

    // Getters
    public BinaryNode getRoot() {
        return root;
    }
    public int getSize() {
        return size;
    }

    // BinaryTree Functions
    public boolean isEmpty() {
        return size == 0;
    }

    public int maxValue() {
        if (root == null) {
            throw new RuntimeException(">> Tree eh null");
        }
        return maxValue(root);
    }
    private int maxValue(BinaryNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public int minValue() {
        if (root == null) {
            throw new RuntimeException(">> Tree eh null");
        }
        return minValue(root);
    }
    private int minValue(BinaryNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public void addNode(BinaryNode parentNode, BinaryNode newNode) {
        if (parentNode == null) {
            throw new RuntimeException(">> parentNode eh null");
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
    public void removeNode(BinaryNode node) {}

    // In Order
    public void inOrder() {
        if (root == null) {
            throw new RuntimeException(">> Tree eh null");
        }
        System.out.println(">> In Order\n[ ");
        this.root.inOrder();
        System.out.println("]");
    }

    // Pre Order
    public void preOrder() {
        if (root == null) {
            throw new RuntimeException(">> Tree eh null");
        }
        System.out.println(">> Pre Order\n[ ");
        this.root.preOrder();
        System.out.println("]");
    }

    // Post Order
    public void postOrder() {
        if (root == null) {
            throw new RuntimeException(">> Tree eh null");
        }
        System.out.println(">> Post Order\n[ ");
        this.root.postOrder();
        System.out.println("]");
    }

    // Internal Class BinaryNode
    public static class BinaryNode {
        // Attributes
        public BinaryNode parent;
        public int data;
        public BinaryNode left;
        public BinaryNode right;

        // Constructors
        public BinaryNode() {
            this.parent = null;
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        public BinaryNode(int data) {
            this.parent = null;
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Setters
        public void setParent(BinaryNode parent) {
            this.parent = parent;
        }
        public void setData(int data) {
            this.data = data;
        }
        public void setLeft(BinaryNode left) {
            if (left != null && left.data > this.data) {
                System.out.println(">> Left eh maior que " + this.data);
            }
            this.left = left;
        }
        public void setRight(BinaryNode right) {
            if (right != null && right.data < this.data) {
                System.out.println(">> Right eh menor que " + this.data);
            }
            this.right = right;
        }

        // Getters
        public BinaryNode getParent() {
            return this.parent;
        }
        public int getData() {
            return this.data;
        }
        public BinaryNode getLeft() {
            return this.left;
        }
        public BinaryNode getRight() {
            return this.right;
        }

        // BinaryNode Functions
        public boolean isLeft() {
            return this.parent.left == this;
        }
        public boolean isRight() {
            return this.parent.right == this;
        }

        public boolean hasParent() {
            return this.parent != null;
        }
        public void printParent() {
            if (parent != null) {
                System.out.println(">> Parent: " + parent.getData());
            } else {
                System.out.println(">> Node nao tem pai");
            }
        }

        public boolean hasChildern() {
            return left != null && right != null;
        }
        public void printChildern() {
            System.out.println(">> Left Childern: " + left.getData());
            System.out.println(">> Right Childern: " + right.getData());
        }

        public boolean isInternal() {
            return this.left == null && this.right == null;
        }
        public boolean isExternal() {
            return this.left != null && this.right != null;
        }

        public int depth() {
            int depth = 0;
            BinaryNode current = this;
            while (current.getParent() != null) {
                depth++;
                current = current.getParent();
            }
            return depth;
        }
        public int height() {
            if (this == null) {
                return -1;
            }
            int leftHeight = (this.left != null) ? this.left.data : -1;
            int rightHeight = (this.right != null) ? this.right.data : -1;
            return Math.max(leftHeight, rightHeight) + 1;
        }

        // In Order
        public void inOrder() {
            if (this.isLeft()) {
                this.left.inOrder();
            }
            System.out.print(this.data + " ");
            if (this.isRight()) {
                this.right.inOrder();
            }
        }

        // Pre Order
        public void preOrder() {
            System.out.println(this.data + " ");
            if (this.isLeft()) {
                this.left.preOrder();
            }
            if (this.isRight()) {
                this.right.preOrder();
            }
        }

        // Post Order
        public void postOrder() {
            if (this.isLeft()) {
                this.left.preOrder();
            }
            if (this.isRight()) {
                this.right.preOrder();
            }
            System.out.print(this.data + " ");
        }

    }
}
