import java.util.*;

class Vertex{
    int vertex;
    int val;
    Vertex(int vertex, int val){
        this.vertex = vertex;
        this.val = val;
    }
}

class Graph{
    int V;
    final private LinkedList<Vertex> adjList[];
    Graph(int V){
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    public void add(int a, int b, int val){
        Vertex v1 = new Vertex(b, val);
        Vertex v2 = new Vertex(a, val);
        adjList[a].add(v1);
        adjList[b].add(v2);
    }

    public int gradeOfEdge(int a){
        int result = 0;
        for (int i = 0; i < V; i++) {
            for (Vertex vertex : adjList[i]) {
                if (vertex.vertex == a){
                    result++;
                }
            }
        }
        return result;
    }

    public void recursionDFS(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");
        for(Vertex vertex : adjList[v]){
            if (visited[vertex.vertex] == false){
                recursionDFS(vertex.vertex, visited);
            }
        }
    }

    public void getRecursionDFS(int v){
        boolean[] visted = new boolean[V];
        recursionDFS(v, visted);
    }

    public void DFS(int v){
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> vertexStack = new Stack<>();
        vertexStack.push(v);
        while(!vertexStack.isEmpty()){
            Integer current = vertexStack.pop();
            if (visited.add(current)){
                System.out.print(current + " ");
                for (Vertex i : adjList[current]){
                    vertexStack.push(i.vertex);
                }
            }
        }
    }

//    public void recursionBFS(int v, boolean[] visited){
//        visited[v] = true;
//        System.out.print(v + " ");
//
//        for (Vertex neighbor : adjList[v]) {
//            if (visited[neighbor.vertex] == false) {
//                recursionBFS(neighbor.vertex, visited);
//            }
//        }
//    }
//
//    public void getRecursionBFS(int v){
//        boolean[] visited = new boolean[V];
//        recursionBFS(v, visited);
//    }

    public void BFS(int v){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> vertexQueue = new LinkedList<>();
        vertexQueue.add(v);
        while(!vertexQueue.isEmpty()){
            int current = vertexQueue.poll();
            if (visited.add(current)){
                System.out.print(current + " ");
                for (Vertex i : adjList[current]){
                    vertexQueue.add(i.vertex);
                }
            }
        }
    }

    public boolean Connectivity(){
        List<Integer> connect = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> vertexStack = new Stack<>();
        vertexStack.push(adjList[0].get(0).vertex);
        while(!vertexStack.isEmpty()){
            Integer current = vertexStack.pop();
            if (visited.add(current)){
                connect.add(current);
                for (Vertex i : adjList[current]){
                    vertexStack.push(i.vertex);
                }
            }
        }
        return (connect.size() == V) ? true : false;
    }

    public void countConnectivity(){
        if (Connectivity()){
            for (int i = 0; i < V; i++){
                System.out.print(i + ": ");
                for (Vertex j : adjList[i]){
                    System.out.print(j.vertex + ", ");
                }
                System.out.println("");
            }
        }else{
            System.out.println("Not connect");
        }
    }

    public void numberOfConnectivity(){
        List<List<Integer>> connectedComponents = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                List<Integer> graph = new ArrayList<>();
                recursiveDFSTraversal(i, visited, graph);
                connectedComponents.add(graph);
            }
        }

        for (List<Integer> i : connectedComponents){
            System.out.println(i);
        }
    }

    public void recursiveDFSTraversal(int vertex, boolean[] visited, List<Integer> graph) {
        visited[vertex] = true;
        graph.add(vertex);

        for (Vertex neighbor : adjList[vertex]) {
            if (visited[neighbor.vertex] == false) {
                recursiveDFSTraversal(neighbor.vertex, visited, graph);
            }
        }
    }

    public void recursionDijkstra(int end){
        int[] distance = new int[V];

        for (int i = 0; i < V; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;

        for (int i = 0; i < V; i++){
            for (Vertex vertex : adjList[i]){
                if (vertex.val + distance[i] < distance[vertex.vertex]){
                    distance[vertex.vertex] = vertex.val + distance[i];
                }
            }
        }

        System.out.println(distance[end]);
    }

    public void getDijkstra(int end){
        recursionDijkstra(end);
    }

    public void print(){
        for (int i = 0; i < V; i++) {
            System.out.print(i + ": ");
            for (Vertex vertex : adjList[i]) {
                System.out.print("[" + vertex.vertex + ", " + vertex.val + "]" + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int V = 8;
        Graph gl = new Graph(V);
        gl.add(0, 2, 2);
        gl.add(0, 1, 3);
        gl.add(0, 3, 5);
        gl.add(1, 3, 1);
        gl.add(1, 4, 4);
        gl.add(2, 5, 1);
        gl.add(2, 3, 2);
        gl.add(3, 4, 3);
        gl.add(4, 5, 2);
        gl.add(6, 7, 7);

        gl.print();

        System.out.println("");
        System.out.println("Grade: ");
        System.out.println(gl.gradeOfEdge(0));

        System.out.println("");
        System.out.println("DFS:");
        gl.DFS(0);
        System.out.println("");
        System.out.println("RECURSION DFS:");
        gl.getRecursionDFS(0);

        System.out.println("");
        System.out.println("");
        System.out.println("BFS:");
        gl.BFS(1);
//        System.out.println("");
//        System.out.println("RECURSION BFS");
//        gl.getRecursionBFS(1);

        System.out.println("");
        System.out.println("");
        System.out.println("Dijkstra:");
        gl.getDijkstra(4);

        System.out.println("");
        if (gl.Connectivity()){
            System.out.println("Connectivity");
        }else{
            System.out.println("Not connectivity");
        }
        System.out.println("");
        System.out.println("Count connectivity:");
        gl.countConnectivity();
        System.out.println("");
        gl.numberOfConnectivity();
    }
}