// src/Linear_Data_Structures.ListArray_Data_Structure/ListArray.java
package Linear_Data_Structures.ListArray_Data_Structure;

public class ListArray {
    // Atributos
    private int[] data;
    private int size;

    // Construtor
    public ListArray() {
        /**
         * Construtor padrão que inicializa a Lista vazia.
         */
        data = null;
        size = 0;
    }

    public ListArray(int capacity) {
        /**
         * Construtor que inicializa a Lista com sua capacidade máxima.
         * @param int capacity: Valor que demonstra a capacidade da Lista.
         */
        data = new int[capacity];
        size = capacity;
    }

    // Setters
    public void setData(int index, int value) {
        /**
         * Método Setter que insere um valor em um dado índice.
         * @param int index: Índice que o valor será setado.
         * @param int value: Valor que será adicionado na Lista.
         */
        this.data[index] = value;
    }

    public void setSize(int size) {
        /**
         * Método Setter que altera o valor do tamanho da Lista.
         * @param int size: Valor que o tamanho da Lista terá.
         */
        this.size = size;
    }

    // Getters
    public int getData(int index) {
        /**
         * Método Getter que retorna o valor de um valor no index.
         * @param int index: Índice do valor que será retornado.
         */
        return this.data[index];
    }

    public int getSize() {
        /**
         * Método Getter que retorna o valor da Lista.
         */
        return size;
    }

    public int getCapacity() {
        /**
         * Método Getter que retorna a capacidade que a Lista suporta.
         */
        return data.length;
    }

    // Métodos e Funções
    public boolean isEmpty() {
        /**
         * Método que verifica se a Lista está vazia ou não.
         */
        return size == 0;
    }

    public boolean isFull() {
        /**
         * Função que retorna se a Lista está cheia ou não.
         */
        return size == data.length;
    }

    public void add(int value) {
        /**
         * Adiciona um valor ao final da lista.
         * @param value Valor a ser adicionado.
         */
        if (this.isEmpty()) {
            this.data = new int[1];
            this.data[0] = value;
            this.size = 1;
            return;
        }

        if (this.size == this.data.length) {
            int[] newData = new int[this.size * 2];

            for (int i = 0; i < this.size; i++) {
                newData[i] = this.data[i];
            }
            this.data = newData;
        }

        this.data[this.size] = value;
        this.size++;
    }

    public void insert(int index, int value) {
        /**
         * Metodo que insere dados na lista em uma posição específica.
         * @param int index: Posição que será inserido o valor;
         * @param int value: Dado a ser inserido.
         */
        if (this.isEmpty()) {
            this.data = new int[1];
            this.data[0] = value;
        } else if (index > this.data.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }

        this.data[index] = value;
    }

    public void reorder() {
        /**
         * Método que inverte a ordem dos elementos da Lista
         */
        int temp;
        int n = this.size;

        for (int i = 0; i < this.size / 2; i++) {
            temp = this.data[i];
            this.data[i] = this.data[n - 1 - i];
            this.data[n - 1 - i] = temp;
        }
    }

    public void print() {
        /**
         * Método que imprime no terminal se a Lista não estiver vazia.
         * Big-O = O(n)
         */
        if (this.isEmpty()) {
            System.out.println(">> Lista vazia");
            return;
        }

        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println("]");
    }

    public void printReverse() {
        /**
         * Método que imprime no terminal a Lista em ordem invertida.
         * Big-O = O(n)
         */
        if (this.isEmpty()) {
            System.out.println(">> Lista vazia");
            return;
        }

        System.out.print("[ ");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println("]");
    }

    public ListArray twoSum(int key) {
        ListArray res = new ListArray(2);

        for (int i = 0; i < this.size; i++) {
            for (int j = i + 1; j < this.size; j++) {
                if(this.data[i] + this.data[j] == key) {
                    res.data[0] = i;
                    res.data[1] = j;
                    return res;
                }
            }
        }
        res.data[0] = -1;
        res.data[1] = -1;
        return res;
    }

    public void bubbleSort() {
        /**
         * Método que realiza a ordenação Bubble Sort.
         * Neste método de ordenação, cria-se uma "bolha" entre o elemento na posição i e na sua proxima posição,
         * e verifica se e necessario realizar a troca para
         * Caso o elemento i seja maior que o pro
         * Big-O = O(n2).
         */
        if (this.isEmpty()) {
            System.out.println(">> Lista vazia");
            return;
        }

        for (int i = 0; i < this.size; i++) {
            for (int j = i+1; j < this.size; j++) {
                if (this.data[i] > this.data[j]) {
                    int temp = this.data[j];
                    this.data[j] = this.data[i];
                    this.data[i] = temp;
                }
            }
        }
    }

    public void selectionSort() {
        if (this.isEmpty()) {
            System.out.println(">> Lista vazia");
        }

        for (int i = 0; i < this.size; i++) {
            for (int j = i + 1; j < this.size; j++) {
                if (this.data[j] < this.data[i]) {
                    int temp = this.data[i];
                    this.data[i] = this.data[j];
                    this.data[j] = temp;
                }
            }
        }
    }

    public void insertionSort() {
        if (this.isEmpty()) {
            System.out.println(">> Lista vazia");
        }

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (this.data[j] < this.data[j - 1]) {
                    int temp = this.data[j];
                    this.data[j] = this.data[j - 1];
                    this.data[j - 1] = temp;
                }
            }
        }
    }

    public int linearSearch(int key) {
        /**
         * Função que realiza uma busca linear na Lista para encontrar o valor key, retornando sua posição.
         * @param int key: Valor a ser procurado na Lista.
         */
        if (this.isEmpty()) {
            System.out.println(">> Lista vazia");
            return -1;
        }

        for (int i = 0; i < size; i++) {
            if (this.data[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int key, int start, int end) {
        /**
         * Função que realiza uma busca binária na Lista para encontrar o valor key, retornando sua posição.
         * @param int key: Valor a ser procurado na Lista.
         * @param int start: Início da faixa de busca.
         * @param int end: Fim da faixa de busca.
         * @return int: Posição do valor na lista ou -1 se não encontrado.
         */
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (this.data[mid] == key) {
            return mid;
        }

        if (key > this.data[mid]) {
            return binarySearch(key, mid + 1, end);
        }

        return binarySearch(key, start, mid - 1);
    }

}
