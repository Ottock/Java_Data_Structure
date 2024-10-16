// src/Linear_Data_Structures.LinkedList_Data_Structure/LinkedListMain.java
package Linear_Data_Structures.LinkedList_Data_Structure;

public class LinkedListMain {
    public static void main(String[] args) {
        // Criação da lista ligada
        LinkedList list = new LinkedList();

        // Adicionando elementos à lista
        System.out.println("Adicionando elementos:");
        list.add(10);
        list.add(20);
        list.add(30);
        list.printList();  // Deve imprimir: 10 -> 20 -> 30

        // Removendo um elemento
        System.out.println("\nRemovendo o elemento 20:");
        list.remove(20);
        list.printList();  // Deve imprimir: 10 -> 30

        // Tentando remover um elemento que não existe
        System.out.println("\nTentando remover o elemento 40 (não existe):");
        list.remove(40);  // Deve imprimir: Elemento não encontrado.

        // Adicionando mais elementos
        System.out.println("\nAdicionando elementos 40 e 50:");
        list.add(40);
        list.add(50);
        list.printList();  // Deve imprimir: 10 -> 30 -> 40 -> 50

        // Verificando o tamanho da lista
        System.out.println("\nTamanho da lista: " + list.getSize());  // Deve imprimir: 4
    }
}
