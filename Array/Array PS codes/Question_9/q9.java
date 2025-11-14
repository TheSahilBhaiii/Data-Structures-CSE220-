import java.util.Scanner;
public class q9{
    public static void main(String[] args){
      Scanner sc=new Scanner(System.in);

      System.out.println("What will be length of the array?");
        int N=sc.nextInt();
        int arr[]=new int[N];
        System.out.println("Enter Array Elements");
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int counter=0;
        int checker=N/2;

         for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    if(arr[i]==arr[j]){
                        counter++;
                        continue;
                    }
                    else{
                        continue;
                    }
                }
            }
        
        
        if(counter>0&&counter>checker){
            System.out.println("Output: "+counter);
        }
        else{
            System.out.println("Output: -1");
        }
    }
}
