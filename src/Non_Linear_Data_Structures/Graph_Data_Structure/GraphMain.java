package Non_Linear_Data_Structures.Graph_Data_Structure;

public class GraphMain {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Graph.Vertex A = graph.new Vertex("A");
        Graph.Vertex B = graph.new Vertex("B");
        Graph.Vertex C = graph.new Vertex("C");
        Graph.Vertex D = graph.new Vertex("D");

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);

        A.addEdge(graph.new Edge(A, B, 1));
        A.addEdge(graph.new Edge(A, C, 4));
        B.addEdge(graph.new Edge(B, C, 2));
        B.addEdge(graph.new Edge(B, D, 5));
        C.addEdge(graph.new Edge(C, D, 3));

        System.out.println(">> Resultado da Busca em Largura (BFS):");
        graph.bfs(A);
        
        System.out.println("\n>> Resultado da Busca em Profundidade (DFS):");
        graph.dfs(A);

        System.out.println("\n>> Resultado do Algoritmo de Kruskal:");
        graph.kruskal();

        System.out.println("\n>> Resultado do Algoritmo de Prim:");
        graph.prim(A);
    }
}
