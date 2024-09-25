// src/BinaryTree_Data_Structure/Main.java
package BinaryTree_Data_Structure;

public class BinaryTreeMain {
    public static void main(String[] args) {
        // Criação de uma nova árvore binária
        BinaryTree tree = new BinaryTree();

        // Criando alguns nós
        BinaryTree.BinaryNode node10 = new BinaryTree.BinaryNode(10);
        BinaryTree.BinaryNode node5 = new BinaryTree.BinaryNode(5);
        BinaryTree.BinaryNode node15 = new BinaryTree.BinaryNode(15);
        BinaryTree.BinaryNode node3 = new BinaryTree.BinaryNode(3);
        BinaryTree.BinaryNode node7 = new BinaryTree.BinaryNode(7);
        BinaryTree.BinaryNode node12 = new BinaryTree.BinaryNode(12);
        BinaryTree.BinaryNode node17 = new BinaryTree.BinaryNode(17);

        // Adicionando nós à árvore
        tree.setRoot(node10);
        tree.addNode(node10, node5);
        tree.addNode(node10, node15);
        tree.addNode(node5, node3);
        tree.addNode(node5, node7);
        tree.addNode(node15, node12);
        tree.addNode(node15, node17);

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

        // Testando a função de valor máximo e mínimo
        System.out.println("\nValor máximo: " + tree.maxValue());
        System.out.println("Valor mínimo: " + tree.minValue());

        // Testando remoção de nó
        System.out.println("\nEstrutura da árvore após remover o nó 5:");
        tree.removeNode(node5);
        tree.printTree();

        // Testando se a árvore está vazia
        System.out.println("\nA árvore está vazia? " + (tree.isEmpty() ? "Sim" : "Não"));

        // Exibindo tamanho da árvore
        System.out.println("Tamanho da árvore: " + tree.getSize());
    }
}
