public class TopKLargest {
    public static int[] topKLargest(int[]nums, int k){
       MaxHeap np=new MaxHeap(nums.length);

       for(int i=0;i<nums.length;i++){
        np.insert(nums[i]);
       }
       int res[]=new int[k];
       for(int i=0;i<k;i++){
        res[i]=np.extractMax();
       }
       return res;
    }
    public static void main(String[] args) {
        int[] input = {3, 10, 5, 20, 8};
        int k = 3;
        
        int[] result = topKLargest(input, k);
        
        // Should print: 20, 10, 8
        System.out.print("Top " + k + " largest: ");
        for(int n : result) {
            System.out.print(n + " ");
        }
    }
}

