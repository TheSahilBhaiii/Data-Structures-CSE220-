// Complete the levelSum method
//ASSIGNMENT TASK MUST SUBMIT
public class Task6 {

    //===================================TASK#6===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer levelSum( BTNode root ){
        return calc(root, -1);
    }
    private static int calc(BTNode node, int sign){
        if(node==null){
            return 0;
        }
        int value=(Integer)node.elem;

        return sign*value+calc(node.left,-sign)+calc(node.right,-sign);
    }
    }
    //============================================================================


