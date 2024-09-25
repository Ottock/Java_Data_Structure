// src/Tree_Data_Structure/Tree.java
package Tree_Data_Structure;

public class Tree {
    // Atributos
    private TreeNode root;
    private int size;

    // Construtores
    /**
     * Construtor padrão que inicializa uma árvore vazia.
     */
    public Tree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Construtor que inicializa a árvore com um nó raiz específico.
     *
     * @param root O nó raiz da árvore.
     */
    public Tree(TreeNode root) {
        this.root = root;
        this.size = 1;
    }

    // Setters
    /**
     * Define o nó raiz da árvore.
     *
     * @param root O nó raiz a ser definido.
     */
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * Define o tamanho da árvore.
     *
     * @param size O tamanho a ser definido.
     */
    public void setSize(int size) {
        this.size = size;
    }

    // Getters
    /**
     * Obtém o nó raiz da árvore.
     *
     * @return O nó raiz da árvore.
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * Obtém o tamanho da árvore.
     *
     * @return O tamanho da árvore.
     */
    public int getSize() {
        return size;
    }

    // Funções da árvore
    /**
     * Verifica se a árvore está vazia.
     *
     * @return true se a árvore estiver vazia, caso contrário false.
     */
    public boolean isEmpty() {
        /*
        isEmpty(): Função que verifica se a árvore está vazia ou não.

        :return: Boolean, onde true para "vazia" e false para "com conteúdo".
        */
        return size == 0 && root == null;
    }

    /**
     * Busca o maior valor armazenado em um nó da árvore.
     *
     * @return O maior valor encontrado na árvore.
     * @throws RuntimeException Se a árvore estiver vazia.
     */
    public int maxValue() {
        /*
        maxValue(): Função que busca pelo maior valor armazenado em um Node na árvore.

        :return: Função maxValue(root), que vai começar a busca pelo Node raiz.
        */
        if (root == null) {
            throw new RuntimeException("Tree é null");
        }
        return maxValue(root);
    }

