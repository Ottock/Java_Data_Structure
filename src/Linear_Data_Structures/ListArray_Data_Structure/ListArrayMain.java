// src/Linear_Data_Structures.ListArray_Data_Structure/Main.java
package Linear_Data_Structures.ListArray_Data_Structure;

public class ListArrayMain {
    public static void main(String[] args) {
        // Cria uma nova instância de ListArray com capacidade inicial de 5
        ListArray test = new ListArray(5);

        // Exibe a Lista
        System.out.print(">> Lista: ");
        test.print();

        // Insere valores para a Lista
        test.insert(0, 5);
        test.insert(1, 4);
        test.insert(2, 2);
        test.insert(3, 1);
        test.insert(4, 0);

        // Exibe a Lista
        System.out.print(">> Lista com valores inseridos: ");
        test.print();

        // Adiciona valores na Lista
        test.add(8);
        test.add(9);
        test.add(99);

        // Exibe a Lista
        System.out.print(">> Lista com valores adicionados: ");
        test.print();

        // Two Sum
        System.out.print(">> Two Sum 6: ");
        test.twoSum(6).print();

        // Bubble Sort
        test.bubbleSort();
        test.print();

        // Busca linear
        System.out.println(">> Chave 2: "+test.linearSearch(2));

        // Busca binaria
        System.out.println(">> Chave 3: "+test.binarySearch(3, 0, test.getSize()));

    }
}
