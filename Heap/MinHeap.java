public class MinHeap{
<<<<<<< HEAD
    private int [] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity){
        this.capacity=capacity;
        size=0;
        this.heap=new int[capacity];
    }
=======
    private Object[] H;
    private int size;
    private int level;

    MinHeap(int L){
        H=new Object[2*Math.pow(L)];
        size=0;
        level=L;
    }
    public void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void insert(int elem){
        size++;
        H[size]=elem;
        swim(size);
    }
    public void swim(int idx){
        int p=idx/2;
        if(p==0){
            return;
        }
        else if(H[p]>H[idx]){
            swap(H[p],H[idx]);
            swim(p);
        }
    }
    public int entractMin(){
        int d=H[1];
        H[1]=H[size];
        H[size--]=0;
        sink(1);
        return d;
    }
    public void sink(int idx){
        int l=2*idx;
        int r=2*idx+1;
        int smallest=idx;
        if (l <= size && H[l] < H[smallest]) {
            smallest = l;
        }
        if (r <= size && H[r] < H[smallest]) {
            smallest = r;
        }
        if (smallest != idx) {
            swap(H, smallest, idx);
            sink(smallest);
        }
    }   
>>>>>>> bd51a3745fccb11ae298e365f3367f9fd701f1a9
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
    }
    heap[size]=val;
    size++;

    swim(size-1,this.heap);
}
public int extractMin(){
    int min=heap[0];
    heap[0]=heap[size-1];
    size--;

    sink(0,this.size,this.heap);
    return min;
}
private void swim(int k,int[]arr){
    while(k>0 && arr[parent(k)]>arr[k]){
        swap(arr,k,parent(k));
        k=parent(k);
    }
}
private void sink(int k,int currentSize,int[] arr){
    while(leftChild(k)<currentSize){
        int j=leftChild(k);
    if(j+1<currentSize && arr[j+1]<arr[j]){
        j++;
    }
    if(arr[k]<=arr[j]){
        break;
    }
    swap(arr,k,j);
    k=j;
}
}