    /**
     * Busca o maior valor a partir de um nó específico.
     *
     * @param node O nó a partir do qual a busca será iniciada.
     * @return O maior valor encontrado a partir do nó especificado.
     */
    private int maxValue(TreeNode node) {
        /*
        maxValue(TreeNode node): Função que busca pelo maior valor armazenado em um Node na árvore.

        :param TreeNode node: Node raiz da árvore onde começará a busca.
        :return: Integer representando o maior valor contido na árvore.
        */
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

    /**
     * Busca o menor valor armazenado em um nó da árvore.
     *
     * @return O menor valor encontrado na árvore.
     * @throws RuntimeException Se a árvore estiver vazia.
     */
    public int minValue() {
        /*
        minValue(): Função que busca pelo menor valor armazenado em um Node na árvore.

        :return: Função minValue(root), que vai começar a busca pelo Node raiz.
        */
        if (root == null) {
            throw new RuntimeException("Tree é null");
        }
        return minValue(root);
    }

    /**
     * Busca o menor valor a partir de um nó específico.
     *
     * @param node O nó a partir do qual a busca será iniciada.
     * @return O menor valor encontrado a partir do nó especificado.
     */
    private int minValue(TreeNode node) {
        /*
        minValue(TreeNode node): Função que busca pelo menor valor armazenado em um Node na árvore.

        :param TreeNode node: Node raiz da árvore onde começará a busca.
        :return: Integer representando o menor valor contido na árvore.
        */
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

    /**
     * Adiciona um novo nó como filho de um nó pai especificado.
     *
     * @param parentNode O nó pai que receberá um novo filho.
     * @param childNode  O nó filho que será adicionado à árvore.
     * @throws NullPointerException Se o nó pai for null.
     */
    public void addNode(TreeNode parentNode, TreeNode childNode) {
        /*
        addNode(): Função que realiza a adição de um novo Node em relação a um Node Pai.

        :param: TreeNode parentNode: Node que receberá um novo filho.
        :param: TreeNode childNode: Node que será adicionado à árvore.
        */
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

    /**
     * Remove um nó da árvore.
     *
     * @param node O nó que será removido.
     * @throws NullPointerException Se o nó for null.
     */
    public void removeNode(TreeNode node) {
        /*
        removeNode(): Função que realiza a remoção de um Node.

        :param: TreeNode node: Node que será removido.
        */
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

    /**
     * Retorna a altura da árvore.
     *
     * @return A altura da árvore, onde 0 representa uma árvore com um nó e -1 uma árvore vazia.
     */
    public int height() {
        /*
        height(): Função que retorna a altura que a Tree tem.

        :return: Integer representando a altura da Tree.
        */
        if (root == null) {
            return -1;
        }
        return root.height();
    }

    // Pre Order traversal
    /**
     * Realiza a travessia em pré-ordem da árvore e imprime os valores.
     *
     * @throws NullPointerException Se a árvore estiver vazia.
     */
    public void preOrder() {
        if (root == null) {
            throw new NullPointerException("Tree é null");
        }
        System.out.print(">> Pre Order:\n[ ");
        root.preOrder();
        System.out.println("]");
    }

    // Post Order traversal
    /**
     * Realiza a travessia em pós-ordem da árvore e imprime os valores.
     *
     * @throws NullPointerException Se a árvore estiver vazia.
     */
    public void postOrder() {
        if (root == null) {
            throw new NullPointerException("Tree é null");
        }
        System.out.print(">> Post Order:\n[ ");
        root.postOrder();
        System.out.println("]");
    }

    /**
     * Imprime a árvore no formato desejado.
     */
    public void printTree() {
        if (root == null) {
            System.out.println("A árvore está vazia.");
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
    private void printTree(TreeNode node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
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

    /**
     * Classe interna que representa um nó da árvore.
     */
    public static class TreeNode {
        private int data;
        private TreeNode parent;
        private TreeNode firstChild;
        private TreeNode next;

        /**
         * Construtor que inicializa um nó com um valor específico.
         *
         * @param data O valor a ser armazenado no nó.
         */
        public TreeNode(int data) {
            this.data = data;
            this.parent = null;
            this.firstChild = null;
            this.next = null;
        }

        // Getters e Setters
        /**
         * Obtém o valor armazenado no nó.
         *
         * @return O valor do nó.
         */
        public int getData() {
            return data;
        }

        /**
         * Define o valor armazenado no nó.
         *
         * @param data O valor a ser definido.
         */
        public void setData(int data) {
            this.data = data;
        }

        /**
         * Obtém o nó pai do nó atual.
         *
         * @return O nó pai.
         */
        public TreeNode getParent() {
            return parent;
        }

        /**
         * Define o nó pai do nó atual.
         *
         * @param parent O nó pai a ser definido.
         */
        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        /**
         * Obtém o primeiro filho do nó atual.
         *
         * @return O primeiro filho do nó.
         */
        public TreeNode getFirstChild() {
            return firstChild;
        }

        /**
         * Define o primeiro filho do nó atual.
         *
         * @param firstChild O primeiro filho a ser definido.
         */
        public void setFirstChild(TreeNode firstChild) {
            this.firstChild = firstChild;
        }

        /**
         * Obtém o próximo nó.
         *
         * @return O próximo nó.
         */
        public TreeNode getNext() {
            return next;
        }

        /**
         * Define o próximo nó.
         *
         * @param next O próximo nó a ser definido.
         */
        public void setNext(TreeNode next) {
            this.next = next;
        }

        // Funções de travessia
        /**
         * Realiza a travessia em pré-ordem a partir do nó atual.
         */
        public void preOrder() {
            System.out.print(data + " ");
            TreeNode child = firstChild;
            while (child != null) {
                child.preOrder();
                child = child.getNext();
            }
        }

        /**
         * Realiza a travessia em pós-ordem a partir do nó atual.
         */
        public void postOrder() {
            TreeNode child = firstChild;
            while (child != null) {
                child.postOrder();
                child = child.getNext();
            }
            System.out.print(data + " ");
        }

        /**
         * Retorna a altura do nó a partir de sua posição na árvore.
         *
         * @return A altura do nó.
         */
        public int height() {
            int maxHeight = -1; // Caso base, no mínimo altura 0.
            TreeNode child = firstChild;
            while (child != null) {
                maxHeight = Math.max(maxHeight, child.height());
                child = child.getNext();
            }
            return maxHeight + 1; // Adiciona um ao máximo para contar o próprio nó.
        }
    }
}
