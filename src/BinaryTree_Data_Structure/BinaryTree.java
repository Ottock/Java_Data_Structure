package BinaryTree_Data_Structure;

public class BinaryTree {
    private BinaryNode root;
    private int size;

    // Construtores
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

    // Funções de Árvore Binária
    public boolean isEmpty() {
        return size == 0;
    }

    public int maxValue() {
        if (root == null) {
            throw new RuntimeException("Tree is null");
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
            throw new RuntimeException("Tree is null");
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
            throw new RuntimeException("parentNode is null");
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

    public void removeNode(BinaryNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (node == root) {
                root = null;
            } else if (node.isLeft()) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        } else if (node.left != null && node.right != null) {
            BinaryNode minNode = findMin(node.right);
            int temp = node.data;
            node.data = minNode.data;
            minNode.data = temp;
            removeNode(minNode);
        } else {
            BinaryNode child = (node.left != null) ? node.left : node.right;
            if (node == root) {
                root = child;
            } else if (node.isLeft()) {
                node.parent.left = child;
            } else {
                node.parent.right = child;
            }
            if (child != null) {
                child.setParent(node.parent);
            }
        }
        this.size--;
    }

    private BinaryNode findMin(BinaryNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Funções de Travessia
    public void inOrder() {
        if (root == null) {
            throw new RuntimeException("Tree is null");
        }
        System.out.print("[ ");
        this.root.inOrder();
        System.out.print("]");
    }

    public void preOrder() {
        if (root == null) {
            throw new RuntimeException("Tree is null");
        }
        System.out.print("[ ");
        this.root.preOrder();
        System.out.print("]");
    }

    public void postOrder() {
        if (root == null) {
            throw new RuntimeException("Tree is null");
        }
        System.out.print("[ ");
        this.root.postOrder();
        System.out.print("]");
    }

    // Função para imprimir a árvore
    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            printTree(root, "", true);
        }
    }

    private void printTree(BinaryNode node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("└── ");
                indent += "    ";
            } else {
                System.out.print("├── ");
                indent += "│   ";
            }

            // Imprime o valor do nó e as indicações dos filhos
            System.out.print(node.getData());
            if (node.getParent() != null) {
                System.out.print(node.isLeft() ? "[l]" : "[r]");
            }
            System.out.println();

            // Recursivamente imprime os filhos
            if (node.getLeft() != null) {
                printTree(node.getLeft(), indent, false);
            }
            if (node.getRight() != null) {
                printTree(node.getRight(), indent, true);
            }
        }
    }

    // Classe Interna BinaryNode
    public static class BinaryNode {
        private BinaryNode parent;
        private int data;
        private BinaryNode left;
        private BinaryNode right;

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

        public void setParent(BinaryNode parent) {
            this.parent = parent;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(BinaryNode left) {
            if (left != null && left.data > this.data) {
                System.out.println(">> Left is greater than " + this.data);
            }
            this.left = left;
        }

        public void setRight(BinaryNode right) {
            if (right != null && right.data < this.data) {
                System.out.println(">> Right is smaller than " + this.data);
            }
            this.right = right;
        }

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

        public boolean isLeft() {
            return this.parent != null && this.parent.getLeft() == this;
        }

        public boolean isRight() {
            return this.parent != null && this.parent.getRight() == this;
        }

        public void inOrder() {
            if (this.left != null) {
                this.left.inOrder();
            }
            System.out.print(this.data + " ");
            if (this.right != null) {
                this.right.inOrder();
            }
        }

        public void preOrder() {
            System.out.print(this.data + " ");
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        public void postOrder() {
            if (this.left != null) {
                this.left.postOrder();
            }
            if (this.right != null) {
                this.right.postOrder();
            }
            System.out.print(this.data + " ");
        }

        public int depth() {
            if (this.parent == null) {
                return 0;
            }
            return this.parent.depth() + 1;
        }

        public int height() {
            if (this.left == null && this.right == null) {
                return 0;
            }
            int leftHeight = (this.left != null) ? this.left.height() : 0;
            int rightHeight = (this.right != null) ? this.right.height() : 0;
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
