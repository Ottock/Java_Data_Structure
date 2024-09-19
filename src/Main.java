// src/Main.java

// Imports
import Tree_Data_Structure.*;
import Tree_Data_Structure.Tree.TreeNode.*;

public class Main {
    public static void main(String[] args) {
        // Criando a Arvore
        Tree.TreeNode root = new Tree.TreeNode(0);
        Tree test = new Tree(root);

        Tree.TreeNode a = new Tree.TreeNode(1);
        Tree.TreeNode b = new Tree.TreeNode(2);
        Tree.TreeNode c = new Tree.TreeNode(3);
        Tree.TreeNode d = new Tree.TreeNode(4);
        Tree.TreeNode e = new Tree.TreeNode(5);

        test.addNode(root, a);
        test.addNode(root, b);
        test.addNode(root, c);
        test.addNode(b, d);
        test.addNode(b, e);

        test.preOrder();
        test.postOrder();

        System.out.println(test.minValue());
        System.out.println(test.maxValue());

    }
}