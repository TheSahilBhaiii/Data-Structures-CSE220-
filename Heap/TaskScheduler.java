public class TaskScheduler{
    public static int[]scheduleTasks(int []tasks,int m){
        MinHeap minHeap=new MinHeap(m);

        for(int i=0;i<m;i++){
            minHeap.insert(0);
        }
        for(int i=0;i<tasks.length;i++){
            int minLoad=minHeap.entractMin();
            minload+=taska[i];
            minHeap.insert(minLoad);
        }
        int[] result=new int[m];
        for(int i=0;i<m;i++){
            result[i]=minHeap.extractMin();

        }
        return result;
    }

    public static void main(String[] args) {
        int[] tasks = {2, 4, 7, 1, 6};
        int m = 4;
        int[] result = scheduleTasks(tasks, m);
        
        for (int i = 0; i < m; i++) {
            System.out.print(result[i] + " ");
        }
}