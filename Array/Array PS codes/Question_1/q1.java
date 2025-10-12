import java.util.Scanner;
public class q1{
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("What is the length of the first array?");
        int len1=sc.nextInt();
        System.out.println("What is the length of the second array?");
        int len2=sc.nextInt();

        int a[]=new int[len1];
        int b[]=new int[len2];

        int count=len1+len2;

        System.out.println("Enter First Array elements:");
        for(int i=0;i<len1;i++){
            System.out.println("Element number:"+i);
            a[i]=sc.nextInt();
        }
        System.out.println("Enter Second Array elements:");
        for(int j=0;j<len2;j++){
            System.out.println("Element number:"+j);
            b[j]=sc.nextInt();
        }
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(a[i]==b[j]){
                    count--;
                }
                else{
                    continue;
                }
            }
        }
        System.out.println(count);
    }
}