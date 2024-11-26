// src/Non_Linear_DataStructures/Graph_Data_Structure/GraphsMain.java
package Non_Linear_Data_Structures.Graph_Data_Structure;

public class GraphMain {
    public static void main(String[] args) {
        // Criando o grafo
        Graph graph = new Graph();
        
        // Criando vértices
        Graph.Vertex v1 = graph.new Vertex("A");
        Graph.Vertex v2 = graph.new Vertex("B");
        Graph.Vertex v3 = graph.new Vertex("C");
        Graph.Vertex v4 = graph.new Vertex("D");

        // Adicionando vértices ao grafo
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        // Criando arestas entre os vértices
        v1.addEdge(graph.new Edge(v1, v2, 10)); // A -> B (peso 10)
        v1.addEdge(graph.new Edge(v1, v3, 5));  // A -> C (peso 5)
        v2.addEdge(graph.new Edge(v2, v4, 2));  // B -> D (peso 2)
        v3.addEdge(graph.new Edge(v3, v2, 3));  // C -> B (peso 3)
        v3.addEdge(graph.new Edge(v3, v4, 9));  // C -> D (peso 9)
        v4.addEdge(graph.new Edge(v4, v1, 7));  // D -> A (peso 7)

        // Executando Dijkstra a partir do vértice "A"
        graph.dijkstra(v1);

        // O código deve exibir as distâncias mínimas de "A" até todos os outros vértices:
        // Distância até A: 0
        // Distância até B: 8
        // Distância até C: 5
        // Distância até D: 10
    }
}