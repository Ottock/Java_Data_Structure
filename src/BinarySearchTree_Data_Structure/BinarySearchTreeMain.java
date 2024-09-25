// src/BinarySearchTree/TreeMain.java
package BinarySearchTree_Data_Structure;

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
        BinarySearchTree.BSTNode node6 = new BinarySearchTree.BSTNode(12);
        BinarySearchTree.BSTNode node7 = new BinarySearchTree.BSTNode(17);


        // Configurando a raiz da árvore
        tree.setRoot(root);

        tree.addNode(root, node1);
        tree.addNode(root, node2);
        tree.addNode(node1, node3);
        tree.addNode(node1, node4);

        tree.printTree();

    }
}
