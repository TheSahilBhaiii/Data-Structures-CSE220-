import java.util.Scanner;
public class q7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("What will be length of the array?");
        int N=sc.nextInt();
        int arr[]=new int[N];
        System.out.println("Enter Array Elements");
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        int left[]=new int[N];
        int right[]=new int[N];

        left[0]=arr[0];
        for(int i=1;i<N;i++){
            left[i]=Math.max(left[i-1],arr[i]);
        }
        right[N-1]=arr[N-1];
        for(int i=N-2;i>=0;i--){
         right[i]=Math.max(right[i+1],arr[i]);

        }
        int ans=0;

        for(int i=0;i<N;i++){
            ans+=(Math.min(left[i],right[i])-arr[i]);
        }
        System.out.println("Output: "+ans);
        

    }
}
