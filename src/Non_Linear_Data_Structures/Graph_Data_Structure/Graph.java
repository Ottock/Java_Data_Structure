package Non_Linear_Data_Structures.Graph_Data_Structure;

import java.util.*;

public class Graph {
    private final ArrayList<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public void printGraph() {
        System.out.println("Grafo:");
        for (Vertex vertex : vertices) {
            System.out.print(vertex.getData() + " -> ");
            List<Edge> edges = vertex.getEdgeList();
            if (edges.isEmpty()) {
                System.out.print("sem arestas");
            } else {
                for (Edge edge : edges) {
                    System.out.print(edge.getEnd().getData() + "(" + edge.getWeight() + ") ");
                }
            }
            System.out.println();
        }
    }

    public void printAdjacencyMatrix() {
        int numVertices = vertices.size();
        int[][] adjacencyMatrix = new int[numVertices][numVertices];
    
        // Preencher a matriz de adjacência
        for (int i = 0; i < numVertices; i++) {
            Vertex vertex = vertices.get(i);
            for (Edge edge : vertex.getEdgeList()) {
                int j = vertices.indexOf(edge.getEnd());
                adjacencyMatrix[i][j] = edge.getWeight();
            }
        }
    
        // Exibir a matriz de adjacência
        System.out.println("Matriz de Adjacência:");
        System.out.print("  ");
        for (Vertex vertex : vertices) {
            System.out.print(vertex.getData() + " ");
        }
        System.out.println();
        
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices.get(i).getData() + " ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    

    public class Vertex {
        private final String data;
        private final List<Edge> edges;

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

    public class Edge {
        private final Vertex start;
        private final Vertex end;
        private final int weight;

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

        public Vertex getStart() {
            return start;
        }
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    // BFS - Busca em Largura
    public void bfs(Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.getData() + " ");

            for (Edge edge : current.getEdgeList()) {
                Vertex neighbor = edge.getEnd();
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS - Busca em Profundidade
    public void dfs(Vertex start) {
        Set<Vertex> visited = new HashSet<>();
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(Vertex vertex, Set<Vertex> visited) {
        visited.add(vertex);
        System.out.print(vertex.getData() + " ");
        
        for (Edge edge : vertex.getEdgeList()) {
            Vertex neighbor = edge.getEnd();
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // Dijkstra - Algoritmo de Dijkstra sem PriorityQueue
    public void dijkstra(Vertex start) {
        int numVertices = vertices.size();
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[vertices.indexOf(start)] = 0;

        for (int i = 0; i < numVertices; i++) {
            int u = getMinDistanceVertex(distances, visited);
            visited[u] = true;

            for (Edge edge : vertices.get(u).getEdgeList()) {
                int v = vertices.indexOf(edge.getEnd());
                if (!visited[v] && distances[u] + edge.getWeight() < distances[v]) {
                    distances[v] = distances[u] + edge.getWeight();
                }
            }
        }

        System.out.println("Distâncias a partir do vértice " + start.getData() + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Distância até " + vertices.get(i).getData() + ": " + distances[i]);
        }
    }

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

    // Kruskal - Algoritmo de Kruskal
    public void kruskal() {
        List<Edge> edges = new ArrayList<>();
        for (Vertex vertex : vertices) {
            edges.addAll(vertex.getEdgeList());
        }

        // Ordenar as arestas por peso
        edges.sort(Comparator.comparingInt(Edge::getWeight));

        // Implementação do Union-Find
        UnionFind uf = new UnionFind(vertices.size());
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            int startIdx = vertices.indexOf(edge.getStart());
            int endIdx = vertices.indexOf(edge.getEnd());

            if (uf.find(startIdx) != uf.find(endIdx)) {
                uf.union(startIdx, endIdx);
                mst.add(edge);
            }
        }

        System.out.println("Árvore Geradora Mínima (Kruskal):");
        for (Edge edge : mst) {
            System.out.println(edge.getStart().getData() + " - " + edge.getEnd().getData() + " (" + edge.getWeight() + ")");
        }
    }

    // Prim - Algoritmo de Prim
    public void prim(Vertex start) {
        Set<Vertex> inMST = new HashSet<>();
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        inMST.add(start);
        for (Edge edge : start.getEdgeList()) {
            edgeQueue.add(edge);
        }

        List<Edge> mst = new ArrayList<>();

        while (inMST.size() < vertices.size()) {
            Edge edge = edgeQueue.poll();
            Vertex v = edge.getEnd();

            if (!inMST.contains(v)) {
                inMST.add(v);
                mst.add(edge);
                for (Edge nextEdge : v.getEdgeList()) {
                    if (!inMST.contains(nextEdge.getEnd())) {
                        edgeQueue.add(nextEdge);
                    }
                }
            }
        }

        System.out.println("Árvore Geradora Mínima (Prim):");
        for (Edge edge : mst) {
            System.out.println(edge.getStart().getData() + " - " + edge.getEnd().getData() + " (" + edge.getWeight() + ")");
        }
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if (rootI != rootJ) {
                if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else {
                    parent[rootJ] = rootI;
                    rank[rootI]++;
                }
            }
        }
    }
}
