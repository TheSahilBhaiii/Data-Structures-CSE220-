public class GraphDemo {
    public static void main(String[] args) {
        int[][] adjMatrix={
                {0, 1, 1, 1, 1, 1, 1}, 
                {1, 0, 1, 0, 0, 0, 0}, 
                {1, 1, 0, 1, 0, 1, 0}, 
                {1, 0, 1, 0, 1, 0, 0}, 
                {1, 0, 0, 1, 0, 1, 0}, 
                {1, 0, 1, 0, 1, 0, 1}, 
                {1, 0, 0, 0, 0, 1, 0}  
        };
        int V = 5; // number of vertices
        EdgeNode[] adjList = new EdgeNode[V]; // array of adjacency lists

        // Add edges (undirected)
        GraphUtils.addEdge(adjList, 1, 3, 0);
        GraphUtils.addEdge(adjList, 1, 4, 0);
        GraphUtils.addEdge(adjList, 1, 5, 0);
        GraphUtils.addEdge(adjList, 1, 2, 0);
        GraphUtils.addEdge(adjList, 1, 7, 0);
        GraphUtils.addEdge(adjList, 1, 6, 0);
        GraphUtils.addEdge(adjList, 2, 3, 0);
        GraphUtils.addEdge(adjList, 3, 4, 0);
        GraphUtils.addEdge(adjList, 4, 5, 0);
        GraphUtils.addEdge(adjList, 5, 6, 0);
        GraphUtils.addEdge(adjList, 6, 7, 0);
        GraphUtils.addEdge(adjList, 3, 6, 0);

        // Show adjacency list
        System.out.println("Adjacency List Representation:");
        GraphUtils.showAdjList(adjList);
    }

}