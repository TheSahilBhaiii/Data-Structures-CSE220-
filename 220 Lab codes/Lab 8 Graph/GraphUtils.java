import java.util.Arrays;

class GraphUtils {
    public static void printLL(EdgeNode head) {
        EdgeNode n = head;
        while (n != null) {
            System.out.print(" -> (" + n.toV + ", w:" + n.weight + ")");
            n = n.next;
        }
        System.out.println();
    }

    public static void appendLL(EdgeNode head, EdgeNode eNode) {
        EdgeNode n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = eNode;
    }


    public static void addEdge(EdgeNode[] adjList, int from, int to, int weight) {
        addEdgeDirected(adjList, from, to, weight);
        addEdgeDirected(adjList, to, from, weight);
    }


    public static void addEdgeDirected(EdgeNode[] adjList, int from, int to, int weight) {
        EdgeNode newNode = new EdgeNode(to, weight);
        if (adjList[from] == null) {
            adjList[from] = newNode;
        } else {
            appendLL(adjList[from], newNode);
        }
    }

    public static void showAdjList(EdgeNode[] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + ":");
            printLL(adjList[i]);
        }
    }

    public static void showAdjMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
// Task 2a: Adjacency Matrix
    public static int task2a_MaxWeightVertexMatrix(int[][] adjMatrix) {
        int maxVertex = -1;
        int maxWeightSum = -1;

        for (int i = 0; i < adjMatrix.length; i++) {
            int currentSum = 0;
            for (int j = 0; j < adjMatrix[i].length; j++) {
                currentSum += adjMatrix[i][j];
            }

            if (currentSum > maxWeightSum) {
                maxWeightSum = currentSum;
                maxVertex = i;
            }
        }
        System.out.println("Task 2a (Matrix) - Vertex with max weight: " + maxVertex + " (Sum: " + maxWeightSum + ")");
        return maxVertex;
    }

 // Task 2b: Adjacency List   
    public static int task2b_MaxWeightVertexList(EdgeNode[] adjList) {
        int maxVertex = -1;
        int maxWeightSum = -1;

        for (int i = 0; i < adjList.length; i++) {
            int currentSum = 0;
            EdgeNode curr = adjList[i];
            
            while (curr != null) {
                currentSum += curr.weight;
                curr = curr.next;
            }

            if (currentSum > maxWeightSum) {
                maxWeightSum = currentSum;
                maxVertex = i;
            }
        }
        System.out.println("Task 2b (List) - Vertex with max weight: " + maxVertex + " (Sum: " + maxWeightSum + ")");
        return maxVertex;
    }
// Task 3a: Adjacency Matrix (Directed)
    public static int task3a_MaxOutWeightVertexMatrix(int[][] adjMatrix) {
        System.out.print("Task 3a (Directed Matrix) -> ");
        return task2a_MaxWeightVertexMatrix(adjMatrix);
    }

// Task 3b: Adjacency List (Directed)   
    public static int task3b_MaxOutWeightVertexList(EdgeNode[] adjList) {
        System.out.print("Task 3b (Directed List) -> ");
        return task2b_MaxWeightVertexList(adjList);
    }

// Task 4a: Adjacency Matrix Conversion
    public static int[][] task4a_ConvertToUndirectedMatrix(int[][] directedMatrix) {
        int V = directedMatrix.length;
        int[][] undirectedMatrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                undirectedMatrix[i][j] = directedMatrix[i][j] + directedMatrix[j][i];
            }
        }
        System.out.println("Task 4a: Matrix Converted.");
        return undirectedMatrix;
    }
// Task 4b: Adjacency List Conversion
    private static void addOrUpdateEdge(EdgeNode[] list, int u, int v, int w) {
        if (list[u] == null) {
            list[u] = new EdgeNode(v, w);
            return;
        }
        
        EdgeNode curr = list[u];
        while (true) {
            if (curr.toV == v) {
                curr.weight += w;
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new EdgeNode(v, w);
    }

    public static EdgeNode[] task4b_ConvertToUndirectedList(EdgeNode[] directedList) {
        int V = directedList.length;
        EdgeNode[] undirectedList = new EdgeNode[V];
        for (int u = 0; u < V; u++) {
            EdgeNode curr = directedList[u];
            while (curr != null) {
                int v = curr.toV;
                int w = curr.weight;
                addOrUpdateEdge(undirectedList, u, v, w);
                addOrUpdateEdge(undirectedList, v, u, w);

                curr = curr.next;
            }
        }
        System.out.println("Task 4b: List Converted.");
        return undirectedList;
    }
}