// src/Tree_Data_Structure/TreeMain.java
package Tree_Data_Structure;

public class TreeMain {
    public static void main(String[] args) {
        // Criando a árvore
        Tree tree = new Tree();

        // Criando os nós da árvore
        Tree.TreeNode root = new Tree.TreeNode(10);
        Tree.TreeNode node1 = new Tree.TreeNode(5);
        Tree.TreeNode node2 = new Tree.TreeNode(20);
        Tree.TreeNode node3 = new Tree.TreeNode(3);
        Tree.TreeNode node4 = new Tree.TreeNode(7);
        Tree.TreeNode node5 = new Tree.TreeNode(15);
        Tree.TreeNode node6 = new Tree.TreeNode(12);
        Tree.TreeNode node7 = new Tree.TreeNode(17);

        // Configurando a raiz da árvore
        tree.setRoot(root);

        // Adicionando nós à árvore
        tree.addNode(root, node1);   // Adicionando node1 como filho de root
        tree.addNode(root, node2);   // Adicionando node2 como filho de root
        tree.addNode(node1, node3);  // Adicionando node3 como filho de node1
        tree.addNode(node1, node4);  // Adicionando node4 como filho de node1
        tree.addNode(node2, node5);  // Adicionando node5 como filho de node2
        tree.addNode(node2, node6);  // Adicionando node6 como filho de node5
        tree.addNode(node2, node7);  // Adicionando node7 como filho de node5

        // Tamanho da árvore
        System.out.println("Tamanho da árvore: " + tree.getSize());

        // Verificando se a árvore está vazia
        System.out.println("A árvore está vazia? " + tree.isEmpty());

        // Altura da árvore
        System.out.println("Altura da árvore: " + tree.height());

        // Valor máximo da árvore
        System.out.println("Valor máximo na árvore: " + tree.maxValue());

        // Valor mínimo da árvore
        System.out.println("Valor mínimo na árvore: " + tree.minValue());

        // Travessia em Pre-Order
        System.out.print("Travessia em Pre-Order: ");
        tree.preOrder();
        System.out.println();

        // Travessia em Post-Order
        System.out.print("Travessia em Post-Order: ");
        tree.postOrder();
        System.out.println();

        // Imprimindo árvore
        System.out.println("Estrutura da árvore:");
        tree.printTree();

        // Removendo um nó
        tree.removeNode(node4);
        System.out.println("Tamanho da árvore após remover node4: " + tree.getSize());

        // Imprimindo árvore após remoção
        System.out.println("Estrutura da árvore após remoção:");
        tree.printTree();
    }
}
