public class TaskSchedulerWithPriority {
    static class Task{
        String name;
        int priority;
        public Task(String name,int priority){
            this.name=name;
            this.priority=priority;
        }
    }
    public static String[] scheduleTasks(String[]task_names,int[]priorities){
        int n=task_names.length;
        MaxHeap maxHeap=new MaxHeap(n);

        for(int i=0;i<n;i++){
            Task t = new Task(task_names[i], priorities[i]);
            maxHeap.insert(t);
        }
        String []result=new String[n];
        for (int i = 0; i < n; i++) {
            Task t = maxHeap.extractMax();
            result[i] = t.name;
        }

        return result;
    }
}
