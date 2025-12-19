//Before starting to work on this design the Tree in the Tester code 
// Complete the sumOfLeaves method
public class Task2 {

    //===================================TASK#2===================================
    // This method takes only 2 parameters
    // 1st one is root
    // 2nd one is an Integer
    // You'll need to find the path from the root to a node containing the Integer
    // return the path as a String
    public static String findPath( BSTNode root, Integer key ){
        String r1="";
        String r2="No Path Found";

        while(root!=null){
            r1+=root.elem+" ";
            if(root.elem==key){
                return r1;
            }
            else if(root.elem<key){
                root=root.right;
            }
            else if(root.elem>key){
                root=root.left;
            }
        }
        return r2; //remove this line
    }
    //============================================================================

}
