// src/ListArray_Data_Structure/ListArray.java
package ListArray_Data_Structure;

public class ListArray {
    private int[] data;
    private int size;

    /**
     * Constrói um array com a capacidade inicial fornecida.
     *
     * @param capacity a capacidade inicial do array
     */
    public ListArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * Retorna o número de elementos no array.
     *
     * @return o tamanho atual do array
     */
    public int getSize() {
        return size;
    }

    /**
     * Retorna a capacidade do array.
     *
     * @return a capacidade do array
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * Verifica se o array está vazio.
     *
     * @return verdadeiro se o array estiver vazio, falso caso contrário
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adiciona um elemento ao array na posição especificada.
     *
     * @param index a posição onde o elemento deve ser adicionado
     * @param value o elemento a ser adicionado
     * @throws IllegalArgumentException se o índice estiver fora dos limites
     */
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Índice fora dos limites.");
        }
        if (size == data.length) {
            resize(2 * data.length); // Dobra o tamanho do array se estiver cheio
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    /**
     * Adiciona um elemento ao final do array.
     *
     * @param value o elemento a ser adicionado
     */
    public void addLast(int value) {
        add(size, value);
    }

    /**
     * Adiciona um elemento ao início do array.
     *
     * @param value o elemento a ser adicionado
     */
    public void addFirst(int value) {
        add(0, value);
    }

    /**
     * Recupera o elemento na posição especificada.
     *
     * @param index o índice do elemento a ser recuperado
     * @return o elemento na posição especificada
     * @throws IllegalArgumentException se o índice estiver fora dos limites
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Índice fora dos limites.");
        }
        return data[index];
    }

    /**
     * Atualiza o elemento na posição especificada.
     *
     * @param index o índice do elemento a ser atualizado
     * @param value o novo valor a ser definido
     * @throws IllegalArgumentException se o índice estiver fora dos limites
     */
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Índice fora dos limites.");
        }
        data[index] = value;
    }

    /**
     * Remove o elemento na posição especificada e o retorna.
     *
     * @param index o índice do elemento a ser removido
     * @return o elemento removido
     * @throws IllegalArgumentException se o índice estiver fora dos limites
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Índice fora dos limites.");
        }
        int removedElement = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = 0; // Opcional: Redefine a última posição para zero
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2); // Reduz o tamanho do array se estiver 1/4 cheio
        }
        return removedElement;
    }

    /**
     * Remove o primeiro elemento do array.
     *
     * @return o elemento removido
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * Remove o último elemento do array.
     *
     * @return o elemento removido
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * Redimensiona o array para a nova capacidade especificada.
     *
     * @param newCapacity a nova capacidade do array
     */
    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * Retorna uma representação em string do array.
     *
     * @return uma string que contém todos os elementos do array
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: tamanho = %d, capacidade = %d\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
