import java.util.Scanner;
public class q3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int starting_counter=0;
        int ending_counter=0;
        System.out.println("Enter the length of the array");
        int N=sc.nextInt();
        System.out.println("Which number ?");
        int S=sc.nextInt();
        int arr[]=new int[N];
        System.out.println("Enter Array Elements:");
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<N;i++){
            if(sum<S){
                sum+=arr[i];
                starting_counter=1;
                ending_counter=i+1;
                continue;
            }
            else if(sum==S){
                break;
            }
            else if(sum>S){
                sum-=arr[i];
                starting_counter+=1;
                continue;
            }
        }
        System.out.println("Output: "+starting_counter+" "+ending_counter);
        

    }
    
}
