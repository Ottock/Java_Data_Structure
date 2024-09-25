// src/BinarySearchTree_Data_Structure/BinarySearchTree.java
package BinarySearchTree_Data_Structure;

/**
 * Classe que representa uma Árvore Binária de Busca (Binary Search Tree - BST).
 * A árvore permite operações de inserção, busca, remoção e diferentes tipos de travessia.
 */
public class BinarySearchTree {
    private BSTNode root; // Raiz da árvore
    private int size;     // Número de nós na árvore

    /**
     * Construtor padrão que inicializa a árvore como vazia.
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Construtor que inicializa a árvore com um nó raiz.
     *
     * @param root O nó raiz da árvore.
     */
    public BinarySearchTree(BSTNode root) {
        this.root = root;
        this.size = 1;
    }

    /**
     * Define a raiz da árvore.
     *
     * @param root O novo nó raiz.
     */
    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Define o tamanho da árvore.
     *
     * @param size O novo tamanho da árvore.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Retorna o nó raiz da árvore.
     *
     * @return O nó raiz.
     */
    public BSTNode getRoot() {
        return root;
    }

    /**
     * Retorna o número de nós presentes na árvore.
     *
     * @return O tamanho da árvore.
     */
    public int getSize() {
        return size;
    }

    /**
     * Busca um nó com um valor específico na árvore.
     *
     * @param key O valor a ser buscado.
     * @return true se o nó for encontrado, false caso contrário.
     */
    public boolean searchTree(int key) {
        BSTNode current = root;
        while (current != null) {
            if (key == current.data) {
                return true; // Nó encontrado
            } else if (key < current.data) {
                current = current.left; // Continuar à esquerda
            } else {
                current = current.right; // Continuar à direita
            }
        }
        return false; // Nó não encontrado
    }

    /**
     * Adiciona um novo nó à árvore, mantendo a propriedade de Árvore Binária de Busca.
     *
     * @param parentNode O nó pai ao qual o novo nó será adicionado.
     * @param newNode O novo nó a ser adicionado.
     */
    public void addNode(BSTNode parentNode, BSTNode newNode) {
        if (parentNode == null) {
            throw new RuntimeException(">> parentNode é null");
        }
        if (newNode.data < parentNode.data) {
            if (parentNode.left == null) {
                parentNode.left = newNode;
                newNode.parent = parentNode;
                size++;
            } else {
                addNode(parentNode.left, newNode);
            }
        } else {
            if (parentNode.right == null) {
                parentNode.right = newNode;
                newNode.parent = parentNode;
                size++;
            } else {
                addNode(parentNode.right, newNode);
            }
        }
    }

    /**
     * Remove um nó específico da árvore.
     *
     * @param key O valor do nó a ser removido.
     */
    public void removeNode(int key) {
        root = removeNodeRec(root, key);
    }

    /**
     * Função recursiva auxiliar para remover um nó da árvore.
     *
     * @param root A raiz da subárvore atual.
     * @param key O valor do nó a ser removido.
     * @return A nova raiz da subárvore após a remoção.
     */
    private BSTNode removeNodeRec(BSTNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = removeNodeRec(root.left, key);
        } else if (key > root.data) {
            root.right = removeNodeRec(root.right, key);
        } else {
            // Nó encontrado

            // Caso 1: Nó sem filhos
            if (root.left == null && root.right == null) {
                return null;
            }

            // Caso 2: Nó com apenas um filho
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Caso 3: Nó com dois filhos
            root.data = minValue(root.right);
            root.right = removeNodeRec(root.right, root.data);
        }
        return root;
    }

    /**
     * Função auxiliar para encontrar o menor valor em uma subárvore.
     *
     * @param node A raiz da subárvore.
     * @return O menor valor encontrado.
     */
    private int minValue(BSTNode node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    /**
     * Verifica se a árvore está vazia.
     *
     * @return true se a árvore estiver vazia, false caso contrário.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Imprime os valores da árvore em ordem crescente (in-order traversal).
     */
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    /**
     * Função auxiliar recursiva para imprimir a árvore em ordem crescente.
     *
     * @param node O nó atual.
     */
    private void inOrderRec(BSTNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    /**
     * Imprime os valores da árvore em pré-ordem (pre-order traversal).
     */
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    /**
     * Função auxiliar recursiva para imprimir a árvore em pré-ordem.
     *
     * @param node O nó atual.
     */
    private void preOrderRec(BSTNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    /**
     * Imprime os valores da árvore em pós-ordem (post-order traversal).
     */
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    /**
     * Função auxiliar recursiva para imprimir a árvore em pós-ordem.
     *
     * @param node O nó atual.
     */
    private void postOrderRec(BSTNode node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.data + " ");
        }
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
    private void printTree(BinarySearchTree.BSTNode node, String indent, boolean last) {
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
     * Classe interna que representa um nó da Árvore Binária de Busca (BST).
     */
    public static class BSTNode {
        private BSTNode parent; // Nó pai
        private int data;       // Valor do nó
        private BSTNode left;   // Subárvore esquerda
        private BSTNode right;  // Subárvore direita

        /**
         * Construtor padrão para o nó.
         */
        public BSTNode() {}

        /**
         * Construtor que inicializa o nó com um valor específico.
         *
         * @param data O valor do nó.
         */
        public BSTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        /**
         * Define o nó pai.
         *
         * @param parent O nó pai.
         */
        public void setParent(BSTNode parent) {
            this.parent = parent;
        }

        /**
         * Define o valor do nó.
         *
         * @param data O valor do nó.
         */
        public void setData(int data) {
            this.data = data;
        }

        /**
         * Define a subárvore esquerda.
         *
         * @param left A subárvore esquerda.
         */
        public void setLeft(BSTNode left) {
            this.left = left;
        }

        /**
         * Define a subárvore direita.
         *
         * @param right A subárvore direita.
         */
        public void setRight(BSTNode right) {
            this.right = right;
        }

        /**
         * Retorna o nó pai.
         *
         * @return O nó pai.
         */
        public BSTNode getParent() {
            return parent;
        }

        /**
         * Retorna o valor do nó.
         *
         * @return O valor do nó.
         */
        public int getData() {
            return data;
        }

        /**
         * Retorna a subárvore esquerda.
         *
         * @return A subárvore esquerda.
         */
        public BSTNode getLeft() {
            return left;
        }

        /**
         * Retorna a subárvore direita.
         *
         * @return A subárvore direita.
         */
        public BSTNode getRight() {
            return right;
        }

        /**
         * Verifica se o nó é um filho à esquerda do pai.
         *
         * @return true se o nó for um filho à esquerda, false caso contrário.
         */
        public boolean isLeft() {
            return parent != null && parent.left == this;
        }
    }
}
