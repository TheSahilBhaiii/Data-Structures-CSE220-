import java.util.Scanner;
public class q8 {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);

      System.out.println("What will be length of the array?");
        int N=sc.nextInt();
        int arr[]=new int[N];
        System.out.println("Enter Array Elements");
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<N-1;i+=2){
            int temp=arr[i+1];
            arr[i+1]=arr[i];
            arr[i]=temp;
        }
        for(int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
