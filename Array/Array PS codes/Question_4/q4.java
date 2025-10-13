import java.util.Scanner;
public class q4{
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       
       System.out.println("What will be the limit of the array");
       int N=sc.nextInt();
       int arr[]=new int[N];
       int counter=0
       
       System.out.println("Enter Array elements");
       for(int i=0;i<N;i++){
        arr[i]=sc.nextInt();
       }
       System.out.println("Which number's frequency are you trying to find?");
       int X=sc.nextInt();

       for(int i=0;i<N;i++){
        if(X==arr[i]){
            counter++;
        }
        else{
            continue;
        }
       }
       System.out.println("Output: "+counter);
    }
}