// src/Non_Linear_DataStructures/Graph_Data_Structure/Graphs.java
package Non_Linear_Data_Structures.Graph_Data_Structure;

// Import
import java.util.*;

public class Graph {
    // Atributos
    private ArrayList<Vertex> vertices;

    // Construtor
    public Graph() {
        this.vertices = new ArrayList<>();
    }

    // Classe Vertex
    public class Vertex {
        private String data;
        private List<Edge> edges;

        public Vertex(String data) {
            this.data = data;
            this.edges = new ArrayList<>();
        }
        
        public String getData() {
            return data;
        }

        public List<Edge> getEdgeList() {
            return edges;
        }

        public void addEdge(Edge edge) {
            edges.add(edge);
        }
    }

    // Classe Edge
    public class Edge {
        private Vertex start;
        private Vertex end;
        private int weight;

        public Edge(Vertex start, Vertex end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        
        public Vertex getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }
    }

    // Adiciona um vértice ao grafo
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    // Implementação do algoritmo de Dijkstra sem PriorityQueue
    public void dijkstra(Vertex start) {
        int numVertices = vertices.size();
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[vertices.indexOf(start)] = 0;

        // Enquanto existirem vértices não visitados
        for (int i = 0; i < numVertices; i++) {
            // Seleciona o vértice não visitado com a menor distância
            int u = getMinDistanceVertex(distances, visited);
            visited[u] = true;

            // Atualiza as distâncias dos vizinhos do vértice u
            for (Edge edge : vertices.get(u).getEdgeList()) {
                int v = vertices.indexOf(edge.getEnd());
                if (!visited[v] && distances[u] + edge.getWeight() < distances[v]) {
                    distances[v] = distances[u] + edge.getWeight();
                }
            }
        }

        // Exibe as distâncias
        System.out.println("Distâncias a partir do vértice " + start.getData() + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Distância até " + vertices.get(i).getData() + ": " + distances[i]);
        }
    }

    // Método auxiliar para obter o índice do vértice com a menor distância
    private int getMinDistanceVertex(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < min) {
                min = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
