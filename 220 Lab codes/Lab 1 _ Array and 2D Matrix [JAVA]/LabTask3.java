//Lab Task 03: Decryption Process
class LabTask3{

    //Complete this method so that it gives the Expected Output
    public static Integer[] decryptMatrix( Integer[][] matrix ){

        int M=matrix.length;
        int N=matrix[0].length;
        int sum[]=new int[N];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
            sum[i]+=matrix[j][i];
            }
        }
        Integer decryptedarr[]=new Integer[N-1];
        for(int i=0;i<N-1;i++){
        decryptedarr[i]=sum[i+1]-sum[i];
        }

        return decryptedarr;

    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            {1,3,1},
            {6,4,2},
            {5,1,7},
            {9,3,3},
            {8,5,4}
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        System.out.println("\nExpected Output:\n[ -13 1 ]");
        Integer[] returned_val_1 = decryptMatrix( matrix );
        System.out.print("\nYour Output:\n");
        Arr.print(returned_val_1);

    }
}