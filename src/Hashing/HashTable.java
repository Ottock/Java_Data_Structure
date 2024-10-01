package Hashing;

/**
 * Classe HashTable para implementar uma tabela hash simples.
 */
public class HashTable {
    private Object[] tabHash;  // Usaremos Object para generalizar sem < >
    private int size;

    /**
     * Construtor que inicializa a tabela hash com um tamanho específico.
     * @param size Tamanho da tabela hash.
     */
    public HashTable(int size) {
        this.size = size;
        tabHash = new Object[size];  // Cria um array de Object
    }

    /**
     * Função de hash que calcula o índice baseado na chave fornecida.
     * @param key Chave utilizada para gerar o índice.
     * @return O índice calculado para a chave na tabela hash.
     */
    public int hash(Object key) {
        return key.hashCode() % size;
    }

    /**
     * Método para inserir um valor na tabela hash baseado em sua chave.
     * @param key A chave do valor.
     * @param value O valor a ser inserido.
     */
    public void insert(Object key, Object value) {
        int index = hash(key);
        while (tabHash[index] != null) {
            index = (index + 1) % size;  // Probing linear para evitar colisões
        }
        tabHash[index] = value;
        System.out.println("Chave: " + key + " inserida no índice " + index);
    }

    /**
     * Método para buscar um valor na tabela hash baseado em sua chave.
     * @param key A chave do valor.
     * @return O valor correspondente à chave ou null se não for encontrado.
     */
    public Object search(Object key) {
        int index = hash(key);
        int initialIndex = index;
        while (tabHash[index] != null) {
            if (tabHash[index].equals(key)) {
                return tabHash[index];
            }
            index = (index + 1) % size;
            if (index == initialIndex) {
                break;  // Evita loop infinito
            }
        }
        return null;
    }

    /**
     * Método para deletar um valor da tabela hash baseado em sua chave.
     * @param key A chave do valor a ser deletado.
     */
    public void delete(Object key) {
        int index = hash(key);
        int initialIndex = index;
        while (tabHash[index] != null) {
            if (tabHash[index].equals(key)) {
                System.out.println("Chave: " + key + " removida do índice " + index);
                tabHash[index] = null;
                return;
            }
            index = (index + 1) % size;
            if (index == initialIndex) {
                break;
            }
        }
        System.out.println("Chave: " + key + " não encontrada.");
    }

    /**
     * Exibe todos os elementos não nulos da tabela hash.
     */
    public void display() {
        for (int i = 0; i < tabHash.length; i++) {
            if (tabHash[i] != null) {
                System.out.println("Índice = " + i + " ==> Valor armazenado na tabela hash: " + tabHash[i]);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] tabKeys = {100, 180, 260};
        String[] tabNomes = {"Ana", "Ivo", "Ari"};

        // Cria uma tabela hash com tamanho 80
        HashTable hashTable = new HashTable(80);

        // Insere os valores na tabela hash
        for (int i = 0; i < tabKeys.length; i++) {
            hashTable.insert(tabKeys[i], tabNomes[i]);
        }

        // Exibe os valores armazenados na tabela hash
        hashTable.display();

        // Busca um valor
        System.out.println("Buscando a chave 180: " + hashTable.search(180));

        // Deleta um valor
        hashTable.delete(180);

        // Exibe os valores armazenados na tabela hash após a deleção
        hashTable.display();
    }
}
