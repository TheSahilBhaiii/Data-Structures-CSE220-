import java.util.Scanner;
public class q6 {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       
       System.out.println("Enter Input of the Array");
       int N=sc.nextInt();

       int arr[]=new int[N];
       System.out.println("Enter Array elements");
       for(int i=0;i<N;i++){
        arr[i]=sc.nextInt();
       }


       //Bubble sort

       for(int i=0;i<N-1;i++){
        for(int j=0;j<N-1-i;j++){
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
       }
       for(int i=0;i<N;i++){
        System.out.print(arr[i]+" ");
       }
    }
}
