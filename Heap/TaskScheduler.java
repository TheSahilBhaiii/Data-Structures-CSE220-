public class TaskScheduler{
    public static int[]scheduleTasks(int []tasks,int m){
        MinHeap mn=new MinHeap(m);

        for(int i=0;i<m;i++){
            mn.insert(0);
        }
        for(int i=0;i<tasks.length;i++){
            int minLoad=mn.extractMin();
            minLoad+=tasks[i];
            mn.insert(minLoad);
        }
        int result[]=new int[m];
        for(int i=0;i<m;i++){
            result[i]=mn.extractMin();
        }
        return result;
}
public static void main(String[] args) {
    // Create a heap with capacity 10
    MaxHeap maxHeap = new MaxHeap(10);

    // Insert random numbers
    System.out.println("Inserting: 15, 3, 10, 20, 8");
    maxHeap.insert(15);
    maxHeap.insert(3);
    maxHeap.insert(10);
    maxHeap.insert(20);
    maxHeap.insert(8);

    // Extract them (Should come out sorted Descending)
    System.out.print("Extracted: ");
    while (!maxHeap.isEmpty()) {
        System.out.print(maxHeap.extractMax() + " ");
    }
    // Expected Output: 20 15 10 8 3
}
}
