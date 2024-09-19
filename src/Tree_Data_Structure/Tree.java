// src/Tree_Data_Structure/Tree.java
package Tree_Data_Structure;

public class Tree {
    // Atributos
    private TreeNode root;
    private int size;

    // Construtores
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

    // Tree Funcoes
    public boolean isEmpty() {
        return size == 0 && root == null;
    }

    public int maxValue() {
        if (root == null) {
            throw new RuntimeException("Tree é null");
        }
        return maxValue(root);
    }
    private int maxValue(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int max = node.getData();
        TreeNode child = node.getFirstChild();
        while (child != null) {
            max = Math.max(max, maxValue(child));
            child = child.getNext();
        }
        return max;
    }

    public int minValue() {
        if (root == null) {
            throw new RuntimeException("Tree é null");
        }
        return minValue(root);
    }
    private int minValue(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int min = node.getData();
        TreeNode child = node.getFirstChild();
        while (child != null) {
            min = Math.min(min, minValue(child));
            child = child.getNext();
        }
        return min;
    }

    public void addNode(TreeNode parentNode, TreeNode childNode) {
        if (parentNode == null) {
            throw new NullPointerException("Pai de Node é null");
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
            throw new NullPointerException("Node é null");
        }
        if (node == root) {
            this.root = null;
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
        }
        this.size--;
    }

    public int height() {
        if (root == null) {
            return -1;
        }
        return root.height();
    }

    // Pre Order traversal
    public void preOrder() {
        if (root == null) {
            throw new NullPointerException("Tree é null");
        }
        System.out.print(">> Pre Order:\n[ ");
        root.preOrder();
        System.out.println("]");
    }

    // Post Order traversal
    public void postOrder() {
        if (root == null) {
            throw new NullPointerException("Tree é null");
        }
        System.out.print(">> Post Order:\n[ ");
        root.postOrder();
        System.out.println("]");
    }

    // Imprimir árvore no formato desejado
    public void printTree() {
        if (root == null) {
            System.out.println("A árvore está vazia.");
        } else {
            printTree(root, "", true);
        }
    }

    private void printTree(TreeNode node, String indent, boolean isLast) {
        if (node != null) {
            System.out.print(indent);
            if (isLast) {
                System.out.print("└── ");
                indent += "    ";
            } else {
                System.out.print("├── ");
                indent += "│   ";
            }
            System.out.println(node.getData());

            TreeNode child = node.getFirstChild();
            while (child != null) {
                printTree(child, indent, child.getNext() == null);
                child = child.getNext();
            }
        }
    }

    // Classe Interna TreeNode
    public static class TreeNode {
        // Atributos
        private TreeNode parent;
        private int data;
        private TreeNode firstChild;
        private TreeNode next;

        // Construtores
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

        // NodeTree Funcoes
        public void printParent() {
            if (parent != null) {
                System.out.println(">> Pai: " + parent.getData());
            } else {
                System.out.println(">> Node não tem pai");
            }
        }

        public void printChildren() {
            TreeNode current = firstChild;
            System.out.print(">> Filhos de " + getData() + ": [");
            while (current != null) {
                System.out.print(current.getData());
                if (current.getNext() != null) {
                    System.out.print(", ");
                }
                current = current.getNext();
            }
            System.out.println("]");
        }

        public void doubleParent() {
            if (parent == null) {
                throw new NullPointerException("Node não tem Pai");
            }
            this.parent.data *= 2;
        }

        public void doubleSons() {
            if (firstChild == null) {
                throw new RuntimeException("Node não tem Filhos");
            }
            TreeNode current = firstChild;
            while (current != null) {
                current.data *= 2;
                current = current.getNext();
            }
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
        public void preOrder() {
            System.out.print(this.getData() + " ");
            TreeNode current = this.getFirstChild();
            while (current != null) {
                current.preOrder();
                current = current.getNext();
            }
        }

        // Post Order
        public void postOrder() {
            TreeNode current = this.getFirstChild();
            while (current != null) {
                current.postOrder();
                current = current.getNext();
            }
            System.out.print(this.getData() + " ");
        }
    }
}
