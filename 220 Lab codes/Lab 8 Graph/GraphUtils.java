// GraphUtils.java
class GraphUtils {
    // Print a single adjacency list (linked list)
    public static void printLL(EdgeNode head) {
        EdgeNode n = head;
        while (n != null) {
            System.out.print(" -> (" + n.toV + "," + n.weight + ")");
            n = n.next;
        }
        System.out.println();
    }

    // Append a new edge node to adjacency list
    public static void appendLL(EdgeNode head, EdgeNode eNode) {
        EdgeNode n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = eNode;
    }

    // Add an edge to adjacency list (undirected graph)
    public static void addEdge(EdgeNode[] adjList, int from, int to, int weight) {
        EdgeNode newNode = new EdgeNode(to, weight);
        if (adjList[from] == null) {
            adjList[from] = newNode;
        } else {
            GraphUtils.appendLL(adjList[from], newNode);
        }

        // For undirected graph: also add reverse edge
        EdgeNode reverseNode = new EdgeNode(from, weight);
        if (adjList[to] == null) {
            adjList[to] = reverseNode;
        } else {
            GraphUtils.appendLL(adjList[to], reverseNode);
        }
    }

    // Show adjacency list for all vertices
    public static void showAdjList(EdgeNode[] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + ":");
            printLL(adjList[i]);
        }
    }
}
