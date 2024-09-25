// src/HeapSort_Data_Structure/Heaps.java
package HeapSort_Data_Structure;

// Imports

public class HeapSort {

    /**
     * Ordena o array usando o algoritmo HeapSort.
     *
     * @param arr O array de inteiros a ser ordenado.
     */
    public void sort(int[] arr) {
        int n = arr.length;

        // Constrói o heap (rearranja o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrai um elemento do heap de cada vez
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual (o maior elemento) para o final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Chama o heapify na árvore reduzida
            heapify(arr, i, 0);
        }
    }

    /**
     * "Heapifica" uma subárvore com a raiz no índice i.
     * Esse método garante que a subárvore com raiz no índice i seja um heap.
     *
     * @param arr O array de inteiros.
     * @param n   Tamanho do heap.
     * @param i   Índice da raiz da subárvore.
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i;  // Inicializa o maior como raiz
        int left = 2 * i + 1;  // Filho à esquerda
        int right = 2 * i + 2;  // Filho à direita

        // Se o filho à esquerda é maior que a raiz
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Se o filho à direita é maior que o maior até agora
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Se o maior não for a raiz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente heapifica a subárvore afetada
            heapify(arr, n, largest);
        }
    }

    /**
     * Método principal para testar o HeapSort.
     *
     * @param args Argumentos de linha de comando (não utilizado).
     */
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Array original:");
        printArray(arr);

        heapSort.sort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }

    /**
     * Função auxiliar para imprimir o array.
     *
     * @param arr O array a ser impresso.
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
