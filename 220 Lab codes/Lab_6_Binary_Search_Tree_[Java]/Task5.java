//Assignment Task (must Submit)
// Complete the sumOfLeaves method
public class Task5 {

    //===================================TASK#5======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Integer mirrorSum( BSTNode root ){
       if(root==null){
        return 0;
       }
       return mirrorPairSum(root.left,root.right);
    }
    private static int mirrorPairSum(BSTNode x,BSTNode y){
        if(x==null || y==null){
            return 0;
        }
        int a=(Integer)x.elem;
        int b=(Integer)y.elem;

        return(a+b)+mirrorPairSum(x.left, y.right)+mirrorPairSum(x.right, y.left);
    }
    //===============================================================


}
