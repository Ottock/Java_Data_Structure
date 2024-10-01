// src/HeapSort_Data_Structure/Heaps.java
package HeapSort_Data_Structure;

// Imports

public class HeapSort {

    /**
     * Ordena o array usando o algoritmo HeapSort (MaxHeap).
     *
     * @param arr O array de inteiros a ser ordenado.
     */
    public void sortMaxHeap(int[] arr) {
        int n = arr.length;

        // Constrói o heap (rearranja o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }

        // Extrai um elemento do heap de cada vez
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual (o maior elemento) para o final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Chama o heapify na árvore reduzida
            maxHeapify(arr, i, 0);
        }
    }

    /**
     * Ordena o array usando o algoritmo HeapSort (MinHeap).
     *
     * @param arr O array de inteiros a ser ordenado.
     */
    public void sortMinHeap(int[] arr) {
        int n = arr.length;

        // Constrói o heap (rearranja o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(arr, n, i);
        }

        // Extrai um elemento do heap de cada vez
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual (o menor elemento) para o final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Chama o heapify na árvore reduzida
            minHeapify(arr, i, 0);
        }
    }

    /**
     * "Heapifica" uma subárvore com a raiz no índice i (MaxHeap).
     *
     * @param arr O array de inteiros.
     * @param n   Tamanho do heap.
     * @param i   Índice da raiz da subárvore.
     */
    private void maxHeapify(int[] arr, int n, int i) {
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
            maxHeapify(arr, n, largest);
        }
    }

    /**
     * "Heapifica" uma subárvore com a raiz no índice i (MinHeap).
     *
     * @param arr O array de inteiros.
     * @param n   Tamanho do heap.
     * @param i   Índice da raiz da subárvore.
     */
    private void minHeapify(int[] arr, int n, int i) {
        int smallest = i;  // Inicializa o menor como raiz
        int left = 2 * i + 1;  // Filho à esquerda
        int right = 2 * i + 2;  // Filho à direita

        // Se o filho à esquerda é menor que a raiz
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // Se o filho à direita é menor que o menor até agora
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // Se o menor não for a raiz
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // Recursivamente heapifica a subárvore afetada
            minHeapify(arr, n, smallest);
        }
    }

    /**
     * Método principal para testar o HeapSort.
     *
     * @param args Argumentos de linha de comando (não utilizado).
     */
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arrMax = {12, 11, 13, 5, 6, 7};
        int[] arrMin = {12, 11, 13, 5, 6, 7};

        System.out.println("Array original:");
        printArray(arrMax);

        heapSort.sortMaxHeap(arrMax);
        System.out.println("Array ordenado (MaxHeap):");
        printArray(arrMax);

        heapSort.sortMinHeap(arrMin);
        System.out.println("Array ordenado (MinHeap):");
        printArray(arrMin);
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
