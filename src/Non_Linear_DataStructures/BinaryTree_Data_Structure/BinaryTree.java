// src/Linear_Data_Structures.Linear_Data_Structures.BinaryTree_Data_Structure.BinaryTree_Data_Structure/BinaryTree.java
package Non_Linear_DataStructures.BinaryTree_Data_Structure;

// Imports
import java.util.NoSuchElementException;

/**
 * Uma classe BinaryTree que representa uma estrutura de dados de árvore binária.
 * Esta classe fornece métodos para adicionar, remover e percorrer nós na árvore.
 */
public class BinaryTree {
    private BinaryNode root;
    private int size;

    /**
     * Constrói uma BinaryTree vazia.
     */
    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Constrói uma BinaryTree com um nó raiz especificado.
     *
     * @param root o nó raiz da árvore
     */
    public BinaryTree(BinaryNode root) {
        this.root = root;
        this.size = 1;
    }

    // Setters

    /**
     * Define o nó raiz da árvore.
     *
     * @param root o nó raiz a ser definido
     */
    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    /**
     * Define o tamanho da árvore.
     *
     * @param size o tamanho a ser definido
     */
    public void setSize(int size) {
        this.size = size;
    }

    // Getters

    /**
     * Retorna o nó raiz da árvore.
     *
     * @return o nó raiz
     */
    public BinaryNode getRoot() {
        return root;
    }

    /**
     * Retorna o tamanho da árvore.
     *
     * @return o tamanho da árvore
     */
    public int getSize() {
        return size;
    }

    /**
     * Verifica se a árvore está vazia.
     *
     * @return true se a árvore estiver vazia, false caso contrário
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retorna o valor máximo na árvore.
     *
     * @return o valor máximo
     * @throws NoSuchElementException se a árvore estiver vazia
     */
    public int maxValue() {
        if (root == null) {
            throw new NoSuchElementException("A árvore está vazia");
        }
        return maxValue(root);
    }

    private int maxValue(BinaryNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.getData();
    }

    /**
     * Retorna o valor mínimo na árvore.
     *
     * @return o valor mínimo
     * @throws NoSuchElementException se a árvore estiver vazia
     */
    public int minValue() {
        if (root == null) {
            throw new NoSuchElementException("A árvore está vazia");
        }
        return minValue(root);
    }

    private int minValue(BinaryNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.getData();
    }

    /**
     * Adiciona um novo nó à árvore.
     *
     * @param newNode o novo nó a ser adicionado
     * @throws IllegalArgumentException se o newNode for nulo
     */
    public void addNode(BinaryNode newNode) {
        if (newNode == null) {
            throw new IllegalArgumentException("newNode é nulo");
        }
        if (root == null) {
            root = newNode;
            size = 1;
        } else {
            addNode(root, newNode);
        }
    }

    void addNode(BinaryNode parentNode, BinaryNode newNode) {
        if (newNode.data < parentNode.data) {
            if (parentNode.left == null) {
                parentNode.setLeft(newNode);
                newNode.setParent(parentNode);
                size++;
            } else {
                addNode(parentNode.left, newNode);
            }
        } else {
            if (parentNode.right == null) {
                parentNode.setRight(newNode);
                newNode.setParent(parentNode);
                size++;
            } else {
                addNode(parentNode.right, newNode);
            }
        }
    }

    /**
     * Remove um nó especificado da árvore.
     *
     * @param node o nó a ser removido
     */
    public void removeNode(BinaryNode node) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            if (node == root) {
                root = null;
            } else if (node.isLeft()) {
                node.getParent().setLeft(null);
            } else {
                node.getParent().setRight(null);
            }
        } else if (node.left != null && node.right != null) {
            BinaryNode minNode = findMin(node.right);
            node.data = minNode.data;
            removeNode(minNode);
        } else {
            BinaryNode child = (node.left != null) ? node.left : node.right;
            if (node == root) {
                root = child;
            } else if (node.isLeft()) {
                node.getParent().setLeft(child);
            } else {
                node.getParent().setRight(child);
            }
            child.setParent(node.getParent());
        }
        size--;
    }

    private BinaryNode findMin(BinaryNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Funções de Travessia

    /**
     * Imprime a travessia em ordem da árvore.
     *
     * @throws NoSuchElementException se a árvore estiver vazia
     */
    public void inOrder() {
        if (root == null) {
            throw new NoSuchElementException("A árvore está vazia");
        }
        System.out.print("[ ");
        inOrder(root);
        System.out.print("]");
    }

    private void inOrder(BinaryNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    /**
     * Imprime a travessia pré-ordem da árvore.
     *
     * @throws NoSuchElementException se a árvore estiver vazia
     */
    public void preOrder() {
        if (root == null) {
            throw new NoSuchElementException("A árvore está vazia");
        }
        System.out.print("[ ");
        preOrder(root);
        System.out.print("]");
    }

    private void preOrder(BinaryNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Imprime a travessia pós-ordem da árvore.
     *
     * @throws NoSuchElementException se a árvore estiver vazia
     */
    public void postOrder() {
        if (root == null) {
            throw new NoSuchElementException("A árvore está vazia");
        }
        System.out.print("[ ");
        postOrder(root);
        System.out.print("]");
    }

    private void postOrder(BinaryNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * Imprime a estrutura da árvore.
     */
    public void printTree() {
        if (root == null) {
            System.out.println("A árvore está vazia");
        } else {
            printTree(root, "", true);
        }
    }

    /**
     * Método auxiliar que imprime a árvore a partir de um nó específico.
     *
     * @param node   O nó atual a ser impresso.
     * @param indent A indentação atual para o formato de impressão.
     * @param last Indica se o nó é o último filho do nó pai.
     */
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

            System.out.println(node.data + (node.getParent() != null ? (node.isLeft() ? " [L]" : " [R]") : ""));

            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }

    /**
     * Uma classe BinaryNode que representa um nó na árvore binária.
     */
    public static class BinaryNode {
        private BinaryNode parent;
        private int data;
        private BinaryNode left;
        private BinaryNode right;

        /**
         * Constrói um BinaryNode com dados especificados.
         *
         * @param data os dados a serem armazenados neste nó
         */
        public BinaryNode(int data) {
            this.data = data;
        }

        public void setParent(BinaryNode parent) {
            this.parent = parent;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(BinaryNode left) {
            this.left = left;
        }

        public void setRight(BinaryNode right) {
            this.right = right;
        }

        public BinaryNode getParent() {
            return parent;
        }

        public int getData() {
            return data;
        }

        public BinaryNode getLeft() {
            return left;
        }

        public BinaryNode getRight() {
            return right;
        }

        /**
         * Verifica se este nó é um filho à esquerda.
         *
         * @return true se este nó for um filho à esquerda, false caso contrário
         */
        public boolean isLeft() {
            return parent != null && parent.left == this;
        }

        /**
         * Verifica se este nó é um filho à direita.
         *
         * @return true se este nó for um filho à direita, false caso contrário
         */
        public boolean isRight() {
            return parent != null && parent.right == this;
        }

        /**
         * Retorna a profundidade deste nó na árvore.
         *
         * @return a profundidade deste nó
         */
        public int depth() {
            int depth = 0;
            BinaryNode current = this;
            while (current.parent != null) {
                depth++;
                current = current.parent;
            }
            return depth;
        }
    }
}
