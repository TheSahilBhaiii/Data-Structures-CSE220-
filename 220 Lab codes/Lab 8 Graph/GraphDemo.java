public class GraphDemo {
    public static void main(String[] args) {
        
        System.out.println("--- SETUP: Undirected Graph ---");
        int[][] undirectedMatrix = {
            {0, 5, 0},
            {5, 0, 10},
            {0, 10, 0}
        }; 

        int V = 3;
        EdgeNode[] undirectedList = new EdgeNode[V];
        GraphUtils.addEdge(undirectedList, 0, 1, 5);
        GraphUtils.addEdge(undirectedList, 1, 2, 10);

        
        System.out.println("\n--- TASK 2: Max Weight Vertex (Undirected) ---");
        GraphUtils.task2a_MaxWeightVertexMatrix(undirectedMatrix);
        GraphUtils.task2b_MaxWeightVertexList(undirectedList);


        System.out.println("\n--- SETUP: Directed Graph ---");
        int[][] directedMatrix = {
            {0, 3, 0},
            {2, 0, 4},
            {0, 0, 0}
        };
        
        EdgeNode[] directedList = new EdgeNode[V];
        GraphUtils.addEdgeDirected(directedList, 0, 1, 3);
        GraphUtils.addEdgeDirected(directedList, 1, 0, 2);
        GraphUtils.addEdgeDirected(directedList, 1, 2, 4);

        System.out.println("Directed Adjacency List:");
        GraphUtils.showAdjList(directedList);
        System.out.println("\n--- TASK 3: Max Outgoing Weight Vertex (Directed) ---");
        GraphUtils.task3a_MaxOutWeightVertexMatrix(directedMatrix);
        GraphUtils.task3b_MaxOutWeightVertexList(directedList);
        System.out.println("\n--- TASK 4: Convert Directed to Undirected ---");
        int[][] convertedMatrix = GraphUtils.task4a_ConvertToUndirectedMatrix(directedMatrix);
        System.out.println("Converted Matrix (Expected: 0-1 weight should be 3+2=5):");
        GraphUtils.showAdjMatrix(convertedMatrix);
        EdgeNode[] convertedList = GraphUtils.task4b_ConvertToUndirectedList(directedList);
        System.out.println("Converted List (Expected: 0->1 w:5, 1->0 w:5, 1->2 w:4, 2->1 w:4):");
        GraphUtils.showAdjList(convertedList);
    }
}