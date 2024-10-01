// src/ListArray_Data_Structure/Main.java
package ListArray_Data_Structure;

public class ListArrayMain {
    public static void main(String[] args) {
        // Cria uma nova instância de ListArray com capacidade inicial de 5
        ListArray list = new ListArray(5);

        // Adiciona elementos ao array
        System.out.println("Adicionando elementos:");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println(list);

        // Adiciona um elemento na posição 1
        list.add(1, 15);
        System.out.println("Após adicionar 15 na posição 1:");
        System.out.println(list);

        // Acessa um elemento
        int valueAtIndex2 = list.get(2);
        System.out.println("Elemento na posição 2: " + valueAtIndex2);

        // Atualiza um elemento
        list.set(2, 25);
        System.out.println("Após atualizar o elemento na posição 2 para 25:");
        System.out.println(list);

        // Remove um elemento
        int removedElement = list.remove(1);
        System.out.println("Removido o elemento na posição 1: " + removedElement);
        System.out.println("Após remoção:");
        System.out.println(list);

        // Remove o primeiro e o último elemento
        int firstRemoved = list.removeFirst();
        int lastRemoved = list.removeLast();
        System.out.println("Removido primeiro elemento: " + firstRemoved);
        System.out.println("Removido último elemento: " + lastRemoved);
        System.out.println("Após remoções:");
        System.out.println(list);

        // Mostra o tamanho e a capacidade do array
        System.out.println("Tamanho atual: " + list.getSize());
        System.out.println("Capacidade atual: " + list.getCapacity());
    }
}
