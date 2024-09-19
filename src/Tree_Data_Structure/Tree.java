// src/TreeDataStructure/Tree.java
package Tree_Data_Structure;

public class Tree {
    // Attributes
    private TreeNode root;
    private int size;

    // Constructors
    public Tree() {
        this.root = null;
        this.size = 0;
    }
    public Tree(TreeNode root) {
        this.root = root;
        this.size = 1;
    }

    // Setters
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    public void setSize(int size) {
        this.size = size;
    }

    // Getters
    public TreeNode getRoot() {
        return root;
    }
    public int getSize() {
        return size;
    }

    // Tree Functions
    public boolean isEmpty() {
        return size == 0 && root == null;
    }

    public int maxValue() {
        if (root == null) {
            throw new RuntimeException("Tree eh null");
        }
        return maxValue(root);
    }
    private int maxValue(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int max = node.data;
        TreeNode child = node.firstChild;
        while (child != null) {
            max = Math.max(max, maxValue(child));
            child = child.next;
        }
        return max;
    }

    public int minValue() {
        if (root == null) {
            throw new RuntimeException("Tree eh null");
        }
        return minValue(root);
    }
    private int minValue(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int min = node.data;
        TreeNode child = node.firstChild;
        while (child != null) {
            min = Math.min(min, minValue(child));
            child = child.next;
        }
        return min;
    }

    public void addNode(TreeNode parentNode, TreeNode childNode) {
        if (parentNode == null) {
            throw new NullPointerException(">> Parent node is null");
        }
        childNode.setParent(parentNode);

        if (parentNode.getFirstChild() == null) {
            parentNode.setFirstChild(childNode);
        } else {
            TreeNode current = parentNode.getFirstChild();
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(childNode);
        }
        this.size++;
    }
    public void removeNode(TreeNode node) {
        if (node == null) {
            throw new NullPointerException(">> Node is null");
        }

        if (node == root) {
            this.root = null;
            this.size--;
        } else {
            TreeNode parent = node.getParent();
            if (parent != null) {
                if (parent.getFirstChild() == node) {
                    parent.setFirstChild(node.getNext());
                } else {
                    TreeNode current = parent.getFirstChild();
                    while (current != null && current.getNext() != node) {
                        current = current.getNext();
                    }
                    if (current != null) {
                        current.setNext(node.getNext());
                    }
                }
            }
            this.size--;
        }
    }

    // In Order traversal

    // Pre Order traversal
    public void preOrder() {
        if (root == null) {
            throw new NullPointerException(">> Tree eh null");
        }
        System.out.print(">> Pre Order:\n[ ");
        this.root.preOrder(this.root);
        System.out.println("]");
    }

    // Pos Order traversal
    public void postOrder() {
       if (root == null) {
            throw new NullPointerException(">> Tree eh null");
        }
        System.out.print(">> Pos Order:\n[ ");
        this.root.postOrder(this.root);
        System.out.println("]");
    }

    // Internal Class TreeNode
    public static class TreeNode {
        // Attributes
        private TreeNode parent;
        private int data;
        private TreeNode firstChild;
        private TreeNode next;

        // Constructors
        public TreeNode() {
            this.parent = null;
            this.data = 0;
            this.firstChild = null;
            this.next = null;
        }
        public TreeNode(int data) {
            this.parent = null;
            this.data = data;
            this.firstChild = null;
            this.next = null;
        }

        // Setters
        public void setParent(TreeNode parent) {
            this.parent = parent;
        }
        public void setData(int data) {
            this.data = data;
        }
        public void setFirstChild(TreeNode firstChild) {
            this.firstChild = firstChild;
        }
        public void setNext(TreeNode next) {
            this.next = next;
        }

        // Getters
        public TreeNode getParent() {
            return parent;
        }
        public int getData() {
            return data;
        }
        public TreeNode getFirstChild() {
            return firstChild;
        }
        public TreeNode getNext() {
            return next;
        }

        // NodeTree Functions
        public boolean hasParent() {
            return parent != null;
        }
        public void printParent() {
            if (parent != null) {
                System.out.println(">> Parent: " + parent.getData());
            } else {
                System.out.println(">> Node nao tem pai");
            }
        }

        public boolean hasChildren() {
            return firstChild != null;
        }
        public void printChildren() {
            TreeNode current = firstChild;
            System.out.print(">> Children of " + getData() + ": [");
            while (current != null) {
                System.out.print(current.getData());
                if (current.getNext() != null) {
                    System.out.print(", ");
                }
                current = current.getNext();
            }
            System.out.println("]");
        }

        public boolean isInternal() {
            return firstChild != null;
        }
        public boolean isExternal() {
            return firstChild == null;
        }

        public int depth() {
            int depth = 0;
            TreeNode current = this;
            while (current.getParent() != null) {
                depth++;
                current = current.getParent();
            }
            return depth;
        }
        public int height() {
            if (firstChild == null) {
                return 0;
            }
            int height = 0;
            TreeNode current = firstChild;
            while (current != null) {
                height = Math.max(height, current.height());
                current = current.getNext();
            }
            return height + 1;
        }

        // Pre Order
        public void preOrder(TreeNode node) {
            System.out.print(node.getData()+" ");
            TreeNode current = this.firstChild;
            while (current != null) {
                current.preOrder(current);
                current = current.getNext();
            }
        }

        // Pos Order
        public void postOrder(TreeNode node) {
            TreeNode current = node.getFirstChild();
            while (current != null) {
                postOrder(current);
                current = current.getNext();
            }
            System.out.print(node.getData() + " ");
        }

    }
}
