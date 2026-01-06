public class MaxHeap{
    private int [] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity){
        this.capacity=capacity;
        size=0;
        this.heap=new int[capacity];
    }
    public boolean isEmpty(){
        return size==0;
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return 2*i+1;
    }
    private int rightChild(int i){
        return 2*i+2;
}
private void swap(int arr[],int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
public void insert(int val){
    if(size==capacity){
        System.out.println("Heap is full");
        return;
    }
    heap[size]=val;
    size++;

    swim(size-1,this.heap);
}
public int extractMax(){
    int max=heap[0];
    heap[0]=heap[size-1];
    size--;

    sink(0,this.size,this.heap);
    return max;
}
private void swim(int k,int[]arr){
    while(k>0 && arr[parent(k)]<arr[k]){
        swap(arr,k,parent(k));
        k=parent(k);
    }
}
private void sink(int k,int currentSize,int[] arr){
    while(leftChild(k)<currentSize){
        int j=leftChild(k);
    if(j+1<currentSize && arr[j+1]>arr[j]){
        j++;
    }
    if(arr[k]>=arr[j]){
        break;
    }
    swap(arr,k,j);
    k=j;
}
}
}

