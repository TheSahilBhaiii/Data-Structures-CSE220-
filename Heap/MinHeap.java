public class MinHeap{
    private int[] H;
    private int size;

    MinHeap(int L){
        H=new int[(int)Math.pow(2,L)];
        size=0;
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
            swap(H,p,idx);
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
    public boolean isEmpty(){
        return size==0;
    }
    }
