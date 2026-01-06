//Assignment Task (must Submit)
// Complete the isBST method
public class Task6 {

    //===================================TASK#6======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Boolean isBST( BSTNode root ){
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private static boolean checkBST(BSTNode node,long min,long max){
        if(node==null){
            return true;
        }
        long value=(Integer)node.elem;

        if(value<=min || value>=max){
            return false;
        }
        return checkBST(node.left, min, value) && checkBST(node.right, value, max);
    }
    //===============================================================


}
