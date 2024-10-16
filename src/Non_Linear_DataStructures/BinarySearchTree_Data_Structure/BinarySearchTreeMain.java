// src/BinarySearchTree/TreeMain.java
package Non_Linear_DataStructures.BinarySearchTree_Data_Structure;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        // Criando a árvore
        BinarySearchTree tree = new BinarySearchTree();

        // Criando os nós da árvore
        BinarySearchTree.BSTNode root = new BinarySearchTree.BSTNode(10);
        BinarySearchTree.BSTNode node1 = new BinarySearchTree.BSTNode(5);
        BinarySearchTree.BSTNode node2 = new BinarySearchTree.BSTNode(20);
        BinarySearchTree.BSTNode node3 = new BinarySearchTree.BSTNode(3);
        BinarySearchTree.BSTNode node4 = new BinarySearchTree.BSTNode(7);
        BinarySearchTree.BSTNode node5 = new BinarySearchTree.BSTNode(15);

        // Configurando a raiz da árvore
        tree.setRoot(root);

        tree.addNode(root, node1);
        tree.addNode(root, node2);
        tree.addNode(node1, node3);
        tree.addNode(node1, node4);

        // Imprimindo a árvore em ordem
        System.out.println("Árvore em ordem:");
        tree.inOrder();

        // Imprimindo a árvore em pré-ordem
        System.out.println("\nÁrvore em pré-ordem:");
        tree.preOrder();

        // Imprimindo a árvore em pós-ordem
        System.out.println("\nÁrvore em pós-ordem:");
        tree.postOrder();

        // Imprimindo a árvore visualmente
        System.out.println("\nÁrvore visual:");
        tree.printTree();

        // Testando remoção de nó
        System.out.println("\nEstrutura da árvore após remover o nó 5:");
        tree.removeNode(node5.getData());
        tree.printTree();

        // Testando se a árvore está vazia
        System.out.println("\nA árvore está vazia? " + (tree.isEmpty() ? "Sim" : "Não"));

        // Exibindo tamanho da árvore
        System.out.println("Tamanho da árvore: " + tree.getSize());

    }
}
