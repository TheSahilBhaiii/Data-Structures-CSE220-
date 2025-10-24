import java.util.Scanner;
public class q10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int counter=1;
        System.out.println("Enter Array Length: ");
        int N=sc.nextInt();
        int arr[]=new int[N];
        System.out.println("Enter Array Elements: ");

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int temp=arr[i+1];
            if(arr[temp]<N){
                counter++;
            }
            else{
                counter++;
                break;
            }
        }
        System.out.println(counter);
}
}

