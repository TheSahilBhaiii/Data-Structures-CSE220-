import java.util.Scanner;
public class q2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); 

        System.out.println("What will be the Number of Elements?");
        int N=sc.nextInt();
        int arr[]=new int[N];
        int pos[]=new int[N];
        int neg[]=new int[N];
        int c1=0;
        int c2=0;
        System.out.println("Enter elements");
        for(int i=0;i<N;i++){
        arr[i]=sc.nextInt();
        }
        

        for(int i=0;i<N;i++){
          if(arr[i]>0){
            pos[c1]=arr[i];
            c1++;
          }
        else{
            neg[c2]=arr[i];
            c2++;
        }
        }
        for(int i=0;i<N;i++){
            if(i<c1){
            System.out.print(pos[i]+" ");
        }
        else{
            break;
        }
    }
    for(int i=0;i<N;i++){
            if(i<c2){
            System.out.print(neg[i]+" ");
        }
        else{
            break;
        }
    }
}
}
