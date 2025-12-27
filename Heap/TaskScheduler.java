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
}