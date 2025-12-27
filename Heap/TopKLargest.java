public class TopKLargest {
    public static int[] topKLargest(int[]nums, int k){
        MaxHeap maxHeap=new Maxheap(nums.length);

        for(int i=0;i<nums.length;i++){
            maxHeap.insert(nums[i]);
        }
        int[]result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=maxHeap.entractMax();
        }
        return result;
    }
}
