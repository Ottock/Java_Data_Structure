// src/LinkedList_Data_Structure/LinkedList.java
package LinkedList_Data_Structure;

/**
 * Uma classe LinkedList que representa uma estrutura de dados de lista encadeada.
 * Esta classe fornece métodos para adicionar, remover e percorrer nós na lista.
 */
public class LinkedList {
    private Node head; // Nó inicial da lista
    private int size;  // Tamanho da lista

    /**
     * Constrói uma LinkedList vazia.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Adiciona um novo nó ao final da lista.
     *
     * @param data os dados a serem armazenados no novo nó
     */
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // Se a lista estiver vazia, o novo nó se torna o head
        } else {
            Node current = head;
            while (current.next != null) { // Percorre até o final da lista
                current = current.next;
            }
            current.next = newNode; // Adiciona o novo nó ao final
        }
        size++; // Incrementa o tamanho da lista
    }

    /**
     * Remove um nó da lista com base no valor fornecido.
     *
     * @param data o valor do nó a ser removido
     */
    public void remove(int data) {
        if (head == null) return; // Se a lista estiver vazia, não faz nada

        if (head.data == data) { // Se o nó a ser removido é o head
            head = head.next; // Atualiza o head para o próximo nó
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) { // Percorre a lista
            if (current.next.data == data) { // Verifica se o próximo nó é o que deve ser removido
                current.next = current.next.next; // Remove o nó
                size--;
                return;
            }
            current = current.next;
        }
    }

    /**
     * Retorna o tamanho da lista.
     *
     * @return o tamanho da lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Imprime os elementos da lista.
     */
    public void printList() {
        Node current = head;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("]");
    }

    /**
     * Uma classe Node que representa um nó na lista encadeada.
     */
    private static class Node {
        private int data;  // Dados do nó
        private Node next; // Referência para o próximo nó

        /**
         * Constrói um Node com dados especificados.
         *
         * @param data os dados a serem armazenados neste nó
         */
        public Node(int data) {
            this.data = data;
            this.next = null; // Inicializa o próximo nó como nulo
        }
    }
}
